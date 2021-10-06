package controller;

import crawling.Crawling;
import crawling.CrawlingStock;
import db.query.DAO;
import db.table.Member;
import db.table.Stock;

import java.util.ArrayList;
import java.util.Iterator;

public class UserController {

  Crawling crawling;
  DAO dao;

  public UserController(Crawling crawling, DAO dao) {
    this.crawling = crawling;
    this.dao = dao;
  }

  public Member userInfo(Member member) {
    return dao.getMember(member.getId(), member.getPassword());
  }

  public void renewAllStocks() throws Exception {
    crawling.renewCrawlingStockInfo();
  }

  public ArrayList<String> getAllStocksInfo() throws Exception {
    ArrayList<CrawlingStock> crawlingStocks = crawling.getAllCrawlingStock();
    ArrayList<String> stocksToString = new ArrayList<>();
    for (CrawlingStock crawlingStock : crawlingStocks) {
      stocksToString.add(crawlingStock.toString());
    }
    return stocksToString;
  }

  public Stock getCrawlingStock(String stockName, Member member) throws Exception {
    Iterator<CrawlingStock> iterator = crawling.getAllCrawlingStock().stream().iterator();
    while (iterator.hasNext()) {
      CrawlingStock crawlingStock = iterator.next();
      if (crawlingStock.getStockName().equals(stockName)) {
        return changeCrawlingStockToStock(crawlingStock, member);
      }
    }
    return null;
  }

  public boolean checkCrawlingStock(String stockName) throws Exception {
    Iterator<CrawlingStock> iterator = crawling.getAllCrawlingStock().stream().iterator();
    while (iterator.hasNext()) {
      CrawlingStock crawlingStock = iterator.next();
      if (crawlingStock.getStockName().equals(stockName)) {
        return true;
      }
    }
    return false;
  }

  public boolean checkUserHavenStock(String stockName, Member member) throws Exception {
    Stock stock = new Stock();
    stock.setName(stockName);
    if (dao.isStock(member, stock)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean checkPurchaseStock(Member member, Stock stock) {
    if (member.getAsset() >= stock.getCount() * stock.getPurchase_price()) {
      return true;
    } else {
      return false;
    }
  }

  public boolean checkSellStock(Member member, Stock stock) {
    if (dao.isStock(member, stock)) {
      Stock DBStock = dao.getStock(stock);
      if (DBStock.getCount() >= stock.getCount()) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }

  }

  public ArrayList<Stock> getUserStockInfo(Member member) {
    return dao.getStockHavenMember(member);
  }

  public boolean sellUpdateStock(Member member, Stock stock) {

    Stock beforeStock = dao.getStock(stock);
    int count = beforeStock.getCount() - stock.getCount();
    if(count == 0) {
      if(!dao.deleteStock(member, stock)) {
        return false;
      }
    }
    else {
      int purchase_price = beforeStock.getPurchase_price();
      stock.setCount(count);
      stock.setPurchase_price(purchase_price);
      if (!dao.updateStock(stock)) {
        return false;
      }
    }

    member.setAsset(
        member.getAsset() + stock.getPurchase_price() * stock.getCount()
    );
    if (!dao.updateMember(member)) {
      return false;
    }
    return true;
  }

  public boolean purchaseUpdateStock(Member member, Stock stock) {
    if (dao.isStock(member, stock)) {
      member.setAsset(
          member.getAsset() - stock.getPurchase_price() * stock.getCount()
      );
      if (!dao.updateMember(member)) {
        return false;
      }
      Stock beforeStock = dao.getStock(stock);
      int count = stock.getCount() + beforeStock.getCount();
      int purchase_price = (beforeStock.getPurchase_price() * beforeStock.getCount() +
          stock.getPurchase_price() * stock.getCount()) / count;
      stock.setCount(count);
      stock.setPurchase_price(purchase_price);
      if (!dao.updateStock(stock)) {
        return false;
      }
      return true;
    } else {
      return dao.registerStock(stock);
    }
  }

  public int totalAsset(Member member) {
    ArrayList<Stock> stockHavenMember = dao.getStockHavenMember(member);
    Iterator<Stock> iterator = stockHavenMember.stream().iterator();
    int asset = member.getAsset();
    while (iterator.hasNext()) {
      Stock stock = iterator.next();
      CrawlingStock crawlingStock = crawling.findStock(stock.getName());
      asset += Integer.parseInt(crawlingStock.getStockPrice().replaceAll(",","")) * stock.getCount();
    }
    return asset;
  }

  public ArrayList<String> ComparisonStocks(Member member) {
    ArrayList<Stock> stockHavenMember = dao.getStockHavenMember(member);
    Iterator<Stock> iterator = stockHavenMember.stream().iterator();
    ArrayList<String> comparisons = new ArrayList<>();
    while (iterator.hasNext()) {
      Stock stock = iterator.next();
      CrawlingStock crawlingStock = crawling.findStock(stock.getName());
      comparisons.add(
          "주식 이름: " + stock.getName() + ", 보유 개수: " + stock.getCount() + "구매 가격: " + stock.getPurchase_price() +
              "현재 가격: " + crawlingStock.getStockPrice()
      );
    }
    if(comparisons.isEmpty()) {
      return null;
    }
    return comparisons;
  }

  private Stock changeCrawlingStockToStock(CrawlingStock crawlingStock, Member member) {
    Stock stock = new Stock();
    stock.setName(crawlingStock.getStockName());
    stock.setMember_id(member.getId());
    stock.setPurchase_price(Integer.parseInt(crawlingStock.getStockPrice().replaceAll(",", "")));
    return stock;
  }

  private ArrayList<Stock> changeCrawlingStocksToStocks(ArrayList<CrawlingStock> crawlingStocks) {
    ArrayList<Stock> stocks = new ArrayList<>();
    for (CrawlingStock crawlingStock : crawlingStocks) {
      Stock stock = new Stock();
      stock.setName(crawlingStock.getStockName());
      stock.setPurchase_price(Integer.parseInt(crawlingStock.getStockPrice().replaceAll(",", "")));
      stocks.add(stock);
    }
    return stocks;
  }


}
