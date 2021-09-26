package crawling;


import java.util.ArrayList;

public class StockProcess {

  public ArrayList<Stock> allStock;

  public StockProcess() {
    allStock = new ArrayList<>();
  }

  public void renewStockInfo() {
    Thread thread = new CrawlingThread(allStock);
    thread.start();
  }




}
