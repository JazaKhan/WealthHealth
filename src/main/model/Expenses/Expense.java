package model.Expenses;

// Represents a single expense with the title and amount (in Dollars)
public class Expense {

    private String expenseName;
    private double expenseAmount;

    // REQUIRES: expenseName has a non-zero length.
    // EFFECTS: Name of the expense task is set to expenseName, and the amount of
    // expense is set to expenseAmount.
    public Expense(String expenseName, double expenseAmount) {
        this.expenseName = expenseName;
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseName() {
        return this.expenseName;
    }

    public double getExpenseAmount() {
        return this.expenseAmount;
    }

}
