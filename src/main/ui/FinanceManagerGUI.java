package ui;

import javax.swing.*;
import java.awt.*;

import model.ExpensesList;
import model.IncomesList;
import persistence.JsonReader;
import persistence.JsonWriter;

//Represents the main window in which the WealthHealth App is run
public class FinanceManagerGUI extends JFrame {

    private static final String EXPENSES_FILE = "./data/expenses.json";
    private static final String INCOMES_FILE = "./data/incomes.json";

    private IncomesList incomes;
    private ExpensesList expenses;
    private boolean isProgramRunning;
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

    
}
