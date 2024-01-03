package ExpenseApp.User;

import java.util.Scanner;

public class Authenticate {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String userName;
    String passWord;
    int choice = 0;

    do {

      System.out.println("1. Register");
      System.out.println("2. Login");
      System.out.println("3. Quit");
      try {
        choice = sc.nextInt();
        String tmp = sc.nextLine();

        switch (choice) {
        case 1:
          do {
            System.out.println("Input Username: ");
            userName = sc.nextLine();
          } while (Register.verify(userName));
          System.out.println("Input Password: ");
          passWord = sc.nextLine();
          Register.Register(userName, passWord);
          break;
        case 2:
          System.out.println("Input name: ");
          userName = sc.nextLine();
          System.out.println("Input password: ");
          passWord = sc.nextLine();
          User user = new User(userName, passWord);
          Login.loginUser(user);
          break;
        case 3:
          break;
        }
      } catch (Exception e) {
        System.out.println("Please Input Ingerter!!");
        sc.next();
      }
    } while (choice > 3 || choice < 1);

    sc.close();
  }
}
