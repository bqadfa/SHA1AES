package kek.models;

import lombok.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class SHA1 {

    private String initialMessage;
    private String encryptedMessage;

    public String encrypt(String input) {
        initialMessage = input;
        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] md = messageDigest.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger signumRepresentation = new BigInteger(1, md);

            // Convert message digest into hex value
            String hashText = signumRepresentation.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            encryptedMessage = hashText;
            return hashText;


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        SHA1 sha = new SHA1();
        String test1 = sha.encrypt("hi");
        System.out.println(sha.getEncryptedMessage() + "\n" + sha.getInitialMessage());

        final String secKey = "aaabbb";

        String test2 = AES.encrypt("hi", secKey);
        System.out.println(test2);
        System.out.println(AES.decrypt(test2, secKey));
    }


}
