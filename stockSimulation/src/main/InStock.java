package main;

public class InStock {
  private String name;
  private String count;
  private String price;

  public void setName(String name) {
    this.name = name;
  }

  public void setCount(String count) {
    this.count = count;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public String getCount() {
    return count;
  }

  public String getPrice() {
    return price;
  }

  public InStock(String name, String count, String price) {
    this.name = name;
    this.count = count;
    this.price = price;
  }

  public InStock() {

  }

  @Override
  public String toString() {
    return "{" +
        "name = " + name + ", " +
        "count = " + count + ", " +
        "price = " + price + "}\n";
  }

}
