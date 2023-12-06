package ExpenseTracker.User;

import java.util.Date;
import java.util.Objects;

public class User {
  private String username;
  private String password;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() { return username; }

  public String getPassword() { return password; }

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
