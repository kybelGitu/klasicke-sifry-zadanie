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

public class HillKey implements Key{

    int [][] Kmat;
    int sizeOfBlock = 3;
    int modulo = 26;
    CaesarKey cK = new CaesarKey();

    public void setHillKey(int sizeOfBlock,int offset){
        this.sizeOfBlock = sizeOfBlock;
        //this.Kmat = Matrix.generateRandMat(sizeOfBlock, modulo);       
        //this.cK.setOffset(int sizeOfBlock);
        this.cK.offset = offset;
    }
    public void setMatrix(int Kmat[][]){
        //this.Kmat = Matrix.generateRandMat(sizeOfBlock, modulo);       
        this.Kmat = Kmat;
    }
    
    

}