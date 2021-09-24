import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UI {

  public void mainPage() {
    System.out.println("Simulator를 실행합니다. ");
  }

  // login 메소드 구현
  // 추가구현 사항 -
  public User login() throws Exception {
    User user = new User();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("--------------------------------login--------------------------------");
    System.out.println("input id :");
    user.setId(br.readLine());
    System.out.println("input password :");
    user.setPassword(br.readLine());
    return user;
  }

  // register 메소드 구현
  // 추가구현 사항
  public User register() throws Exception{
    User user = new User();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("--------------------------------register--------------------------------");
    System.out.print("input create id : ");
    user.setId(br.readLine());
    System.out.print("input create nickName : ");
    user.setNickName(br.readLine());
    System.out.print("input create password : ");
    user.setPassword(br.readLine());

    System.out.println("----user----");
    System.out.println("--" + user.getId() + "--");
    System.out.println("--" + user.getNickName() + "--");
    System.out.println("--" + user.getPassword() + "--");
    System.out.println("------------");

    System.out.println("if your information is right, please enter the password one more time");
    // 회원가입 성공
    if (br.readLine().equals(user.getPassword())) {
      return user;
    }
    // 회원가입 실패
    else {
      return null;
    }
  }


  public void quit() {

  }



}