package twenty_fifteen.day_4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DayFour {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        String input="ckczppom";
        System.out.println(getTheNUmber(input));
    }

    public static String bytesToHex(byte[] bytes) {
        byte[] hexArray = "0123456789ABCDEF".getBytes(StandardCharsets.US_ASCII);
        byte[] hexChars = new byte[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars, StandardCharsets.UTF_8);
    }

    public static String getTheNUmber(String input) throws NoSuchAlgorithmException {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int smallestPositiveNumber = i;
            String numberFollowing = String.valueOf(smallestPositiveNumber);
            String expectedResult = input+numberFollowing;

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(expectedResult.getBytes());
            byte[] digest = md.digest();
            String secretKeyInHex = bytesToHex(digest);

            //Part 1
            if(secretKeyInHex.startsWith("00000")){
                return expectedResult;
            }
            // Part 2: same, but with six zeros as condition
        }
        return null;
    }
}
