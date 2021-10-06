package main;


import controller.AdminController;
import controller.MainPageController;
import controller.UserController;
import crawling.Crawling;
import db.query.DAO;
import db.table.Member;
import ui.AdminUI;
import ui.MainPageUI;
import ui.UserUI;

public class Execute {

  public static void main(String[] args) {
    Member member = new Member();
    DAO dao = new DAO();
    Crawling crawling = new Crawling();
    AdminController adminController = new AdminController(dao);
    MainPageController mainPageController = new MainPageController(dao);
    UserController userController = new UserController(crawling, dao);

    StockSimulator stockSimulator = new StockSimulator(new MainPageUI(mainPageController));

    while (true) {
      stockSimulator.simulate();
      if (stockSimulator.getMember() == null) {
        break;
      } else if(stockSimulator.getMember().getAuthority() == Member.Authority.TRUE) {
        stockSimulator.changeUI(new AdminUI(stockSimulator.getMember(), adminController));
      } else if (stockSimulator.getMember().getAuthority() == Member.Authority.FALSE) {
        stockSimulator.changeUI(new UserUI(stockSimulator.getMember(), userController));
      } else if (stockSimulator.getMember() != null) {
        stockSimulator.changeUI(new MainPageUI(mainPageController));
      }
    }


  }

}
