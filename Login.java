package ExpenseTracker.User;


import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
      System.out.println("3. Change Password");
      System.out.println("4. Change Username");
      System.out.println("5. Logout");

      try {
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
          System.out.println("Enter new password:");
          String newPassword = sc.nextLine();
          user.changePassword(newPassword);
          break;
        case 4:
          System.out.println("Enter new username:");
          String newUsername = sc.nextLine();
          user.changeUsername(newUsername);
          break;
        case 5:
          System.out.println("LogOut");
          break;
        default:
          System.out.println("Invalid choice");
          break;
        }
      } catch (InputMismatchException e) {
        System.out.println("Exiting due to invalid input.");
        choice = 5;    // Set choice to exit
        sc.nextLine(); // Clear the invalid input
      }
    } while (choice != 5);

    sc.close();
  }

  private static void viewExpenses(User user) {
    String expenseFilePath = user.getUsername() + "_expenses.csv";

    System.out.println("Expenses for " + user.getUsername() + ":");

    try (BufferedReader br =
             new BufferedReader(new FileReader(expenseFilePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] expenseData = line.split(",");
        String dateStr = expenseData[0];
        double amount = Double.parseDouble(expenseData[1]);
        String description = expenseData[2];

        System.out.println(dateStr + " - $" + amount + " - " + description);
      }
    } catch (IOException | ArrayIndexOutOfBoundsException |
             NumberFormatException e) {
      e.printStackTrace();
    }
  }

  private static void writeExpense(User user, Expense expense) {
    String expenseFilePath = user.getUsername() + "_expenses.csv";

    try (BufferedWriter bufferedWriter =
             new BufferedWriter(new FileWriter(expenseFilePath, true))) {
      String expenseData = expense.getDate() + "," + expense.getAmount() + "," +
                           expense.getDescription();
      bufferedWriter.write(expenseData);
      bufferedWriter.newLine();
      System.out.println("Expense added for " + user.getUsername());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void addExpense(User user, Scanner sc) {
    System.out.println("Enter amount:");
    double amount = sc.nextDouble();
    sc.nextLine(); // Consume newline character

    System.out.println("Enter description:");
    String description = sc.nextLine();

    System.out.println("Enter date (MM/dd/yyyy):");
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

    Expense expense = new Expense(amount, date, description);
    user.addExpense(expense);
    writeExpense(user, expense); // Write expense to the user's expense file
  }
}
