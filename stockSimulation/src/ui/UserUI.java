package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import controller.UserController;
import db.table.Member;
import db.table.Stock;

public class UserUI extends UI{

  private UserController userController;
  private BufferedReader br;


  // 생성자 DI 주입
  public UserUI(Member member, UserController userController) {
    this.member = member;
    this.userController = userController;
    br = new BufferedReader(new InputStreamReader(System.in));
  }

  public void showStartPage() throws Exception {
    String input;
    System.out.println("--------------------------------Member Page Start--------------------------------");
    printMyInfo();
    do {
      System.out.println("1. SellStock");
      System.out.println("2. PurchaseStock");
      System.out.println("3. showUserInfoDetail");
      System.out.println("4. Quit");
      input = inputNumber();
      switch(input) {
        case "1":
          showSellStockPage();
          break;
        case"2":
          showPurchaseStockPage();
          break;
        case"3":
          showUserInfoDetail();
          break;
        case"4":
          showQuitPage();
      }
    } while (!input.equals("4"));
  }

  public void showSellStockPage() throws Exception {
    System.out.println("--------------------------------Sell Stock--------------------------------");
    System.out.println("please wait...");
    userController.renewAllStocks();
    showUserStockInfo();
    String stockName = inputStockName();
    if (userController.checkUserHavenStock(stockName, member)) {
      Stock stock = userController.getCrawlingStock(stockName, this.member);
      stock.setCount(inputCount());
      if(userController.sellUpdateStock(this.member, stock)) {
        System.out.println("판매 완료");
      } else {
        System.out.println("판매 실패");
      }
    } else {
      System.out.println("찾을 수 없는 주식입니다. 그 주식을 지금 가지고 있지 않으십니다.");
    }
  }

  public void showPurchaseStockPage() throws Exception {
    System.out.println("--------------------------------Purchase Stock--------------------------------");
    System.out.println("please wait...");
    userController.renewAllStocks();
    showAllStockInfo();
    String stockName = inputStockName();
    if (userController.checkCrawlingStock(stockName)) {
      Stock stock = userController.getCrawlingStock(stockName, this.member);
      stock.setCount(inputCount());
      if(userController.checkPurchaseStock(this.member, stock)) {
        if(userController.purchaseUpdateStock(this.member, stock)) {
          System.out.println("구매 완료");
        } else {
          System.out.println("구매 실패");
        }
      }


    } else {
      System.out.println("찾을 수 없는 주식입니다. 명단에 있는 주식만 골라주세요.");
    }

  }

  public void showUserInfoDetail() throws Exception {
    System.out.println("--------------------------------show User Information Detail--------------------------------");
    System.out.println("please wait...");
    userController.renewAllStocks();
    showUserTotalAsset();
    showUserStockComparison();


  }

  public void showQuitPage() throws Exception {
    System.out.println("--------------------------------Quit--------------------------------");
    System.out.println("User UI를 종료합니다.");
  }

  private int inputCount() throws Exception {
    System.out.print("input Count: ");
    return Integer.parseInt(br.readLine());
  }

  private String inputNumber() throws Exception {
    System.out.print("input Number: ");
    return br.readLine();
  }

  private String inputStockName() throws Exception {
    System.out.print("input StockName: ");
    return br.readLine();
  }

  private void printMyInfo() {
    Member member = userController.userInfo(this.member);
    System.out.println(member);
  }

  private void showAllStockInfo() throws Exception {
    ArrayList<String> stocksToString = userController.getAllStocksInfo();
    for (String stockToString : stocksToString) {
      System.out.println(stockToString);
    }
  }

  private void showUserStockInfo() throws Exception {
    ArrayList<Stock> stocks = userController.getUserStockInfo(member);
    for (Stock stock : stocks) {
      System.out.println(stock);
    }
  }

  private void showUserTotalAsset() throws Exception {
    System.out.print("total Asset: ");
    System.out.println(userController.totalAsset(member));
  }

  private void showUserStockComparison() throws Exception {
    System.out.println();
  }

}
