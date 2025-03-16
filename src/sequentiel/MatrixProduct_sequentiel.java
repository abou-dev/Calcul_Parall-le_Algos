/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequentiel;

/**
 *
 * @author boya
 */
/*
Ce programme séquentiel affectue la multiplication de la matrice A par la matrice B pour obtenir la matrice C.
La matrice A a pour dimension (M,N) : M étant le nombre de lignes et N étant le nombre de colonnes
La matrice B a pour dimension (N,P) : N étant le nombre de lignes et P étant le nombre de coloonnes
La matrice C a pour dimension (M,P) : M étant le nombre de lignes et P étant le nombre de colonnes
*/
public class MatrixProduct_sequentiel {
    private static final int M=4096;
    private static final int N=2048;
    private static final int P=2048;
//    private static final int M=32;
//    private static final int N=32;
//    private static final int P=16;
    
    private double[][] A, B, C;
    
    public MatrixProduct_sequentiel(double[][] A,double[][] B, double[][] C){
        this.A=A;
        this.B=B;
        this.C=C;
    }
    
    //Initialisation des matrices A, B, et C
    public void initialize(){
        //Initialisation de la matrice A
        for(int i=0;i<M;i++)
            for(int j=0;j<N;j++)
                this.A[i][j]=1.0;
        
        //Initialisation de la matrice B
        for(int i=0;i<N;i++) 
            for(int j=0;j<P;j++)
                this.B[i][j]=1.0;
        
        //Initialisation de la matrice C
        for(int i=0;i<M;i++) 
            for(int j=0;j<P;j++)
                this.C[i][j]=0.0;
    }
    
    //procedure pour multiplier les matrice A et B pour obtenir la matrice C
    public void multiplierMatrice(){
        for(int i=0;i<M;i++)
            for(int j=0;j<P;j++)
                for(int k=0;k<N;k++)
                    C[i][j]+=A[i][k]*B[k][j];
    }
    
    //Procedure pour afficher le resultat du produit de matrice C=A*B
    public void print(){
        for (int i=0;i<M;i++)    
        {            
            for(int j=0;j<P;j++){
                System.out.print(C[i][j]+" ");
            }
            System.out.println();        
        }      
                
    }
    
    public static void main(String args[]){
        long startTime = System.currentTimeMillis(); 
        double [][] A= new double[M][N];   
        double [][] B= new double[N][P];
        double [][] C= new double[M][P];
        MatrixProduct_sequentiel matrixProduct= new MatrixProduct_sequentiel(A,B,C);
        matrixProduct.initialize();
        matrixProduct.multiplierMatrice();        
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Temps d'execution : "+(float)elapsedTime/1000+" s");
                
    }
    
    
}
