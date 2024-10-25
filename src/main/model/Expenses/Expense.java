package model.expenses;

import org.json.JSONObject;

import model.persistence.Writable;

// Represents a single expense with the title and amount (in Dollars)
public class Expense implements Writable{

    private String expenseName;
    private double expenseAmount;

    // REQUIRES: expenseName has a non-zero length.
    // EFFECTS: Name of the expense task is set to expenseName, and the amount of
    // expense is set to expenseAmount.
    public Expense(String expenseName, double expenseAmount) {
        this.expenseName = expenseName;
        this.expenseAmount = expenseAmount;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseName() {
        return this.expenseName;
    }

    public double getExpenseAmount() {
        return this.expenseAmount;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put(expenseName, expenseAmount);
        return json;
    }

}
