package ui;

import controller.MainPageController;
import db.table.Member;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainPageUI extends UI {

  // MainPage 구현을 위한 UI
  private MainPageController mainPageController;
  private BufferedReader br;

  public MainPageUI(MainPageController mainPageController) {
    this.member = null;
    this.mainPageController = mainPageController;
    br = new BufferedReader(new InputStreamReader(System.in));
  }

  @Override
  public void showStartPage() throws Exception {
    String input;
    System.out.println("--------------------------------Main Page Start--------------------------------");
    do {
      System.out.println("1. Login");
      System.out.println("2. Register");
      System.out.println("3. Quit");
      input = inputNumber();
      switch (input) {
        case "1":
          showLoginPage();
          if (this.member == null) {
            failLogin();
          } else {
            successLogin();
            return;
          }
          break;
        case "2":
          System.out.println(showRegisterPage());
          break;
        case "3":
          showQuitPage();
          break;
        default:
          System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
      }
    } while (!input.equals("3"));
    this.member = null;
  }

  public void showLoginPage() throws Exception {
    Member member;
    System.out.println("--------------------------------Login--------------------------------");
    member = inputIdAndPassword();
    this.member = mainPageController.checkMemberDB(member);
  }

  public boolean showRegisterPage() throws Exception {
    Member member;
    System.out.println("--------------------------------Register--------------------------------");
    member = inputMember();
    printMemberInfo(member);
    System.out.println("if you want to sign up, enter your password.");
    System.out.print("input Password : ");
    if (member.getPassword().equals(br.readLine())) {
      if (mainPageController.registerMember(member)) {
        return true;
      }
      return false;
    } else {
      return false;
    }
  }

  public void showQuitPage() throws Exception {
    System.out.println("--------------------------------Quit--------------------------------");
    System.out.println("MainPage를 종료합니다.");
  }

  public String state(String state) {
    return state;
  }

  // 입력 예외 처리해주기
  private Member inputIdAndPassword() throws Exception {
    Member member = new Member();
    System.out.print("input Id :");
    member.setId(br.readLine());
    System.out.print("input Password :");
    member.setPassword(br.readLine());
    return member;
  }

  private String inputNumber() throws Exception {
    System.out.print("input number : ");
    return br.readLine();
  }

  private Member inputMember() throws Exception {
    Member member = inputIdAndPassword();
    System.out.print("input nickname : ");
    member.setNickname(br.readLine());
    return member;
  }

  private void printMemberInfo(Member member) {
    System.out.println("id: " + member.getId());
    System.out.println("password: " + member.getPassword());
    System.out.println("nickname: " + member.getNickname());
  }

  private void failLogin() {
    System.out.println("로그인에 실패했습니다.");
  }

  private void successLogin() {
    System.out.println("로그인에 성공하셨습니다.");
  }


}
