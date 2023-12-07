package ExpenseTracker.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class User {
  private String username;
  private String password;
  private List<Expense> expenses;

  public User(String username, String password ) {
    this.username = username;
    this.password = password;
    this.expenses = new ArrayList<>();
  }

  public String getUsername() { return username; }

  public String getPassword() { return password; }

  public List<Expense> getExpenses() { return expenses; }

  public void addExpense(double amount, Date date, String description) {
    Expense expense = new Expense(amount, date, description);
    expenses.add(expense);
  }

  public String toString() {
    return "Username: " + username + ", Password: " + password;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    User user = (User)obj;
    return Objects.equals(username, user.username) &&
        Objects.equals(password, user.password);
  }

  public void inputExpense(double amount, Date date, String description) {}
}
