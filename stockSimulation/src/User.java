import java.util.ArrayList;

public class User {
  private String id;
  private String nickName;
  private String password;
  private ArrayList<Stock> stockArrayList;

  // setter
  public void setId(String id) {
    this.id = id;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public ArrayList<Stock> getStockArrayList() {
    return stockArrayList;
  }

}
