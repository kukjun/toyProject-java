package main;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {

  private String nickName;
  private int asset;
  private List<InStock> stocks;

  public Member() {
    this.authority = false;
    stocks = new ArrayList<>();
  }

  // setter
  public void setId(String id) {
    this.id = id;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public void setAsset(int asset) {
    this.asset = asset;
  }

  public void setStocks(List<InStock> stocks) {
    this.stocks = stocks;
  }

  // getter
  public String getId() {
    return id;
  }

  public String getNickName() {
    return nickName;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public boolean isAuthority() {
    return super.isAuthority();
  }

  @Override
  public String toString() {
    return "-------------------------\n" +
        "id = " + this.id + "\n" +
        "password = " + this.password + "\n" +
        "nickname = " + this.nickName + "\n" +
        "asset = " + this.asset + "\n" +
        "-------------------------\n";
  }

  public void stockInfo() {
    System.out.println(this.nickName);
    for(InStock stock : stocks) {
      System.out.println(stock);
    }
  }


}
