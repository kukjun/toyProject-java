package main;


import controller.AdminController;
import controller.MainPageController;
import controller.UserController;
import crawling.Crawling;
import db.query.DAO;
import db.table.Member;
import ui.MainPageUI;

public class Execute {

  public static void main(String[] args) {
    Member member = new Member();
    DAO dao = new DAO();
    Crawling crawling = Crawling.getInstance();
    AdminController adminController = new AdminController(dao);
    MainPageController mainPageController = new MainPageController(dao);
    UserController userController = new UserController(crawling, dao);

    StockSimulator stockSimulator = new StockSimulator();

    stockSimulator.simulate();


  }

}
