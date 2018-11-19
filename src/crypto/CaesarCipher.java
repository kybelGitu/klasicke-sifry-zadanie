/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

/**
 *zdroj: vypracovane cvicenia
 * @author Peter
 */
public class CaesarCipher implements Cipher{
    public String encrypt(Key K, String OT) {
        //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
        if (!(K instanceof CaesarKey)) {
           throw new IllegalArgumentException("Vstupom musí byť inštancia CaesarKey");
       }
        StringBuilder ZT = new StringBuilder();
        CaesarKey ck = (CaesarKey) K;
        for (char c : OT.toCharArray()) {
           short inNum = (short) (c - 'a');
           inNum += ck.offset;
           inNum %= ck.modulo;
           char inChar = (char) (inNum + 'a');
           ZT.append(inChar);
       }
       return ZT.toString();
    }


    public String decrypt(Key K, String ZT) {
                //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
        if (!(K instanceof CaesarKey)) {
           throw new IllegalArgumentException("Vstupom musí byť inštancia CaesarKey");
       }
        StringBuilder OT = new StringBuilder();
        CaesarKey ck = (CaesarKey) K;
        for (char c : ZT.toCharArray()) {
           short inNum = (short) (c - 'a');
           inNum -= ck.offset;
           inNum += ck.modulo;
           inNum %= ck.modulo;
           char inChar = (char) (inNum + 'a');
           OT.append(inChar);
       }
       return OT.toString();
    }
        
}
    

