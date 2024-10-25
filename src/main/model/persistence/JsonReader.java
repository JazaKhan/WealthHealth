package model.persistence;

import model.expenses.ExpensesList;
import model.incomes.IncomesList;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

//JsonSerializationDemo PROJECT WAS REFERRED TO IN ORDER TO WRITE THIS CODE.
// Represents a reader that reads ExpensesList, IncomesList from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        //stub
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ExpensesList readExpenses() throws IOException {
        //stub
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public IncomesList readIncomes() throws IOException {
        //stub
    }


    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        //stub
    }

    // EFFECTS: parses ExpensesList from JSON object and returns it
    private ExpensesList parseExpensesList(JSONObject jsonObject) {
       //stub
    }

    // EFFECTS: parses IncomesList from JSON object and returns it
    private IncomesList parseIncomesList(JSONObject jsonObject) {
        //stub
     }

    // MODIFIES: eList
    // EFFECTS: parses Expenses from JSON object and adds them to ExpensesList
    private void addExpenses(ExpensesList eList, JSONObject jsonObject) {
        //stub
    }

    // MODIFIES: iList
    // EFFECTS: parses Incomes from JSON object and adds it to IncomesList
    private void addIncomes(IncomesList iList, JSONObject jsonObject) {
        //stub
    }
}
