import java.util.*;

public class RandomString
{
    public String random()
    {
        int length = 10; // ×Ö·û´®³¤¶È
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // ×Ö·û¼¯
        Random secureRandom = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = secureRandom.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }

        String randomString = sb.toString();
        return randomString;
    }
}