package pattern.token;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author XueweiHuang
 * @created 2020-07-27
 */
public class AuthToken {

  private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000L;

  private String token;

  private long createTime;

  private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

  public AuthToken(String token, long createTime) {
    this.token = token;
    this.createTime = createTime;
  }

  public AuthToken(String token, long createTime, long expiredTimeInterval) {
    this(token, createTime);
    this.expiredTimeInterval = expiredTimeInterval;
  }

  public static AuthToken create(String baseUrl, String appId, String appPwd, long createTime) {

    String token = generateToken(baseUrl, appId, appPwd, createTime);

    return new AuthToken(token, createTime);
  }

  public String getToken() {
    return this.token;
  }

  public boolean isExpired() {

    long now = LocalDateTime.now().atZone(ZoneId.of("Asia/Shanghai")).toEpochSecond();

    long expiredTime = this.createTime + this.expiredTimeInterval;

    return now > expiredTime;
  }

  public boolean match(AuthToken authToken) {

    if (authToken.isExpired()) {
      throw new RuntimeException("This token has expired.");
    }

    return this.token.equals(authToken.getToken());
  }

  private static String generateToken(
      String baseUrl, String appId, String appPwd, long createTime) {

    String concatStr = concat(baseUrl, appId, appPwd, String.valueOf(createTime));

    String token = encryptWithSHA1(concatStr);

    return token;
  }

  private static String concat(String... args) {

    if (args == null || args.length == 0) {
      throw new RuntimeException("there are no strings to concatenate.");
    }

    StringBuilder result = new StringBuilder();

    for (String arg : args) {
      result.append(arg);
    }

    return result.toString();
  }

  private static String encryptWithSHA1(String input) {

    try {
      // getInstance() method is called with algorithm SHA-1
      MessageDigest md = MessageDigest.getInstance("SHA-1");

      // digest() method is called
      // to calculate message digest of the input string
      // returned as array of byte
      byte[] messageDigest = md.digest(input.getBytes());

      // Convert byte array into signum representation
      BigInteger no = new BigInteger(1, messageDigest);

      // Convert message digest into hex value
      String hashtext = no.toString(16);

      // Add preceding 0s to make it 32 bit
      while (hashtext.length() < 32) {
        hashtext = "0" + hashtext;
      }

      // return the HashText
      return hashtext;
    }
    // For specifying wrong message digest algorithms
    catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {

    long now = LocalDateTime.now().atZone(ZoneId.of("Asia/Shanghai")).toEpochSecond();

    String appId = "abc";

    String appPwd = "123456";

    AuthToken authToken = AuthToken.create("http://localhost:8080/auth-api", appId, appPwd, now);

    System.out.println(authToken.getToken());

    System.out.println(authToken.match(authToken));

    System.out.println(authToken.isExpired());

    System.out.println(authToken.match(authToken));
  }
}
