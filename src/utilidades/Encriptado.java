/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author rober
 */
public class Encriptado {
    private static final String clavePrivada = "vJMnURwFuojTiaJT";
    
    public static String encriptar (String textoEncriptar) {
           
        String cadenaEncriptada = null;
        
        try {
            
            Key millaveenBytes = new SecretKeySpec(clavePrivada.getBytes(), "AES");
            
            Cipher encriptador = Cipher.getInstance("AES");
            encriptador.init(Cipher.ENCRYPT_MODE, millaveenBytes);
            
            byte[] bytesEncriptados = encriptador.doFinal(textoEncriptar.getBytes());
            
            cadenaEncriptada = Base64.encodeBase64String(bytesEncriptados);
            
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(Encriptado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cadenaEncriptada;
        
    }

    public static String desencriptar (String textoEncriptado) {
        
        String desencriptado = null;
    
        try {
            
            byte [] bytesEncriptados = Base64.decodeBase64(textoEncriptado);
            
            Key millaveenBytes = new SecretKeySpec(clavePrivada.getBytes(), "AES");
            
            Cipher encriptador = Cipher.getInstance("AES");
            encriptador.init(Cipher.DECRYPT_MODE, millaveenBytes);
            
             desencriptado = new String(encriptador.doFinal(bytesEncriptados));
            
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(Encriptado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return desencriptado;
    }
}
