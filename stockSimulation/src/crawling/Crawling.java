package crawling;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Crawling {

  private ArrayList<CrawlingStock> allCrawlingStock;

  public Crawling() {
    allCrawlingStock = new ArrayList<>();
  }

  public void renewCrawlingStockInfo() throws Exception{
    allCrawlingStock.clear();
    Document doc = null;
    StockInformation[] urls = StockInformation.values();
    for (StockInformation stockURL : urls) {
      doc = Jsoup.connect(stockURL.getUrl()).get();

      // 제목 구하기 완료
      Elements titleCode = doc.select("div.wrap_company").select("a");
      String title = titleCode.text();

      // 가격 구하기
      Elements priceCode = doc.select("p.no_today").select("em.no_down").select("span.blind");
      if (priceCode.isEmpty()) {
        priceCode = doc.select("p.no_today").select("em.no_up").select("span.blind");
      }
      String price = priceCode.text();

      // 오늘 최고가 구하기
      Elements todayHighCode = doc.select("table.no_info").select("tbody").select("tr").first().select("td").first().nextElementSibling().select("em").first().select("span.blind");
      String todayHigh = todayHighCode.text();

      // 오늘 최저가 구하기
      Elements todayLowCode = doc.select("table.no_info").select("tbody").select("tr").first().nextElementSibling().select("td").first().nextElementSibling().select("em").first().select("span.blind");
      String todayLow = todayLowCode.text();

      // 오늘 상한가 구하기
      Elements todayHighLimitCode = doc.select("table.no_info").select("tbody").select("tr").first().select("em.no_cha").select("span.blind");
      String todayHighLimit = todayHighLimitCode.text();

      // 오늘 하한가 구하기
      Elements todayLowLimitCode = doc.select("table.no_info").select("tbody").select("tr").first().nextElementSibling().select("em.no_cha");
      String todayLowLimit = todayLowLimitCode.text();


      // 전날 장 마감 가격 구하기
      Elements yesterdayCode = doc.select("table.no_info").select("tbody").select("td.first").first().select("em").select("span.blind");
      String yesterday = yesterdayCode.text();

      allCrawlingStock.add(new CrawlingStock(title, price, yesterday, todayHigh, todayLow, todayHighLimit, todayLowLimit));

    }
  }


}
