package pattern;

import java.time.LocalDateTime;
import java.time.ZoneId;
import pattern.auth.ApiAuthenticator;
import pattern.auth.DefaultApiAuthenticatorImpl;
import pattern.credential.CredentialStorage;
import pattern.credential.MySqlCredentialStorage;
import pattern.token.AuthToken;

public class Main {

  public static void main(String[] args) {

    CredentialStorage storage = new MySqlCredentialStorage();

    ApiAuthenticator apiAuthenticator = new DefaultApiAuthenticatorImpl(storage);

    long now = LocalDateTime.now().atZone(ZoneId.of("Asia/Shanghai")).toEpochSecond();

    String appId = "abc";
    String baseUrl = "http://www.geekbang.org/user?id=123";

    String token =
        AuthToken.create(baseUrl, appId, storage.getPasswordByAppId(appId), now).getToken();

    String fullUrl = String.format("%s&appid=%s&token=%s&ts=%s", baseUrl, appId, token, now);

    System.out.println("authentication star!");

    apiAuthenticator.auth(fullUrl);

    System.out.println("authentication end!");
  }
}
