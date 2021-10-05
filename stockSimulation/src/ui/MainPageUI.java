package ui;

import db.table.Member;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainPageUI implements UI {

  // MainPage 구현을 위한 UI
  private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public String showStartPage() throws Exception {
    System.out.println("--------------------------------Main Page Start--------------------------------");
    System.out.println("1. Login");
    System.out.println("2. Register");
    System.out.println("3. Quit");
    System.out.print("input number : ");
    return inputNumber();
  }

  public Member showLoginPage() throws Exception {
    System.out.println("--------------------------------Login--------------------------------");
    return inputIdAndPassword();
    // 이 정보를 누가 가지고 있어야 하나? -> user 관리한는 애가 가지고 있어야 한다. -> 데이터베이스와 맞춰보는 연산은 얘기 한다.
    // UserProcess 로 넘겨줘야 한다.
  }

  public Member showRegisterPage() throws Exception {
    Member member;
    System.out.println("--------------------------------Register--------------------------------");
    member = inputIdAndPassword();
    System.out.print("input NickName : ");
    member.setNickname(br.readLine());
    System.out.println(member.toString());
    System.out.println("if you want to sign up, enter your password.");
    System.out.print("input Password : ");
    if(member.getPassword().equals(br.readLine())) {
      return member;
    } else {
      return null;
    }
  }

  public void showQuitPage() throws Exception {
    System.out.println("--------------------------------Quit--------------------------------");
    System.out.println("MainPage를 종료합니다.");
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
    return br.readLine();
  }

}
