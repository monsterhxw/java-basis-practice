package pattern.auth;

import pattern.request.ApiRequest;

/**
 * @author XueweiHuang
 * @created 2020-07-28
 */
public interface ApiAuthenticator {

  void auth(String url);

  void auth(ApiRequest apiRequest);
}
