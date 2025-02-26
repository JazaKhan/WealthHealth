package persistence;

import org.json.JSONObject;

import model.ExpensesList;
import model.IncomesList;


import java.io.*;

//JsonSerializationDemo PROJECT WAS REFERRED TO IN ORDER TO WRITE THIS CODE.
//Represents a writer that writes JSON representation of ExpensesList, IncomesList to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of ExpensesList to file
    public void writeExpenses(ExpensesList expensesList) {
        JSONObject json = expensesList.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of IncomesList to file
    public void writeIncomes(IncomesList incomesList) {
        JSONObject json = incomesList.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file   
    private void saveToFile(String json) {
        writer.print(json);
    }
}

