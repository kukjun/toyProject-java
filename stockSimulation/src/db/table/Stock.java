package db.table;

public class Stock {
  private String id;
  private String name;
  private int count;
  private int purchase_price;
  private String user_id;

  public String getUser_id() {
    return user_id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getPurchase_price() {
    return purchase_price;
  }

  public void setPurchase_price(int purchase_price) {
    this.purchase_price = purchase_price;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

}
