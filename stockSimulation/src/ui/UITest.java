package ui;


import controller.AdminController;
import controller.MainPageController;
import db.query.DAO;
import db.table.Member;

public class UITest {

  public static void main(String[] args) throws Exception {
    Member admin = new Member("admin123", "KingJun", "abcd1234", Member.Authority.TRUE, 0);
    AdminController adminController = new AdminController(new DAO());
    MainPageController mainPageController = new MainPageController(new DAO());

    // mainPage Test
    // test
    MainPageUI mainPageUI = new MainPageUI(mainPageController);
    mainPageUI.showStartPage();


    //MemberUI test


    //AdminUI test
//    AdminUI adminUI = new AdminUI(admin, adminController);
//    adminUI.printAllMember();
  }

}
