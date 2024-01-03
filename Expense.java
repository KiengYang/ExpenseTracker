package ExpenseApp.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Expense {
  private String date;
  private double price;
  private String info;

  public Expense(String date, double price, String info) {
    this.date = date;
    this.price = price;
    this.info = info;
  }

  public String getdate() { return date; }

  public double getprice() { return price; }

  public String getinfo() { return info; }

  public static void addExpense(User user, Scanner sc) {
    System.out.println("Enter amount:");
    double price = sc.nextDouble();
    sc.nextLine(); // Consume newline character

    System.out.println("Enter description:");
    String info = sc.nextLine();

    System.out.println("Enter date (MM/dd/yyyy):");
    String date = sc.nextLine();

    Expense expense = new Expense(date, price, info);
    user.addExpense(expense);
    writeExpense(user, expense); // Write expense to the user's expense file
  }

  public static void writeExpense(User user, Expense expense) {
    String expenseFilePath = user.getuserName() + "_expenses.csv";

    try (BufferedWriter bufferedWriter =
             new BufferedWriter(new FileWriter(expenseFilePath, true))) {
      String expenseData = expense.getdate() + "," + expense.getprice() + "," +
                           expense.getinfo();
      bufferedWriter.write(expenseData);
      bufferedWriter.newLine();
      System.out.println("Expense added for " + user.getuserName());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void viewExpense(User user) {
    String expenseFilePath = user.getuserName() + "_expenses.csv";

    System.out.println("Expenses for " + user.getuserName() + ":");

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
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static double calculateExpenseByDate(User user, int month, int year) {
    String expenseFilePath = user.getuserName() + "_expenses.csv";
    double totalExpense = 0;

    try (BufferedReader br =
             new BufferedReader(new FileReader(expenseFilePath))) {
      String line;

      while ((line = br.readLine()) != null) {
        String[] expenseData = line.split(",");
        String dateStr = expenseData[0];
        double amount = Double.parseDouble(expenseData[1]);

        String[] dateParts = dateStr.split("/");
        int expenseMonth = Integer.parseInt(dateParts[0]);
        int expenseYear = Integer.parseInt(dateParts[2]);

        if (expenseMonth == month && expenseYear == year) {
          totalExpense += amount;
        }
      }
    } catch (IOException | NumberFormatException e) {
      e.printStackTrace();
    }
    return totalExpense;
  }

  public static double calculateExpenseByDate(User user, int year) {
    String expenseFilePath = user.getuserName() + "_expenses.csv";
    double totalExpense = 0;

    try (BufferedReader br =
             new BufferedReader(new FileReader(expenseFilePath))) {
      String line;

      while ((line = br.readLine()) != null) {
        String[] expenseData = line.split(",");
        String dateStr = expenseData[0];
        double amount = Double.parseDouble(expenseData[1]);

        String[] dateParts = dateStr.split("/");
        int expenseYear = Integer.parseInt(dateParts[2]);

        if (expenseYear == year) {
          totalExpense += amount;
        }
      }
    } catch (IOException | NumberFormatException e) {
      e.printStackTrace();
    }
    return totalExpense;
  }
}
