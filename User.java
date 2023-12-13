
package ExpenseTracker.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
  private String username;
  private String password;
  private List<Expense> expenses;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
    this.expenses = new ArrayList<>();
  }

  public String getUsername() { return username; }

  public String getPassword() { return password; }

  public List<Expense> getExpenses() { return expenses; }

  public void addExpense(Expense expense) { expenses.add(expense); }

  public String toString() {
    return "Username: " + username + ", Password: " + password;
  }

  public void changePassword(String newPassword) {
    String filePath = "UserInfo.csv"; // Change this to your actual file path
    UpdateUserInfo.updatePassword(username, password, newPassword, filePath);
    this.password = newPassword;
    System.out.println("Password changed successfully for " + username);
  }

  public void changeUsername(String newUsername) {
    String filePath = "UserInfo.csv"; // Change this to your actual file path
    UpdateUserInfo.updateUsername(username, password, newUsername, filePath);
    String oldUsername = this.username;
    this.username = newUsername;
    System.out.println("Username changed successfully from " + oldUsername +
                       " to " + newUsername);
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
}
