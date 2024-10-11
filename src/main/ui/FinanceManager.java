package ui;

import model.Incomes.Income;
import model.Incomes.IncomesList;
import model.Expenses.Expense;
import model.Expenses.ExpensesList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//LAB 4 WAS USED TO ASSIST WITH THIS PART.
// Represents the result of user interaction with the two lists: expenses and incomes.
public class FinanceManager {
    private Scanner scanner;
    private IncomesList incomes;
    private ExpensesList expenses;
    private boolean isProgramRunning;

    // EFFECTS: prints a welcome messae and manages program execution.
    public FinanceManager() {
        // stub
    }

    // REQUIRES: incomeName has a non-zero length.
    // EFFECTS: initializes fields (scanner, isProgramRunning, incomes, expenses)
    public void init() {
        // stub
    }

    // EFFECTS: Display and then process user choices for the main menu.
    public void excecuteProgram() {
        // stub
    }

    // EFFECTS: Displays a list of commands that the user can choose from
    public void displayMenu() {
        // stub
    }

    // EFFECTS: Use the user input to execute appropriate response
    public void processMenuCommands(String input) {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: adds a new income to the list of incomes
    public void addIncome() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: adds a new expense to the list of expenses
    public void addExpense() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: removes an income from the list of incomes
    public void removeIncome() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: removes an expense from the list of expenses
    public void removeExpense() {
        // stub
    }

    // EFFECTS: Displays the list of incomes.
    public void viewIncomesList() {
        // stub
    }

    // EFFECTS: Displays the list of expenses.
    public void viewExpensesList() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: Kills the program and prints a goodbye message
    public void endProgram() {
        //stub
    }

}
