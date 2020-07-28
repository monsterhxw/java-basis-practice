package pattern.credential;

/**
 * @author XueweiHuang
 * @created 2020-07-28
 */
public class MySqlCredentialStorage implements CredentialStorage {

  @Override
  public String getPasswordByAppId(String appId) {

    // todo
    String pwdFromMySql = "123456";

    return pwdFromMySql;
  }
}
