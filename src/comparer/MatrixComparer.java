package comparer;

import parallel.MatrixProduct_parallel_self;
import parallel.MatrixProduct_parallel_static;
import sequentiel.MatrixProduct_sequentiel;

public class MatrixComparer {
    public static boolean compareMatrices(double[][] mat1, double[][] mat2) {
        if (mat1.length != mat2.length || mat1[0].length != mat2[0].length) {
            return false;
        }
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                if (mat1[i][j] != mat2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int M = 4096;
        int N = 2048;
        int P = 2048;

        // Initialiser les matrices pour les tests
        double[][] A = new double[M][N];
        double[][] B = new double[N][P];
        double[][] C_sequential = new double[M][P];
        double[][] C_parallel_static = new double[M][P];
        double[][] C_parallel_self = new double[M][P];

        // Initialiser le programme séquentiel
        MatrixProduct_sequentiel sequential = new MatrixProduct_sequentiel(A, B, C_sequential);
        sequential.initialize();
        sequential.multiplierMatrice();

        // Initialiser le programme parallèle static
        MatrixProduct_parallel_static parallel_static = new MatrixProduct_parallel_static(A, B, C_parallel_static);
        parallel_static.initialize();
        parallel_static.multiplierMatrice(8);

        // Initialiser le programme parallèle self
        MatrixProduct_parallel_self parallel_self = new MatrixProduct_parallel_self(A, B, C_parallel_self);
        parallel_self.initialize();
        parallel_self.multiplierMatrice(8, 128);

        // Comparer les matrices
        boolean isStaticEqual = compareMatrices(C_sequential, C_parallel_static);
        boolean isSelfEqual = compareMatrices(C_sequential, C_parallel_self);

        System.out.println("Static Schedule comparison result: " + isStaticEqual);
        System.out.println("Self Schedule comparison result: " + isSelfEqual);
    }
}
