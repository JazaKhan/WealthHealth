package model.persistence;
import org.json.JSONObject;

import model.expenses.ExpensesList;
import model.incomes.IncomesList;


import java.io.*;

//JsonSerializationDemo PROJECT WAS REFERRED TO IN ORDER TO WRITE THIS CODE.
//Represents a writer that writes JSON representation of ExpensesList, IncomesList to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
       //stub
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of ExpensesList to file
    public void writeExpenses(ExpensesList eList) {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of IncomesList to file
    public void writeIncomes(IncomesList iList) {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: writes string to file   
    private void saveToFile(String json) {
        //stub
    }
}

