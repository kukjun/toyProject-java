package db.table;


public class Member {

  public enum Authority {
    TRUE, FALSE
  }

  private String id;
  private String nickname;
  private String password;
  private Authority authority;
  private int asset;

  public Member() {

  }

  public Member(String id, String nickname, String password, Authority authority, int asset) {
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

  @Override
  public String toString() {
    return "Member{" +
        "id='" + id + '\'' +
        ", nickname='" + nickname + '\'' +
        ", password='" + password + '\'' +
        ", authority=" + authority +
        ", asset=" + asset +
        '}';
  }

}
