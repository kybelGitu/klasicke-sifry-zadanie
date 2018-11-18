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
public class CaesarKey implements Key{
   int offset = 3;
   int modulo = 26;

   public void setOffset(int offset) {
       this.offset = offset;
   }

   public void setModulo(int modulo) {
       this.modulo = modulo;
   }
    
}
