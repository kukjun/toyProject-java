package ui;

public class LoginPage implements UI{

  @Override
  public void showUI() {
    System.out.println("--------------------------------Login Page Start--------------------------------");
    System.out.print("Input your ID, Password ");
    System.out.println("(ex. HongGilDong, 123123) : ");
  }

}
