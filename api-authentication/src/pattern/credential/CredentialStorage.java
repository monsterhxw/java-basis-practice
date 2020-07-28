package pattern.credential;

/**
 * @author XueweiHuang
 * @created 2020-07-28
 */
public interface CredentialStorage {

  String getPasswordByAppId(String appId);
}
