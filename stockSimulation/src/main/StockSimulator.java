package main;

import db.table.Member;
import ui.UI;

public class StockSimulator {
  private UI ui;
  private Member member;

  public StockSimulator(UI ui) {
    this.ui = ui;
    this.member = new Member();
  }

  public void changeUI(UI ui) {
    this.ui = ui;
  }

  public void simulate() {
    try {
      ui.showStartPage();
      this.member = ui.getMember();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Member getMember() {
    return member;
  }

}
