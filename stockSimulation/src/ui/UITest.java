package ui;


import controller.AdminController;
import controller.MainPageController;
import controller.UserController;
import crawling.Crawling;
import db.query.DAO;
import db.table.Member;

public class UITest {

  public static void main(String[] args) throws Exception {
    Member admin = new Member("admin123", "KingJun", "abcd1234", Member.Authority.TRUE, 0);
    Member user = new Member("kukjun123", "ImKukjun", "abcd1234", Member.Authority.FALSE, 10000000);

    AdminController adminController = new AdminController(new DAO());
    MainPageController mainPageController = new MainPageController(new DAO());
    UserController userController = new UserController(new Crawling(), new DAO());

//     mainPage Test
//    MainPageUI mainPageUI = new MainPageUI(mainPageController);
//    mainPageUI.showStartPage();


    //UserUI test
    UserUI userUI = new UserUI(user, userController);
    userUI.showStartPage();

    //AdminUI test
//    AdminUI adminUI = new AdminUI(admin, adminController);
//    adminUI.showStartPage();
//    adminUI.printAllMember();
  }

}
