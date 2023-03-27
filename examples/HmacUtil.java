package examples;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacUtil {

    public static String hmacSha512(String secret, String message) {
        try {
            Mac sha512_HMAC = Mac.getInstance("HmacSHA512");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA512");
            sha512_HMAC.init(secret_key);

            sha512_HMAC.update(message.getBytes(StandardCharsets.UTF_8));
            byte[] result = sha512_HMAC.doFinal();

            sha512_HMAC.reset();

            return new String(Base64.getEncoder().encode(result));
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
