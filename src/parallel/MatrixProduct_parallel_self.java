package parallel;

import schedule.selfSchedule;
import schedule.selfSchedule.LoopRange;

public class MatrixProduct_parallel_self {
    private static final int M = 4096;
    private static final int N = 2048;
    private static final int P = 2048;

    private double[][] A, B, C;

    public MatrixProduct_parallel_self(double[][] A, double[][] B, double[][] C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public void initialize() {
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                this.A[i][j] = 1.0;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < P; j++)
                this.B[i][j] = 1.0;

        for (int i = 0; i < M; i++)
            for (int j = 0; j < P; j++)
                this.C[i][j] = 0.0;
    }

    public void multiplierMatrice(int numThreads, int groupSize) {
        selfSchedule schedule = new selfSchedule(0, M - 1, groupSize);
        Thread[] threads = new Thread[numThreads];

        for (int t = 0; t < numThreads; t++) {
            threads[t] = new Thread(new Runnable() {
                public void run() {
                    LoopRange range;
                    while ((range = schedule.loopGetRange()) != null) {
                        for (int i = range.start; i <= range.end; i++) {
                            for (int j = 0; j < P; j++) {
                                for (int k = 0; k < N; k++) {
                                    C[i][j] += A[i][k] * B[k][j];
                                }
                            }
                        }
                    }
                }
            });
            threads[t].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void print() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < P; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        double[][] A = new double[M][N];
        double[][] B = new double[N][P];
        double[][] C = new double[M][P];
        MatrixProduct_parallel_self matrixProduct = new MatrixProduct_parallel_self(A, B, C);
        matrixProduct.initialize();
        int numThreads = 30;
        int groupSize = 2048;
        matrixProduct.multiplierMatrice(numThreads, groupSize);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Temps d'exécution : " + (float) elapsedTime / 1000 + " s");
    }
}
