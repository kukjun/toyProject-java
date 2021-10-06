package ui;

import controller.AdminController;
import db.table.Member;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AdminUI extends UI {

  private AdminController adminController;
  private BufferedReader br;


  public AdminUI(Member member, AdminController adminController) {
    super();
    this.member = member;
    this.adminController = adminController;
    br = new BufferedReader(new InputStreamReader(System.in));
  }


  public String showStartPage() throws Exception {
    System.out.println("--------------------------------Admin Page Start--------------------------------");
    System.out.println("1. User information change");
    System.out.println("2. User delete");
    System.out.println("3. Quit");
    return inputNumber();
  }

  public String showMemberInfoChange() throws Exception {
    System.out.println("--------------------------------Member Information Change--------------------------------");
    printAllMember();
    return inputNumber();
  }

  public Member showMemberDelete() throws Exception {
    System.out.println("--------------------------------Member Delete--------------------------------");
    return inputNickName();
  }

  private String inputNumber() throws Exception {
    System.out.println("input number");
    return br.readLine();
  }

  private Member inputNickName() throws Exception {
    Member member = new Member();
    System.out.print("input NickName : ");
    return member;
  }

  public void printAllMember() throws Exception {
    ArrayList<String> nickNames = adminController.getAllMemberNickName();
    for (int i=0; i<nickNames.size(); i++) {
      System.out.println(i+1 + ". nickName : " + nickNames.get(i));
    }

  }

}



