package Budget;

import java.util.Date;
import java.util.Calendar;

public class Main {
  public static void main(String[] args) {
    // Creating a Date object using Calendar
    Calendar calendar = Calendar.getInstance();
    calendar.set(2023, Calendar.NOVEMBER, 15); // Set the desired date
    Date expenseDate = calendar.getTime();

    // Creating users
    User user1 = new User("user1", "pass123");

    // Using a Date object in inputExpense method
    user1.inputExpense(50.0, expenseDate, "Groceries");

    // Retrieving expense details
    System.out.println("User1 Amount: " + user1.getAmount());
    System.out.println("User1 Description: " + user1.getDescription());
    System.out.println("User1 Date: " + user1.getDate());
  }
}
