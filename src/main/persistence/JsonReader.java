package persistence;

import model.Expense;
import model.ExpensesList;
import model.Income;
import model.IncomesList;

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
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ExpensesList readExpenses() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseExpensesList(jsonObject);
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public IncomesList readIncomes() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseIncomesList(jsonObject);
    }


    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses ExpensesList from JSON object and returns it
    private ExpensesList parseExpensesList(JSONObject jsonObject) {
        ExpensesList eList = new ExpensesList();
        addExpenses(eList, jsonObject);
        return eList;
    }

    // EFFECTS: parses IncomesList from JSON object and returns it
    private IncomesList parseIncomesList(JSONObject jsonObject) {
        IncomesList iList = new IncomesList();
        addIncomes(iList, jsonObject);
        return iList;
     }

    // MODIFIES: eList
    // EFFECTS: parses Expenses from JSON object and adds them to ExpensesList
    private void addExpenses(ExpensesList eList, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("ExpensesList");
        for (Object json : jsonArray) {
            JSONObject nextExpense = (JSONObject) json;
            addExpense(eList, nextExpense);
        }
    }

    // MODIFIES: eList
    // EFFECTS: parses expense from JSON object and adds it to ExpensesList
    private void addExpense(ExpensesList eList, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        double amount = jsonObject.getDouble("amount");
        Expense expense = new Expense(name, amount);
        eList.addExpense(expense);
    }

    // MODIFIES: iList
    // EFFECTS: parses Incomes from JSON object and adds it to IncomesList
    private void addIncomes(IncomesList iList, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("IncomesList");
        for (Object json : jsonArray) {
            JSONObject nextIncome = (JSONObject) json;
            addIncome(iList, nextIncome);
        }
    }

    // MODIFIES: iList
    // EFFECTS: parses Income from JSON object and adds it to IncomesList
    private void addIncome(IncomesList iList, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        double amount = jsonObject.getDouble("amount");
        Income income = new Income(name, amount);
        iList.addIncome(income);
    }
}
