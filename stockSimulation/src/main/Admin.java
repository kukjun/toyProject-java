package main;


public class Admin extends User{

  public Admin() {
    super();
    authority = true;
  }

  // setter
  public void setId(String id) {
    this.id = id;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  // getter
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

//UI가 Controller 가 위임
//enum type switch문
