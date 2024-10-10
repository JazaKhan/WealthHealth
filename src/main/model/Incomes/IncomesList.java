package model.Incomes;

import java.util.List;

//Represents a list of incomes with titles and amounts (in Dollars).
public class IncomesList {
    private List<Income> incomes;

    // EFFECTS: Initializes an empty list of incomes.
    public IncomesList() {
        // stub
    }

    // MODIFIES: this
    // EFFECTS: An income with a title and an amount (in Dollars) is added to the
    // list of incomes.
    public void addIncome(Income income) {
        // stub
    }

    // REQUIRES: IncomesList.size() > 0
    // MODIFIES: this
    // EFFECTS: An income of the user's choice is removed from the list of
    // incomes using the title provided.
    public void removeIncome(String removeTitle) {
        // stub
    }

    // REQUIRES: IncomesList.size() > 0
    // MODIFIES: this
    // EFFECTS: An income of user's choice is modified by either title, or income
    // amount,
    // or both using the title and amount provided.
    public void modifyIncome(String updateIncomeName, int updateIncomeAmount) {
        // stub
    }

}
