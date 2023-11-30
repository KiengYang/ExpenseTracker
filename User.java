package Budget;

import java.util.Date;

public class User {
  protected String username;
  protected String password;
  protected boolean isAuthenticated;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
    this.isAuthenticated = false;
  }

  public boolean authenticate(String enteredPassword) {
    if (enteredPassword.equals(password)) {
      isAuthenticated = true;
      return true;
    }
    return false;
  }

  public boolean isAuthenticated() { return isAuthenticated; }

  public void inputExpense(double amount, Date date, String description) {}

  public String getUsername() { return username; }

  public String getPassword() { return password; }
}
