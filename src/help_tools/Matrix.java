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
    public static int determinant(int mat[][]){
        return 0;
    }
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
    
}
