package ui;

import model.Incomes.Income;
import model.Incomes.IncomesList;
import model.Expenses.Expense;
import model.Expenses.ExpensesList;

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
        init();

        System.out.println("Welcome to WealthHealth!");

        while (this.isProgramRunning) {
            excecuteProgram();
        }
    }

    // REQUIRES: incomeName has a non-zero length.
    // EFFECTS: initializes fields (scanner, isProgramRunning, incomes, expenses)
    public void init() {
        this.scanner = new Scanner(System.in);
        this.isProgramRunning = true;
        this.incomes = new IncomesList();
        this.expenses = new ExpensesList();
    }

    // EFFECTS: Display and then process user choices for the main menu.
    public void excecuteProgram() {
        displayMenu();
        String input = this.scanner.nextLine();
        processMenuCommands(input);
    }

    // EFFECTS: Displays a list of commands that the user can choose from
    public void displayMenu() {
        System.out.println("Select one of the following options: \n");
        System.out.println("1. Add Income");
        System.out.println("2. Add Expense");
        System.out.println("3. Remove Income");
        System.out.println("4. Remove Expense");
        System.out.println("5. Modify Income");
        System.out.println("6. Modify Expense");
        System.out.println("7. View List of Incomes");
        System.out.println("8. View List of Expenses");
        System.out.println("9. Quit");
    }

    // EFFECTS: Use the user input to execute appropriate response
    public void processMenuCommands(String input) {
        switch (input) {
            case "1":
                addIncome();
                break;
            case "2":
                addExpense();
                break;
            case "3":
                removeIncome();
                break;
            case "4":
                removeExpense();
                break;
            case "5":
                modifyIncome();
                break;
            case "6":
                modifyExpense();
            case "7":
                viewIncomesList();
                break;
            case "8":
                viewExpensesList();
                break;
            case "9":
                endProgram();
                break;
            default:
                System.out.println("Invalid Entry, try again!");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a new income to the list of incomes
    public void addIncome() {
        System.out.println("Please enter the title of your income: ");
        String incomeName = this.scanner.nextLine();

        System.out.println("What is the amount of your income: ");
        double incomeAmount = this.scanner.nextDouble();

        Income income = new Income(incomeName, incomeAmount);
        this.incomes.addIncome(income);
        System.out.println("\nNew Income Added");
    }

    // MODIFIES: this
    // EFFECTS: adds a new expense to the list of expenses
    public void addExpense() {
        System.out.println("Please enter the title of your expense: ");
        String expenseName = this.scanner.nextLine();

        System.out.println("What is the amount of your income: ");
        double expenseAmount = this.scanner.nextDouble();

        Expense expense = new Expense(expenseName, expenseAmount);
        this.expenses.addExpense(expense);
        System.out.println("\nNew Expense Added");
    }

    // MODIFIES: this
    // EFFECTS: removes an income from the list of incomes
    public void removeIncome() {
        System.out.println("Please enter the title of the income you wish to remove: ");
        String incomeName = this.scanner.nextLine();

        System.out.println("What is the amount of your income you wish to remove: ");
        double incomeAmount = this.scanner.nextDouble();

        this.incomes.removeIncome(incomeName, incomeAmount);
        System.out.println("\nIncome removed");

    }

    // MODIFIES: this
    // EFFECTS: removes an expense from the list of expenses
    public void removeExpense() {
        System.out.println("Please enter the title of the expense you wish to remove: ");
        String expenseName = this.scanner.nextLine();

        System.out.println("What is the amount of your expense you wish to remove: ");
        double expenseAmount = this.scanner.nextDouble();

        this.expenses.removeExpense(expenseName, expenseAmount);
        System.out.println("\nExpense removed");

    }

    //REQUIRES: incomes > 0
    //MODIFIES: this
    //EFFECTS: Changes the income name or amount based on user preferences.
    public void modifyIncome(){
        System.out.println("Would you like to modify by title (input T) or by amount (input A)? ");
        String type = this.scanner.nextLine();

        if (type.equals("T")){
            System.out.println("Which title would you like to modify? ");
            String name = this.scanner.nextLine();

            System.out.println("Enter updated title: ");
            String updatedName = this.scanner.nextLine();

            incomes.modifyIncomeName(name, updatedName);
        }

        if (type.equals("A")){
            System.out.println("Which amount would you like to modify? ");
            String amount = this.scanner.nextLine();
            double amountDouble = Double.valueOf(amount);

            System.out.println("Enter updated amount: ");
            String updatedAmount = this.scanner.nextLine();
            double updatedAmountDouble = Double.valueOf(updatedAmount);

            incomes.modifyIncomeAmount(amountDouble, updatedAmountDouble);
        }
    }

    //REQUIRES: expenses > 0
    //MODIFIES: this
    //EFFECTS: Changes the expense name or amount based on user preferences.
    public void modifyExpense(){
        System.out.println("Would you like to modify by title (input T) or by amount (input A)? ");
        String type = this.scanner.nextLine();

        if (type.equals("T")){
            System.out.println("Which title would you like to modify? ");
            String name = this.scanner.nextLine();

            System.out.println("Enter updated title: ");
            String updatedName = this.scanner.nextLine();

            expenses.modifyExpenseName(name, updatedName);
        }

        if (type.equals("A")){
            System.out.println("Which amount would you like to modify? ");
            String amount = this.scanner.nextLine();
            double amountDouble = Double.valueOf(amount);

            System.out.println("Enter updated amount: ");
            String updatedAmount = this.scanner.nextLine();
            double updatedAmountDouble = Double.valueOf(updatedAmount);

            expenses.modifyExpenseAmount(amountDouble, updatedAmountDouble);
        }
    }   

    // EFFECTS: Displays the list of incomes.
    public void viewIncomesList() {
        System.out.println(incomes.viewIncomesList());
    }

    // EFFECTS: Displays the list of expenses.
    public void viewExpensesList() {
        System.out.println(expenses.viewExpensesList());
    }

    // MODIFIES: this
    // EFFECTS: Kills the program and prints a goodbye message
    public void endProgram() {
        System.out.println("Thank you for tracking your wealth!");
        this.isProgramRunning = false;
    }

}
