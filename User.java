package Budget;

import java.util.Date;

public class User {
  private String username;
  private String password;
  private double amount;
  private Date date;
  private String description;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public boolean authenticate() {
    // Your authentication logic here
    return true; // Placeholder for authentication success
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
