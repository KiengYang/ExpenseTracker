package ExpenseTracker.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Login {

  static ArrayList<User> userList = new ArrayList<User>();

  public static void UserList() {
    String filePath = "UserInfo.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] userInfo = line.split("/");
        User storedUser = new User(userInfo[0], userInfo[1]);
        userList.add(storedUser);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static boolean Verify(String name) {

    UserList();

    boolean exit = false;
    for (User i : userList) {
      if (i.getUsername().equals(name)) {
        exit = true;
      }
    }
    if (exit == true) {
      System.out.println("Username has been taken!");
      return true;
    }
    return false;
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
    int choice;

    do {
      System.out.println("1. View Expenses");
      System.out.println("2. Add Expense");
      System.out.println("3. Logout");

      choice = sc.nextInt();
      sc.nextLine(); // Consume newline character

      switch (choice) {
      case 1:
        viewExpenses(user);
        break;
      case 2:
        addExpense(user, sc);
        break;
      case 3:
        System.out.println("Logged out");
        break;
      default:
        System.out.println("Invalid choice");
        break;
      }
    } while (choice != 3);

    sc.close();
  }

  private static void viewExpenses(User user) {
    List<Expense> expenses = user.getExpenses();
    System.out.println("Expenses for " + user.getUsername() + ":");
    for (Expense expense : expenses) {
      System.out.println(expense.getDate() + " - $" + expense.getAmount() +
                         " - " + expense.getDescription());
    }
  }

  private static void addExpense(User user, Scanner sc) {
    System.out.println("Enter amount:");
    double amount = sc.nextDouble();
    sc.nextLine(); // Consume newline character

    System.out.println("Enter description:");
    String description = sc.nextLine();

    System.out.println(
        "Enter date (MM/dd/yyyy):"); // Adjust date format as needed
    String dateString = sc.nextLine();

    Date date;
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
      date = dateFormat.parse(dateString);
    } catch (ParseException e) {
      System.out.println(
          "Invalid date format. Please enter date in MM/dd/yyyy format.");
      return;
    }

    user.addExpense(amount, date, description);
    System.out.println("Expense added successfully!");
  }
}
