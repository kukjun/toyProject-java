package crawling;

public enum StockInformation {

  삼성전자("https://finance.naver.com/item/main.nhn?code=005930"),
  케이씨피드("https://finance.naver.com/item/main.nhn?code=025880"),
  이씨에스("https://finance.naver.com/item/main.nhn?code=067010"),
  삼성출판사("https://finance.naver.com/item/main.nhn?code=068290"),
  데이드림엔터("https://finance.naver.com/item/main.nhn?code=348840"),
  성문전자("https://finance.naver.com/item/main.nhn?code=014910"),
  원익큐브("https://finance.naver.com/item/main.nhn?code=014190"),
  세종텔레콤("https:;//finance.naver.com/item/main.nhn?code=036630"),
  테라셈("https://finance.naver.com/item/main.nhn?code=182690"),
  소리바다("https://finance.naver.com/item/main.nhn?code=053110"),
  서울식품("https://finance.naver.com/item/main.nhn?code=004410"),
  제닉("https://finance.naver.com/item/main.nhn?code=123330"),
  KCTC("https://finance.naver.com/item/main.nhn?code=009070"),
  화신("https://finance.naver.com/item/main.nhn?code=010690"),
  백광산업("https://finance.naver.com/item/main.nhn?code=001340"),
  신풍제약("https://finance.naver.com/item/main.nhn?code=019170"),
  KB금융("https://finance.naver.com/item/main.nhn?code=105560"),
  카카오("https://finance.naver.com/item/main.nhn?code=035720"),
  HMM("https://finance.naver.com/item/main.nhn?code=011200"),
  셀트리온("https://finance.naver.com/item/main.nhn?code=068270");

  private final String url;

  StockInformation(String url) {
    this.url = url;
  }
  public String getUrl() {
    return url;
  }

}
