package org.usm.labwork.labwork.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class SHA1 {

    private String initialMessage;
    private String encryptedMessage;

    public String encrypt(String message) {

        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] md = messageDigest.digest(message.getBytes());

            // Convert byte array into signum representation
            BigInteger signumRepresentation = new BigInteger(1, md);

            // Convert message digest into hex value
            String hashText = signumRepresentation.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            return hashText;


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public SHA1(String initialMessage) {
        this.initialMessage = initialMessage;
        this.encryptedMessage = encrypt(initialMessage);
    }

}
