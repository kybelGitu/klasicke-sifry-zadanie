/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

/**
 *
 * @author Peter
 */
public class HillCipher implements Cipher{

    @Override
    public String encrypt(Key K, String OT) {
        if (!(K instanceof CaesarKey)) {
           throw new IllegalArgumentException("Vstupom musí byť inštancia HillKey");
       }
        return null;
    }

    @Override
    public String decrypt(Key K, String ZT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String encrypt(String OT, Key k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
