package db.table;


public class User {

  public enum Authority {
    TRUE, FALSE
  }

  private String id;
  private String nickname;
  private String password;
  private Authority authority;
  private int asset;

  public User() {

  }

  public User(String id, String nickname, String password, Authority authority, int asset) {
    this.id = id;
    this.nickname = nickname;
    this.password = password;
    this.authority = authority;
    this.asset = asset;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Authority getAuthority() {
    return authority;
  }

  public void setAuthority(Authority authority) {
    this.authority = authority;
  }

  public void setAsset(int asset) {
    this.asset = asset;
  }

  public String getId() {
    return id;
  }

  public String getNickname() {
    return nickname;
  }

  public String getPassword() {
    return password;
  }


  public int getAsset() {
    return asset;
  }

}
