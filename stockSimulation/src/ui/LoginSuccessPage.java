package ui;

public class LoginSuccessPage implements UI{

  @Override
  public void showUI() {
    System.out.println("--------------------------------LoginSuccess Page Start--------------------------------");
    System.out.println("1. Purchase stock");
    System.out.println("2. Sell stock");
    System.out.println("3. Confirm your state");
    System.out.println("4. Before");
    System.out.println("input number : ");
  }

}
