package model.expenses;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.persistence.Writable;

//Represents a list of expenses with titles and amounts (in Dollars).
public class ExpensesList implements Writable {
    private List<Expense> expenses;

    // EFFECTS: Initializes an empty list of expenses.
    public ExpensesList() {
        expenses = new ArrayList<Expense>();
    }

    // MODIFIES: this
    // EFFECTS: An expense with a title and an amount (in Dollars) is added to the
    // list of expenses.
    public void addExpense(Expense expense) {
        this.expenses.add(expense);
    }

    // REQUIRES: ExpensesList.size() > 0
    // MODIFIES: this
    // EFFECTS: An expense of the user's choice is removed from the list.
    public void removeExpense(String name, double amount) {
        for (Expense expense : expenses) {
            if (expense.getExpenseName().equals(name) && expense.getExpenseAmount() == amount) {
                expenses.remove(expense);
                break;
            }
        }
    }

    // REQUIRES: ExpensesList.size() > 0
    // MODIFIES: this
    // EFFECTS: An expense of user's choice is updated by name.
    public void modifyExpenseName(String name, String updateExpenseName) {
        for (Expense expense : expenses) {
            if (expense.getExpenseName().equals(name)) {
                expense.setExpenseName(updateExpenseName);
                break;
            }
        }
    }

    // REQUIRES: ExpensesList.size() > 0
    // MODIFIES: this
    // EFFECTS: An expense of user's choice is updated by amount.
    public void modifyExpenseAmount(double amount, double updateExpenseAmount) {
        for (Expense expense : expenses) {
            if (expense.getExpenseAmount() == amount) {
                expense.setExpenseAmount(updateExpenseAmount);
                break;
            }
        }
    }

    // REQUIRES: ExpensesList.size() > 0
    // EFFECTS: Returns true if ExpensesList contains the given expense, and false
    // if it does not.
    public boolean contains(Expense expense) {
        if (expenses.contains(expense)) {
            return true;
        } else {
            return false;
        }
    }

    // REQUIRES: ExpensesList.size() > 0
    // EFFECTS: The list of expenses is returned to the user to view.
    public String viewExpensesList() {
        String list = "";
        for (Expense expense : expenses) {
            list += expense.getExpenseName() + ": " + expense.getExpenseAmount() + " ";
        }
        return list;
    }

    public Expense getExpense(Expense expense) {
        return expense;
    }

        @Override
    public JSONObject toJson() {
        //stub
    }

    // EFFECTS: returns Expenses in this ExpensesList as a JSON array
    private JSONArray expensesToJson() {
        //stub
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

}
