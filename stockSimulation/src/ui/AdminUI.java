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


  public void showStartPage() throws Exception {
    String input;
    System.out.println("--------------------------------Admin Page Start--------------------------------");
    do {
      System.out.println("1. User information confirm");
      System.out.println("2. User delete");
      System.out.println("3. Quit");
      input = inputNumber();
      switch (input) {
        case "1":
          showMemberInfoConfirm();
          break;
        case "2":
          showMemberDelete();
          break;
        case "3":
          showQuitPage();
          break;
        default:
          System.out.println("잘못입력하셨습니다. 다시 입력하세요.");
          break;
      }
    } while (!input.equals("3"));
  }

  public boolean showMemberInfoConfirm() throws Exception {
    System.out.println("--------------------------------Member Information Confirm--------------------------------");
    printAllMember();
    Member member = adminController.getMemberInfo(inputNickName());
    if (member == null) {
      return false;
    }
    else {
      printMemberInfo(member);
      // changeMemberInfo 내용 작성
      return true;
    }
  }

  public boolean showMemberDelete() throws Exception {
    System.out.println("--------------------------------Member Delete--------------------------------");
    printAllMember();
    Member member = adminController.getMemberInfo(inputNickName());
    if (member == null) {
      return false;
    }
    else {
      return adminController.deleteMember(member);
    }
  }
  public void showQuitPage() throws Exception {
    System.out.println("--------------------------------Quit--------------------------------");
    System.out.println("AdminUI를 종료합니다.");
  }

  private String inputNumber() throws Exception {
    System.out.print("input number: ");
    return br.readLine();
  }

  private String inputNickName() throws Exception {
    System.out.print("input NickName : ");
    return br.readLine();
  }

  public void printAllMember() throws Exception {
    ArrayList<String> nickNames = adminController.getAllMemberNickName();
    for (int i = 0; i < nickNames.size(); i++) {
      System.out.println((i + 1) + " nickName : " + nickNames.get(i));
    }

  }

  public void printMemberInfo(Member member) {
    System.out.println(member);
  }

}



