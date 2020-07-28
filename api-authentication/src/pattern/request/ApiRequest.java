package pattern.request;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author XueweiHuang
 * @created 2020-07-28
 */
public class ApiRequest {

  private String baseUrl;

  private String token;

  private String appId;

  private long timestamp;

  public ApiRequest(String baseUrl, String token, String appId, long timestamp) {
    this.baseUrl = baseUrl;
    this.token = token;
    this.appId = appId;
    this.timestamp = timestamp;
  }

  public static ApiRequest createFromFullUrl(String url) {

    if (url == null || url.isEmpty()) {
      throw new RuntimeException("The URL cannot be empty or null.");
    }

    try {
      URL fullUrl = new URL(url);

      Map<String, String> queryMap = getQueryMap(fullUrl.getQuery());

      String baseUrl = getBaseUrl(fullUrl, queryMap);

      return new ApiRequest(
          baseUrl,
          queryMap.get("token"),
          queryMap.get("appid"),
          Long.parseLong(queryMap.get("ts")));
    } catch (MalformedURLException e) {
      throw new RuntimeException(
          "Create api request object failure.The reason is that" + e.getMessage());
    }
  }

  public String getBaseUrl() {
    return this.baseUrl;
  }

  public String getAppId() {
    return this.appId;
  }

  public String getToken() {
    return this.token;
  }

  public long getTimestamp() {
    return this.timestamp;
  }

  private static Map<String, String> getQueryMap(String query) {

    String[] params = query.split("&");

    Map<String, String> queryMap = new HashMap<>(params.length);

    for (String param : params) {
      String[] chunks = param.split(Pattern.quote("="));

      String name = chunks[0];

      String value = null;
      if (chunks.length > 1) {
        value = chunks[1];
      }

      queryMap.put(name, value);
    }

    return queryMap;
  }

  private static String getBaseUrl(URL fullUrl, Map<String, String> queryMap) {

    StringBuilder baseUrl =
        new StringBuilder(fullUrl.toString().substring(0, fullUrl.toString().indexOf("?")));

    int count = 0;
    Set<String> authParams = getAuthParams();
    for (Entry<String, String> entry : queryMap.entrySet()) {
      if (entry.getKey() == null || entry.getValue() == null) {
        continue;
      }
      if (authParams.contains(entry.getKey())) {
        continue;
      }
      if (count == 0) {
        baseUrl.append("?");
      } else {
        baseUrl.append("&");
      }
      count++;
      baseUrl.append(String.format("%s%s%s", entry.getKey(), "=", entry.getValue()));
    }

    return baseUrl.toString();
  }

  private static Set<String> getAuthParams() {

    Set<String> authParams = new HashSet<>();

    authParams.add("appid");
    authParams.add("token");
    authParams.add("ts");

    return authParams;
  }

  public static void main(String[] args) {

    long now = LocalDateTime.now().atZone(ZoneId.of("Asia/Shanghai")).toEpochSecond();
    String token = "dfebccf8ea36e8f34c6c696486d9208505abf497";
    String appId = "abc";

    String fullUrl =
        String.format(
            "http://www.geekbang.org/user?id=123&appid=%s&token=%s&ts=%s", appId, token, now);

    ApiRequest apiRequest = ApiRequest.createFromFullUrl(fullUrl);

    System.out.println(apiRequest.getBaseUrl());

    System.out.println(apiRequest.getToken());

    System.out.println(apiRequest.getTimestamp());
  }
}
