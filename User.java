package ExpenseApp.User;

import java.util.ArrayList;
import java.util.List;

public class User extends Person {

  private List<Expense> expenses;

  public User(String userName, String passWord) {
    super(userName, passWord);
    this.expenses = new ArrayList<>();
  }

  public String getuserName() { return userName; }
  public String getpassWord() { return passWord; }

  public void changePassword(String newPassword) {
    String filePath = "UserInfo.csv";
    UpdateUserInfo.updatePassword(this.userName, this.passWord, newPassword,
                                  filePath);
    this.passWord = newPassword;
    System.out.println("Password changed successfully for " + this.userName);
  }

  public void changeUsername(String newUsername) {
    String filePath = "UserInfo.csv";
    UpdateUserInfo.updateUsername(this.userName, this.passWord, newUsername,
                                  filePath);
    String oldUsername = this.userName;
    this.userName = newUsername;
    System.out.println("Username changed successfully from " + oldUsername +
                       " to " + newUsername);
  }
  public void addExpense(Expense expense) { expenses.add(expense); }
}
