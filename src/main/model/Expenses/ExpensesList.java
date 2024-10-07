package model.Expenses;

import java.util.List;

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
    public void addExpense() {
        // stub
    }

    // REQUIRES: ExpensesList.size() > 0
    // MODIFIES: this
    // EFFECTS: An expense of the user's choice is removed from the list of
    // expenses.
    public void removeExpense(int expenseIndex) {
        // stub
    }

    // REQUIRES: ExpensesList.size() > 0
    // MODIFIES: this
    // EFFECTS: An expense of user's choice is modified by either title, or expense,
    // or both.
    public void modifyExpense(int expenseIndex) {
        // stub
    }

}
