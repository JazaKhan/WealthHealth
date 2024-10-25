package model.incomes;

import org.json.JSONObject;

import model.persistence.Writable;

// Represents a single income with the title and amount (in Dollars)
public class Income implements Writable {
    private String incomeName;
    private double incomeAmount;

    // REQUIRES: incomeName has a non-zero length.
    // EFFECTS: Name of the income is set to incomeName, and the amount of
    // income is set to incomeAmount.
    public Income(String incomeName, double incomeAmount) {
        this.incomeName = incomeName;
        this.incomeAmount = incomeAmount;
    }

    public void setIncomeName(String incomeName) {
        this.incomeName = incomeName;
    }

    public void setIncomeAmount(double incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public String getIncomeName() {
        return this.incomeName;
    }

    public double getIncomeAmount() {
        return this.incomeAmount;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", incomeName);
        json.put("amount", incomeAmount);
        return json;
    }
}
