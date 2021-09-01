package algo.consistenthash.server;

/**
 * @author XueweiHuang
 * @created 2021-09-02
 */
public class CacheServer implements Server {

  private String url;

  public CacheServer(String url) {
    this.url = url;
  }

  @Override
  public String getUrl() {
    return this.url;
  }
}
