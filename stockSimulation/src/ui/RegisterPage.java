package ui;

public class RegisterPage implements UI{

  @Override
  public void showUI() {
    System.out.println("--------------------------------Register Page Start--------------------------------");
    System.out.print("Input create ID, NickName, Password : ");
    System.out.println("(ex. HongGilDong, 김치맨, 123123) : ");
  }

}
