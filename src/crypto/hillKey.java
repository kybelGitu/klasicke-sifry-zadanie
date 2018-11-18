/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import help_tools.Matrix;

/**
 *
 * @author Peter
 */
public class hillKey implements Key{
    int [][] Kmat;
    int modulo = 26;
    public void setMatKey(int size){
        this.Kmat = Matrix.generateRandMat(size, modulo);       
    }
    
}
