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
public interface Cipher {
    public  String encrypt(Key K,String OT);
    public  String decrypt(Key K,String ZT);

    public String encrypt(String OT, Key k);

           
}