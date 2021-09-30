package ui;

import main.Admin;
import main.Member;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AdminUI implements UI{

  private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private Admin admin;

  public AdminUI(Admin admin) {
    this.admin = admin;
  }

  public String showStartPage() throws Exception {
    System.out.println("--------------------------------Admin Page Start--------------------------------");
    System.out.println("1. User information change");
    System.out.println("2. User delete");
    System.out.println("3. Quit");
    System.out.print("input number : ");
    return inputNumber();
  }

  public Member showMemberInfoChange() {
    System.out.println("--------------------------------Member Information Change--------------------------------");
    System.out.println(" 구현 X");
    return null;
  }

  public Member showMemberDelete() throws Exception{
    System.out.println("--------------------------------Member Delete--------------------------------");
    return inputNickName();
  }

  private String inputNumber() throws Exception {
    return br.readLine();
  }

  private Member inputNickName() throws Exception {
    Member member = new Member();
    System.out.print("input NickName : ");
    member.setNickName(br.readLine());
    return member;
  }




}
