/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help_tools;

import com.sun.glass.ui.Size;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Peter
 * pocitanie inverznej matice - zdroj kodu:
 * https://www.sanfoundry.com/java-program-find-inverse-matrix/
 * POCITANIE DETERMINANTU
 * https://www.sanfoundry.com/java-program-compute-determinant-matrix/
 */
public class Matrix {
    
    public static int[][] generateRandMat(int dim, int limit){
        Random rnd  = new Random(System.currentTimeMillis());
        int[][] mat = new int[dim][dim];
        for(int i = 0; i < dim; i++)
            for(int j = 0; j < dim; j++)
                mat[i][j] = rnd.nextInt(limit + 1);
        return mat;
    }
    public static void printMat(int [][] mat){
        for(int i = 0; i < mat.length;i++)
            System.out.println( (i + 1) +  "line: " + Arrays.toString(mat[i]) );
    }
//    public static int determinant(int mat[][]){
//        return 0;
//    }
    public static int[] MATxVEC(int mat[][], int [] vec){
        int[] output = new int[vec.length];
        //initialize output with 0
        for(int i:output)
            i=0;
        for(int i = 0;i < mat.length; i++){
            if(mat[i].length!= vec.length)
                return null;
            for(int j = 0; j < vec.length;j++)
                output[i] += vec[j]*mat[i][j];
        }
        return output;
    }
        public static int[] VECxMAT( int [] vec,int mat[][]){
        int[] output = new int[vec.length];
        //initialize output with 0
        for(int i:output)
            i=0;
        
        
        for(int i = 0, index = i, index2;i < mat.length*mat.length; i++){
//            if(mat[i/mat.length].length!= vec.length)
//                return null;
                index = i/mat.length;
                index2 = i%mat.length;
                output[index] += vec[index2]*mat[index2][index];
        }
        return output;
    }
public static int[][] invert(int a_int[][]) 
    {
          double[][] a = new double[a_int.length][a_int.length];
            for(int i = 0; i<a_int.length;i++){
                a[i] = Arrays.stream(a_int[i]).asDoubleStream().toArray();
            }
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i) 
            b[i][i] = 1;
 
 // Transform the matrix into an upper triangle
        gaussian(a, index);
 
 // Update the matrix b[i][j] with the ratios stored
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                    	    -= a[index[j]][i]*b[index[i]][k];
 
 // Perform backward substitutions
        for (int i=0; i<n; ++i) 
        {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j) 
            {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k) 
                {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
    int inIntM[][] = new int[x.length][x.length];

    for(int i = 0; i<x.length*x.length;i++){
        inIntM[i/x.length][i%x.length] = (int)x[i/x.length][i%x.length];
    }
        return inIntM;
    }
 
// Method to carry out the partial-pivoting Gaussian
// elimination.  Here index[] stores pivoting order.
 
    public static void gaussian(double a[][], int index[]) 
    {
        int n = index.length;
        double c[] = new double[n];
 
 // Initialize the index
        for (int i=0; i<n; ++i) 
            index[i] = i;
 
 // Find the rescaling factors, one from each row
        for (int i=0; i<n; ++i) 
        {
            double c1 = 0;
            for (int j=0; j<n; ++j) 
            {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }
 
 // Search the pivoting element from each column
        int k = 0;
        for (int j=0; j<n-1; ++j) 
        {
            double pi1 = 0;
            for (int i=j; i<n; ++i) 
            {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) 
                {
                    pi1 = pi0;
                    k = i;
                }
            }
 
   // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i) 	
            {
                double pj = a[index[i]][j]/a[index[j]][j];
 
 // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;
 
 // Modify other elements accordingly
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }

 
    public static int determinant(int A[][],int N)
    {
        int det=0;
        if(N == 1)
        {
            det = A[0][0];
        }
        else if (N == 2)
        {
            det = A[0][0]*A[1][1] - A[1][0]*A[0][1];
        }
        else
        {
            det=0;
            for(int j1=0;j1<N;j1++)
            {
                int[][] m = new int[N-1][];
                for(int k=0;k<(N-1);k++)
                {
                    m[k] = new int[N-1];
                }
                for(int i=1;i<N;i++)
                {
                    int j2=0;
                    for(int j=0;j<N;j++)
                    {
                        if(j == j1)
                            continue;
                        m[i-1][j2] = A[i][j];
                        j2++;
                    }
                }
                det += Math.pow(-1.0,1.0+j1+1.0)* A[0][j1] * determinant(m,N-1);
            }
        }
        return det;
    }     
}

