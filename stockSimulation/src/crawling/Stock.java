package crawling;

public class Stock {

  //field
  String stockName;
  String stockPrice;
  String stockYesterdayPrice;
  String stockTodayHighPrice;
  String stockTodayLowPrice;
  String stockTodayHighLimitPrice;
  String stockTodayLowLimitPrice;

  //constructor
  Stock(String stockName, String stockPrice, String stockYesterdayPrice, String stockTodayHighPrice, String stockTodayLowPrice, String stockTodayHighLimitPrice, String stockTodayLowLimitPrice) {
    this.stockName = stockName;
    this.stockPrice = stockPrice;
    this.stockYesterdayPrice = stockYesterdayPrice;
    this.stockTodayHighPrice = stockTodayHighPrice;
    this.stockTodayLowPrice = stockTodayLowPrice;
    this.stockTodayHighLimitPrice = stockTodayHighLimitPrice;
    this.stockTodayLowLimitPrice = stockTodayLowLimitPrice;
  }



}
