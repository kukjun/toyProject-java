package db.table;

public class Stock {
  private String name;
  private int count;
  private int purchase_price;
  private String member_id;

  public Stock(String name, int count, int purchase_price, String member_id) {
    this.name = name;
    this.count = count;
    this.purchase_price = purchase_price;
    this.member_id = member_id;
  }

  public Stock() {
  }

  public String getMember_id() {
    return member_id;
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

  public void setMember_id(String member_id) {
    this.member_id = member_id;
  }

  @Override
  public String toString() {
    return "Stock{" +
        "name='" + name + '\'' +
        ", count=" + count +
        ", purchase_price=" + purchase_price +
        ", member_id='" + member_id + '\'' +
        '}';
  }

}
