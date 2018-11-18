/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help_tools;

import crypto.CaesarCipher;
import crypto.CaesarKey;
import crypto.Cipher;
import crypto.Key;
import java.util.Arrays;

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
            System.out.println("test MxV: "+ Arrays.toString( Matrix.MATxVEC(M, vec)));
        }
        public static void testCifer(){

            Key k = new CaesarKey();
            Cipher c = new CaesarCipher();
            String OT = "ukazkasifrovania";
            String ZT = c.encrypt(k, OT);
            System.out.println("ZT: "+ZT);
            OT = c.decrypt(k, ZT);
            System.out.println("OT: "+OT);
        }
}
