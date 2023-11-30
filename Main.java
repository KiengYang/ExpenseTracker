package Budget;

import java.util.Date;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter username: ");
    String username = scanner.nextLine();

    System.out.print("Enter password: ");
    String password = scanner.nextLine();

    // Create a student user
    Student student = new Student(username, password);

    System.out.print("Enter password again to authenticate: ");
    String enteredPassword = scanner.nextLine();

    boolean isLoginSuccessful = student.authenticate(enteredPassword);

    if (isLoginSuccessful) {
      System.out.println("Login successful for user: " + student.getUsername());

      // Input expenses for user
      System.out.print("Enter expense amount: ");
      double amount = scanner.nextDouble();
      scanner.nextLine();

      System.out.print("Enter expense description: ");
      String description = scanner.nextLine();

      Date currentDate = new Date(); // Current date
      student.inputExpense(amount, currentDate, description);

      // Retrieve and display expense details
      System.out.println("\nExpense Details:");
      System.out.println("Amount: " + student.getAmount());
      System.out.println("Date: " + student.getDate());
      System.out.println("Description: " + student.getDescription());
    } else {
      System.out.println("Invalid credentials");
    }

    scanner.close();
  }
}
