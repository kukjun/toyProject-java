package db.table;

import main.Member;

public class TUser {
  private String id;
  private String nickname;
  private String password;
  private boolean authority;
  private int asset;

  public TUser() {

  }
  public TUser(Member member) {
    this.id = member.getId();
    this.nickname = member.getNickName();
    this.password = member.getPassword();
    this.authority = member.isAuthority();
    this.asset = 50000000;
  }

  public TUser(String id, String nickname, String password, boolean authority, int asset) {
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

  public void setAuthority(boolean authority) {
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

  public boolean isAuthority() {
    return authority;
  }

  public int getAsset() {
    return asset;
  }

}
