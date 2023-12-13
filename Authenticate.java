package ExpenseTracker.User;

import java.util.Scanner;

public class Authenticate {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String Username;
    String Password;
    int choice;

    System.out.println("1. Register");
    System.out.println("2. Login");
    System.out.println("3. Quit");
    choice = sc.nextInt();
    String tmp = sc.nextLine();

    switch (choice) {
    case 1:
      do {
        System.out.println("Input name: ");
        Username = sc.nextLine();
      } while (Login.Verify(Username));
      System.out.println("Input password: ");
      Password = sc.nextLine();
      Register.registerUser(Username, Password);
      break;
    case 2:

      System.out.println("Input name: ");
      Username = sc.nextLine();
      System.out.println("Input password: ");
      Password = sc.nextLine();
      User user = new User(Username, Password);
      Login.loginUser(user);
      break;
    case 3:
      break;
    }

    sc.close();
  }
}
