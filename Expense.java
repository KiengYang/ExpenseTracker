package ExpenseTracker.User;

import java.util.Date;

public class Expense {
    private double amount;
    private Date date;
    private String description;

    public Expense(double amount, Date date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    // Getters for amount, date, and description
    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}

