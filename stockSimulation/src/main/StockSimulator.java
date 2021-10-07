package main;

import controller.AdminController;
import controller.MainPageController;
import controller.UserController;
import crawling.Crawling;
import db.query.DAO;
import db.table.Member;
import ui.AdminUI;
import ui.MainPageUI;
import ui.UI;
import ui.UserUI;

public class StockSimulator {

  private UI ui;
  private Member member;
  private DAO dao;
  private Crawling crawling;
  private AdminController adminController;
  private MainPageController mainPageController;
  private UserController userController;

  public StockSimulator() {
    this.member = new Member();
    this.dao = new DAO();
    this.crawling = new Crawling();
    this.adminController = new AdminController(dao);
    this.mainPageController = new MainPageController(dao);
    this.userController = new UserController(crawling, dao);
    this.ui = new MainPageUI(mainPageController);
  }

  public void changeUI(UI ui) {
    this.ui = ui;
  }

  public void simulate() {
    while (true) {
      try {
        ui.showStartPage();
        this.member = ui.getMember();
        if (getMember() == null) {
          break;
        } else if(getMember().getAuthority() == Member.Authority.TRUE) {
          changeUI(new AdminUI(getMember(), adminController));
        } else if (getMember().getAuthority() == Member.Authority.FALSE) {
          changeUI(new UserUI(getMember(), userController));
        } else if (getMember() != null) {
          changeUI(new MainPageUI(mainPageController));
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public Member getMember() {
    return member;
  }

}
