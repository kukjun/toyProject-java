package project_1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebCrawlingTest {
    public static void main(String[] args) {
        Document doc = null;
        String samsungElectricURL = "https://finance.naver.com/item/main.nhn?code=005930#";
        String seoulFoodURL = "https://finance.naver.com/item/main.nhn?code=004410";
        String soRiBaDaURL = "https://finance.naver.com/item/main.nhn?code=053110";
        try {
            doc = Jsoup.connect(seoulFoodURL).get();
            System.out.println("-- check -- ");

            // 제목 구하기 완료
            Elements titleCode = doc.select("div.wrap_company").select("a");
            String title = titleCode.text();
            System.out.println("주식 이름: " + title);

            // 가격 구하기
            Elements priceCode = doc.select("p.no_today").select("em.no_down").select("span.blind");
            if(priceCode.isEmpty()){
                priceCode = doc.select("p.no_today").select("em.no_up").select("span.blind");
            }
            String price = priceCode.text();
            System.out.println("주식의 가격: " + price);

            // 오늘 최고가 구하기
            Elements todayHighCode = doc.select("table.no_info").select("tbody").select("tr").first().select("td").first().nextElementSibling().select("em").first().select("span.blind");
            String todayHigh = todayHighCode.text();
            System.out.println("오늘 최고가: " + todayHigh);

            // 오늘 최저가 구하기
            Elements todayLowCode = doc.select("table.no_info").select("tbody").select("tr").first().nextElementSibling().select("td").first().nextElementSibling().select("em").first().select("span.blind");
            String todayLow = todayLowCode.text();
            System.out.println("오늘 최저가: " + todayLow);

            // 오늘 상한가 구하기
            Elements todayHighLimitCode = doc.select("table.no_info").select("tbody").select("tr").first().select("em.no_cha").select("span.blind");
            String todayHighLimit = todayHighLimitCode.text();
            System.out.println("오늘 상한가: " + todayHighLimit);

            // 오늘 하한가 구하기
            Elements todayLowLimitCode = doc.select("table.no_info").select("tbody").select("tr").first().nextElementSibling().select("em.no_cha");
            String todayLowLimit = todayLowLimitCode.text();
            System.out.println("오늘 하한가: " + todayLowLimit);


            // 전날 장 마감 가격 구하기
            Elements yesterdayCode = doc.select("table.no_info").select("tbody").select("td.first").first().select("em").select("span.blind");
            String yesterday = yesterdayCode.text();
            System.out.println("전날 장 마감 가격: " + yesterday);

            String strStockPrice = yesterday.replaceAll(",", "");
            int stockPrice = Integer.valueOf(strStockPrice);
            System.out.println(stockPrice);


        } catch (IOException e)  {
            e.printStackTrace();
        } catch (NullPointerException e2){
            e2.printStackTrace();
        }


//        Iterator<Element> ie1 = element.select("strong.").iterator();
    }
}