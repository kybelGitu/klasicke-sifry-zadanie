/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help_tools;

import crypto.CaesarCipher;
import crypto.CaesarKey;
import crypto.Cipher;
import crypto.HillCipher;
import crypto.HillKey;
import crypto.Key;
import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 *
 * @author Peter
 */
    public class test {
        public static void testMat(){
            int dimension = 3, limit = 10;
            int[][] testMat = new int[3][3];
            testMat = Matrix.generateRandMat(dimension, limit);
            Matrix.printMat(testMat);

        }
        public static void testVxM(){
            int[][] M = {{1,2},{3,4}};
            int vec[] = {2,3};
            System.out.println("test VxM: "+ Arrays.toString( Matrix.VECxMAT(vec,M)));
        }
        public static void testMxV(){
            int[][] M = {{1,2},{3,4}};
            int vec[] = {2,3};
            System.out.println("test MxV: "+ Arrays.toString( Matrix.MATxVEC(M, vec)));
        }
        public static void testCifer(){

            Key k = new CaesarKey();
            Cipher c = new CaesarCipher();
            String OT = "sss";
            String ZT = c.encrypt(k, OT);
            System.out.println("ZT: "+ZT);
            OT = c.decrypt(k, ZT);
            System.out.println("OT: "+OT);
        }
        public static void testHill(){

            HillKey k = new HillKey();
            k.setHillKey(2, 0);
            Cipher h = new HillCipher();
            String OT = "ukazkasifrovania";
            System.out.println("OT before: "+OT);
            String ZT = h.encrypt(k, OT);
            System.out.println("ZT: "+ZT);
            OT = h.decrypt(k, ZT);
            System.out.println("ZT: "+OT);
//            OT = h.decrypt(k, ZT);
//            System.out.println("OT: "+OT);
        }
        public static void testInverse(){
            int M[][] = Matrix.generateRandMat(2, 26);
//            double[][] DoublesM = new double[2][2];
//            for(int i = 0; i<2;i++){
//                DoublesM[i] = Arrays.stream(M[i]).asDoubleStream().toArray();
//            }

            int inM[][]= Matrix.invert(M);
            System.out.println("matica input");
            Matrix.printMat(M);
//            int inIntM[][] = new int[2][2];
//            
//            for(int i = 0; i<2*2;i++){
//                inIntM[i/2][i%2] = (int)inM[i/2][i%2];
//            }
            System.out.println("matica inverse");
            Matrix.printMat(inM);
        }
        public static void testDeterminant(){
               int M[][] = Matrix.generateRandMat(3, 26);
               System.out.println("determiantn");
               Matrix.printMat(M);
               int det = Matrix.determinant(M, 3);
               System.out.println("help_tools.test.testDeterminant() - value: " + det);
            
        }
        public static void testHillMyMat(String OT){
            HillKey k = new HillKey();
            int myMat[][] = {{5,6,22},{2,6,7},{12,19,7}};
            k.setMatrix(myMat);
            k.setHillKey(3, 0);
            
            Cipher h = new HillCipher();
            //String OT = "ukazkasifrovania";
            System.out.println("OT before: "+OT);
            String ZT = h.encrypt(k, OT);
            System.out.println("ZT: "+ZT);
            int myMat2[][] = {{13,22,4},{20,7,23},{20,25,20}};
            k.setMatrix(myMat2);
            //OT = h.decrypt(k, ZT);
            k.setHillKey(3, 26 - 0);
            OT = h.encrypt(k, ZT);
            
            System.out.println("OT odsifrovany: "+OT);
            
        }
        
}
