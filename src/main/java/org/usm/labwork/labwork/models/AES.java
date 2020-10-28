package org.usm.labwork.labwork.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class AES {
    private String initialMessage;
    private String encryptedMessage;

    private static SecretKeySpec secretKey;
    private static byte[] key;

    public AES(String initialMessage, String secKey) {
        this.initialMessage = initialMessage;
        this.encryptedMessage = encrypt(initialMessage, secKey);
    }

    /*public AES(StringBuilder encryptedMessage, String secKey) {
        this.initialMessage = decrypt(encryptedMessage.toString(), secKey);
    }*/

    public static void setKey(String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String strToEncrypt, String secret) {
        initialMessage = strToEncrypt;
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            encryptedMessage = Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
            return encryptedMessage;
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(String strToDecrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public static void main(String[] args) {
        String msg = "Hi";
        String sk = "asd";
        AES aes = new AES(msg, sk);
        System.out.println(aes.getEncryptedMessage());
        System.out.println(aes.decrypt(aes.getEncryptedMessage(), sk));

        String asd = aes.getEncryptedMessage();

        System.out.println(AES.decrypt(asd, sk));
    }
}
