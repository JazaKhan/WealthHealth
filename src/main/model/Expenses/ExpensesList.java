package model.Expenses;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

//Represents a list of expenses with titles and amounts (in Dollars).
public class ExpensesList {
    private List<Expense> expenses;

    // EFFECTS: Initializes an empty list of expenses.
    public ExpensesList() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: An expense with a title and an amount (in Dollars) is added to the
    // list of expenses.
    public void addExpense(Expense expense) {
        // stub
    }

    // REQUIRES: ExpensesList.size() > 0
    // MODIFIES: this
    // EFFECTS: An expense of the user's choice is removed from the list.
    public void removeExpense(Expense expense) {
        // stub
    }

    // REQUIRES: ExpenseList.size() > 0
    // MODIFIES: this
    // EFFECTS: An expense of user's choice is updated by name.
    public void modifyExpenseName(Expense expense, String updateExpenseName) {
        // stub
    }

    // REQUIRES: ExpenseList.size() > 0
    // MODIFIES: this
    // EFFECTS: An expense of user's choice is updated by amount.
    public void modifyExpenseAmount(Expense expense, int updateExpenseAmount) {
        // stub
    }

    // REQUIRES: ExpensesList.size() > 0
    // EFFECTS: Returns true if ExpensesList contains the given expense, and false
    // if it does not.
    public boolean contains(Expense expense) {
        return false;
    }

    // REQUIRES: ExpensesList.size() > 0
    // EFFECTS: The list of expenses is returned to the user to view.
    public String viewExpensesList() {
        return null;
    }

    public Expense getExpense(Expense expense) {
        return null;
    }

}
