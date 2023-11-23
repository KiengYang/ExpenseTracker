package Budget;

import java.util.ArrayList;
import java.util.List;

public class ExpenseTracker {
  private List<User> users;
  private List<String> expenses;

  public ExpenseTracker() {
    this.users = new ArrayList<>();
    this.expenses = new ArrayList<>();
  }

  public void authenticateUser(String username, String password) {
    // Find and authenticate user logic
  }

  public void analyzeExpenses() {
    // Analyze expenses logic
  }

  public void setBudgetLimits(double limit) {
    // Set budget limits logic
  }

  public void notifyUser(String message) {
    // Notify user logic
  }
}
