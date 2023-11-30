package Budget;

import java.util.Date;

public class Student extends User {
  private double amount;
  private Date date;
  private String description;

  public Student(String username, String password) {
    super(username, password);
  }

  public void inputExpense(double amount, Date date, String description) {
    this.amount = amount;
    this.date = date;
    this.description = description;
  }

  public double getAmount() { return amount; }

  public Date getDate() { return date; }

  public String getDescription() { return description; }
}
