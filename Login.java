package ExpenseApp.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {

  static ArrayList<User> userList = new ArrayList<>();

  public static void UserList() {
    String filePath = "UserInfo.csv";

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] userInfo = line.split(",");
        User storedUser = new User(userInfo[0], userInfo[1]);
        userList.add(storedUser);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void loginUser(User loginUser) {
    UserList();

    boolean exit = false;

    for (User i : userList) {
      if (i.equals(loginUser)) {
        exit = true;
      }
    }
    if (exit) {
      System.out.println("Login complete");
      System.out.println(" ");

      handleExpenses(loginUser);
    } else {
      System.out.println("User doesn't exist");
    }
  }

  private static void handleExpenses(User user) {
    Scanner sc = new Scanner(System.in);
    int choice = 0;
    int month = 0;
    int year = 0;

    do {
      System.out.println("1. View Expenses");
      System.out.println("2. Add Expense");
      System.out.println("3. View monthExpense");
      System.out.println("4. View yearExpense");
      System.out.println("5. Change Password");
      System.out.println("6. Change Username");
      System.out.println("7. Logout");

      try {
        choice = sc.nextInt();
        sc.nextLine(); // Consume newline character
        switch (choice) {
        case 1:
          Expense.viewExpense(user);
          break;
        case 2:
          Expense.addExpense(user, sc);
          break;
        case 3:
          System.out.println("Enter month: ");
          month = sc.nextInt();
          System.out.println("Enter Year: ");
          year = sc.nextInt();
          double monthExpense =
              Expense.calculateExpenseByDate(user, month, year);
          System.out.println("Total expenses for " + month + "/" + year +
                             ": $" + monthExpense);
          break;
        case 4:
          System.out.println("Enter year: ");
          year = sc.nextInt();
          double yearExpense = Expense.calculateExpenseByDate(user, year);
          System.out.println("Total expenses for the year " + year + ": $" +
                             yearExpense);
          break;
        case 5:
          System.out.println("Enter new password:");
          String newPassword = sc.nextLine();
          user.changePassword(newPassword);
          break;
        case 6:
          System.out.println("Enter new username:");
          String newUsername = sc.nextLine();
          user.changeUsername(newUsername);
          break;
        case 7:
          break;
        default:
          System.out.println("Invalid Input");
          break;
        }
      } catch (Exception e) {
        sc.nextLine(); // Clear the invalid input
      }
    } while (choice != 7);

    sc.close();
  }
}
