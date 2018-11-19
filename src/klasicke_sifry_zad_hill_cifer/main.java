/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klasicke_sifry_zad_hill_cifer;

import crypto.*;

import help_tools.Matrix;
import help_tools.Text;
import  help_tools.test;
import java.io.File;

/**
 *
 * @author Peter
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        test.testMat();
//        test.testCifer();
//        test.testVxM();
//        test.testMxV();
       //test.testHill();
           // test.testDeterminant();
        // test.testInverse();
         File file = Text.pickFromFileChooser();
        String str_file = Text.readText(file);
        System.err.println("bez zmeny txt: " + str_file);
        String[] strings = str_file.split("\n");
//        StringBuilder builder = new StringBuilder();
//        for(String s : strings)
//            builder.append(s);
        //str_file = Strin0
        str_file = Text.convertToTSA(str_file);
        //System.out.println("klasicke_sifry_zad_hill_cifer.main.main()" + str_file);
        test.testHillMyMat(str_file);
        
    }

    
}
