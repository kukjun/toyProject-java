package project_1;

public class User implements UserInterface {
    //field
    String userName;
    int cash = 10000000;
    int currentAsset;
    HoldingStock[] holdingStocks;


    User(String userName) {
        this.userName = userName;
        currentAsset = cash;
    }

    @Override
    public boolean buy(Stock stock, int count) throws InsufficientBalanceException {
        //웹 크롤링 결과로 주식의 이름을 가져온다. 구매하고자 하는 주식이 없는 경우는 밖에서 처리한다.

        // 문자열을 숫자로 전환
        String strStockPrice = stock.stockPrice.replaceAll(",", "");
        int stockPrice = Integer.valueOf(strStockPrice);
        System.out.println(stockPrice);
        if (stockPrice * count > cash) {
            throw new InsufficientBalanceException("보유 금액이 부족합니다.");
        } else {
            int holdingStockNameIndex = getHoldingStockNameIndex(stock.stockName);
            if (holdingStockNameIndex == -1) {
                new HoldingStock(stock.stockName, count);
            } else {
                holdingStocks[holdingStockNameIndex].holdingStockCount += count;
            }
            cash -= stockPrice * count;

//            cash -= stockPrice * count;
//            currentAsset += cash + stockPrice * count;
        }
    return true;
    }

    @Override // 미구현
    public boolean sell(Stock stock, int count) throws CountException {
        return true;
    }

    @Override // 미구현
    public boolean show() {
        return true;
    }

    private boolean isHoldingStock(String stockName) {
        for(HoldingStock holdingStock : holdingStocks){
            if(holdingStock.holdingStockName.equals(stockName)) {
                return false;
            }
        }
        return true;
    }

    private int getHoldingStockNameIndex(String stockName) {
        for(int i=0; i<holdingStocks.length; i++) {
            if(holdingStocks[i].holdingStockName.equals(stockName)) {
                return i;
            }
        }
        return -1;
    }

    private void setCurrentAsset() {
        for(HoldingStock holdingStock : holdingStocks) {

        }
    }

    //Getter Setter 변환

}