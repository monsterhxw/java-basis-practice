package pattern.auth;

import pattern.credential.CredentialStorage;
import pattern.credential.MySqlCredentialStorage;
import pattern.request.ApiRequest;
import pattern.token.AuthToken;

/**
 * @author XueweiHuang
 * @created 2020-07-28
 */
public class DefaultApiAuthenticatorImpl implements ApiAuthenticator {

  private CredentialStorage storage;

  public DefaultApiAuthenticatorImpl() {
    this.storage = new MySqlCredentialStorage();
  }

  public DefaultApiAuthenticatorImpl(CredentialStorage storage) {
    this.storage = storage;
  }

  @Override
  public void auth(String url) {
    ApiRequest apiRequest = ApiRequest.createFromFullUrl(url);
    auth(apiRequest);
  }

  @Override
  public void auth(ApiRequest apiRequest) {

    String appId = apiRequest.getAppId();
    String token = apiRequest.getToken();
    long timestamp = apiRequest.getTimestamp();
    String baseUrl = apiRequest.getBaseUrl();

    AuthToken clientAuthToken = new AuthToken(token, timestamp);
    if (clientAuthToken.isExpired()) {
      throw new RuntimeException("Token is expired.");
    }

    String password = storage.getPasswordByAppId(appId);
    AuthToken serverAuthToken = AuthToken.create(baseUrl, appId, password, timestamp);
    if (!serverAuthToken.match(clientAuthToken)) {
      throw new RuntimeException("Token verification failed.");
    }
  }
}
