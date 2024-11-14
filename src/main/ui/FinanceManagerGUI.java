package ui;

import javax.swing.*;
import java.awt.*;

import model.Expense;
import model.ExpensesList;
import model.Income;
import model.IncomesList;
import persistence.JsonReader;
import persistence.JsonWriter;

//Represents the main window in which the WealthHealth App is run
public class FinanceManagerGUI extends JFrame {

    private static final String EXPENSES_FILE = "./data/expenses.json";
    private static final String INCOMES_FILE = "./data/incomes.json";

    private IncomesList incomes;
    private ExpensesList expenses;
    private JsonWriter jsonWriterExp;
    private JsonReader jsonReaderExp;
    private JsonWriter jsonWriterInc;
    private JsonReader jsonReaderInc;

    public FinanceManagerGUI() {
        init();
        screen();
    }

    // EFFECTS: Manages data and program execution
    public void init() {
        jsonWriterExp = new JsonWriter(EXPENSES_FILE);
        jsonReaderExp = new JsonReader(EXPENSES_FILE);
        jsonWriterInc = new JsonWriter(INCOMES_FILE);
        jsonReaderInc = new JsonReader(INCOMES_FILE);
    }

    // EFFECTS: Sets up GUI screen
    public void screen() {
        setSize(800, 600);
        setTitle("WealthHealth");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //EFFECTS: Creates a header for the GUI Screen
    public void header(){
        //stub
    }

    //EFFECTS: Contains the centered content for the GUI Screen
    public void content(){
        //stub
    }

    //EFFECTS: Creates the buttons required
    public void buttons(){
        //stub
    }

    // MODIFIES: this
    // EFFECTS: adds a new income to the list of incomes
    public void addIncome() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: adds a new expense to the list of expenses
    public void addExpense() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: removes an income from the list of incomes
    public void removeIncome() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: removes an expense from the list of expenses
    public void removeExpense() {
        //stub
    }

    // REQUIRES: incomes > 0
    // MODIFIES: this
    // EFFECTS: Changes the income name or amount based on user preferences.
    public void modifyIncome() {
        //stub
    }

    // REQUIRES: expenses > 0
    // MODIFIES: this
    // EFFECTS: Changes the expense name or amount based on user preferences.
    public void modifyExpense() {
        //stub
    }

    // EFFECTS: Displays the list of incomes.
    public void viewIncomesList() {
        //stub
    }

    // EFFECTS: Displays the list of expenses.
    public void viewExpensesList() {
        //stub
    }

    // EFFECTS: Saves the program to File
    public void saveProgram() {
        //stub
    }

    // Effects: Reloads progress to program
    public void reloadProgress() {
        //stub
    }

    // EFFECTS: saves the expenses to file
    private void saveExpenses() {
        //stub
    }

    // EFFECTS: saves the incomes to file
    private void saveIncomes() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: loads expenses from file
    private void reloadExpenses() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: loads incomes from file
    private void reloadIncomes() {
        //stub
    }

    //EFFECTS: view data in a picture format (working on it still)
    public void viewData(){
        //stub
    }
}
