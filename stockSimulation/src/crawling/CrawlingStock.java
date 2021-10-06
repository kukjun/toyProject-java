package crawling;

public class CrawlingStock {

  //field
  String stockName;
  String stockPrice;
  String stockYesterdayPrice;
  String stockTodayHighPrice;
  String stockTodayLowPrice;
  String stockTodayHighLimitPrice;
  String stockTodayLowLimitPrice;

  //constructor
  CrawlingStock(String stockName, String stockPrice, String stockYesterdayPrice, String stockTodayHighPrice, String stockTodayLowPrice, String stockTodayHighLimitPrice, String stockTodayLowLimitPrice) {
    this.stockName = stockName;
    this.stockPrice = stockPrice;
    this.stockYesterdayPrice = stockYesterdayPrice;
    this.stockTodayHighPrice = stockTodayHighPrice;
    this.stockTodayLowPrice = stockTodayLowPrice;
    this.stockTodayHighLimitPrice = stockTodayHighLimitPrice;
    this.stockTodayLowLimitPrice = stockTodayLowLimitPrice;
  }

  @Override
  public String toString() {
    String stockInfo;
    stockInfo = "주식 이름 :" + stockName + "\n";
    stockInfo += "주식의 가격 :" + stockPrice + "\n";
    stockInfo += "오늘 최고가 :" + stockTodayHighPrice + "\n";
    stockInfo += "오늘 최저가 :" + stockTodayLowPrice + "\n";
    stockInfo += "오늘 상한가 :" + stockTodayHighLimitPrice + "\n";
    stockInfo += "오늘 하한가 :" + stockTodayLowLimitPrice + "\n";
    return stockInfo;
  }

}
