package ui;

public class MainPage implements UI{

  @Override
  public void showUI() {
    System.out.println("--------------------------------Main Page Start--------------------------------");
    System.out.println("1. Login");
    System.out.println("2. Register");
    System.out.println("3. Quit");
    System.out.println("input number : ");
  }

}
