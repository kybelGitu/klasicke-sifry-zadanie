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
public class HillCipher implements Cipher{

    @Override
    public String encrypt(Key K, String OT) {
        if (!(K instanceof HillKey)) {
           throw new IllegalArgumentException("Vstupom musí byť inštancia HillKey");
       }

        HillKey hKey = (HillKey) K;
        CaesarCipher cezar = new CaesarCipher();
        int subsOffset = hKey.cK.offset;
        int sizeOfBlock = hKey.sizeOfBlock;
       // hKey.setHillKey(sizeOfBlock, subsOffset);
        //cezar decrypt = substitution
        if(subsOffset!=0)
            OT = cezar.encrypt(hKey.cK, OT);
        
        int sizeOfText = OT.length();
        int textBlockSize =  sizeOfText / sizeOfBlock + ((sizeOfText%sizeOfBlock==0) ? 0 : 1);
        //ak nieje delititelne bude doplnene 0
        int[][] textBlocks = new int[textBlockSize][sizeOfBlock];
        //fill blocks with text
        for(int i = 0; i < OT.length(); i++){
            textBlocks[i/sizeOfBlock][i%sizeOfBlock] = (int)  (OT.charAt(i) - 'a');
        }// last block<<<
        ///????
            
        StringBuilder ZT = new StringBuilder();
        for(int i = 0; i < textBlockSize; i++){
            textBlocks[i] = Matrix.VECxMAT(textBlocks[i], hKey.Kmat);
        }
        for(int i =0; i < sizeOfText;i++)
            ZT.append((char) ((textBlocks[i/sizeOfBlock][i%sizeOfBlock]%hKey.cK.modulo)+ 'a'));//mod 26
        
       return ZT.toString();
    }

    @Override
    public String decrypt(Key K, String ZT) {
        HillKey hKey = (HillKey) K;
        CaesarCipher cezar = new CaesarCipher();
        int subsOffset = hKey.modulo -  hKey.cK.offset;
        int sizeOfBlock = hKey.sizeOfBlock;
        hKey.setHillKey(sizeOfBlock, subsOffset);
        HillCipher inverseHill = new HillCipher();
        hKey.Kmat = Matrix.invert(hKey.Kmat);
        String OT = inverseHill.encrypt(hKey, ZT);
        
        return OT;
    }   
}
