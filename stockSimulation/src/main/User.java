package main;

public class User {

  protected String id;
  protected String password;
  // 자식에서 바꿀 수 있어야 함. enum
  protected boolean authority;

  public void setId(String id) {
    this.id = id;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setAuthority(boolean authority) {
    this.authority = authority;
  }

  public String getId() {
    return id;
  }

  public String getPassword() {
    return password;
  }

  public boolean isAuthority() {
    return authority;
  }

}
