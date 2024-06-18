import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.io.FileWriter;
import java.io.IOException;
public class HashExample {
    public static void main(String[] args) throws IOException{
        try {
            String phraseToHash = "Nothing else matters";

            String[] algorithms = {"MD5", "SHA-1", "SHA-256"};

            try (FileWriter writer = new FileWriter("hashes.txt")) {
                for (String algorithm : algorithms) {
                    MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
                    byte[] hashBytes = messageDigest.digest(phraseToHash.getBytes());
                    writer.write(algorithm + " hash: " + bytesToHex(hashBytes) + "\n");
                }
            }
        } catch (NoSuchAlgorithmException e) {e.printStackTrace();}

        try {
            String[] algorithmsForSecondTask = {"SHA1PRNG", "DRBG", "Windows-PRNG"};
            try (FileWriter writer1 = new FileWriter("hashes.txt", true)) {
                for (String algorithm : algorithmsForSecondTask) {
                    SecureRandom secureRandom = SecureRandom.getInstance(algorithm);
                    byte[] randomBytes = new byte[16];
                    secureRandom.nextBytes(randomBytes);
                    writer1.write(algorithm + " random: " + bytesToHex(randomBytes));
                }
            }
        } catch (NoSuchAlgorithmException e) {e.printStackTrace();}
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

