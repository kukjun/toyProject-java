package crawling;

import crawling.Stock;
import crawling.StockProcess;

import java.util.ArrayList;

public class Test {

  public static void main(String[] args) {
    StockProcess stockProcess = new StockProcess();
    stockProcess.renewStockInfo();

    outputString(stockProcess.allStock);
  }

  public static synchronized void outputString(ArrayList<Stock> allStock) {
    for(Stock stock : allStock) {
      System.out.println(stock.toString());
      System.out.println();
    }
  }

}
