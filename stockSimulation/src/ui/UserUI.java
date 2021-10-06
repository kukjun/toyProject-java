package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import db.table.Member;
import main.InStock;

public class UserUI extends UI{

  private UserUI userUI;
  private BufferedReader br;


  // 생성자 DI 주입
  public UserUI(Member member, UserUI userUI) {
    this.member = member;
    this.userUI = userUI;
    br = new BufferedReader(new InputStreamReader(System.in));
  }

  public String showStartPage() throws Exception {
    System.out.println("--------------------------------Member Page Start--------------------------------");
    userInfo();
    System.out.println("1. SellStock");
    System.out.println("2. PurchaseStock");
    System.out.println("3. Quit");
    System.out.print("input number : ");
    return inputNumber();
  }

  public InStock showSellStockPage() throws Exception {
    System.out.println("--------------------------------Sell Stock--------------------------------");
    return inputStockAndCount();
  }

  public InStock showPurchaseStockPrice() throws Exception {
    System.out.println("--------------------------------Purchase Stock--------------------------------");
    return inputStockAndCount();
  }



  private InStock inputStockAndCount() throws Exception {
    InStock stock = new InStock();

    System.out.print("input stock name :");
    stock.setName(br.readLine());

    System.out.print("input input count :");
    stock.setCount(br.readLine());

    return stock;
  }

  private String inputNumber() throws Exception {
    return br.readLine();
  }

  private void userInfo() {
    //getStock() 으로
  }

}
