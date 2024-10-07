package model.Expenses;

import java.util.List;

//Represents a list of expenses with titles and amounts (in Dollars).
public class ExpenseList {
    private List<Expenses> expenses;

    // EFFECTS: Initializes an empty list of expenses.
    public ExpenseList() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: An expense with a title and an amount (in Dollars) is added to the
    // list of expenses.
    public void addExpense() {
        // stub
    }

    // REQUIRES: ExpenseList.size() > 0
    // MODIFIES: this
    // EFFECTS: An expense of the user's choice is removed from the list of
    // expenses.
    public void removeExpense(int expenseIndex) {
        // stub
    }

    // REQUIRES: ExpenseList.size() > 0
    // MODIFIES: this
    // EFFECTS: An expense of user's choice is modified by either title, or expense,
    // or both.
    public void modifyExpense(int expenseIndex) {
        // stub
    }

}
