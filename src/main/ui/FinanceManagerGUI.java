package ui;

import javax.swing.*;

import java.awt.*;

import model.Expense;
import model.ExpensesList;
import model.Income;
import model.IncomesList;
import persistence.JsonReader;
import persistence.JsonWriter;

//Referred to C3-LectureLabStarter, AlarmSystem, geeksforgeeks (https://www.geeksforgeeks.org/introduction-to-java-swing/)
//Cottrell Coding (https://www.youtube.com/watch?v=WOooJ_165xY&ab_channel=CottrellCoding)
//Telusko (https://www.youtube.com/watch?v=Xh0HZJ3Gd2c&ab_channel=Telusko)
//StackOverflow (https://stackoverflow.com/questions/9698359/setbackgroundnew-color-in-java-does-not-understand-the-given-rgb-value)

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

    // Initializes files and Manages Program Execution
    public FinanceManagerGUI() {
        jsonWriterExp = new JsonWriter(EXPENSES_FILE);
        jsonReaderExp = new JsonReader(EXPENSES_FILE);
        jsonWriterInc = new JsonWriter(INCOMES_FILE);
        jsonReaderInc = new JsonReader(INCOMES_FILE);

        init();
        screen();
    }

    // EFFECTS: Initializes Income and Expense Lists
    public void init() {
        this.incomes = new IncomesList();
        this.expenses = new ExpensesList();
    }

    // EFFECTS: Sets up and Manage GUI Screen
    public void screen() {
        setSize(800, 600);
        setTitle("WealthHealth");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel headerJPanel = header();
        JPanel center = center();
        JPanel buttons = buttons();

        add(headerJPanel, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
    }

    // EFFECTS: Returns a JPanel header for the GUI Screen
    public JPanel header() {
        JPanel headerJPanel = new JPanel();
        headerJPanel.setBackground(new Color(152, 255, 168));
        Font font = new Font("Arial", Font.BOLD, 26);
        JLabel titleName = new JLabel("WealthHealth");
        titleName.setFont(font);
        headerJPanel.add(titleName);
        return headerJPanel;
    }

    // Referrenced Oracle Forums
    // (https://forums.oracle.com/ords/apexds/post/how-to-center-a-jlabel-on-a-jframe-0912)
    // EFFECTS: Manages and Returns the Centered content for the GUI Screen
    public JPanel center() {
        JPanel transactionHistory = new JPanel(new GridBagLayout());
        transactionHistory.setBackground(new Color(54, 69, 79));
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(new ImageIcon(
                "C:\\Users\\Intikhab\\Desktop\\Jaza\\UBC\\CPSC 210\\PROJECT\\ProjectStarter\\images\\WEALTHHEALTH.png")
                .getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
        transactionHistory.add(label);
        return transactionHistory;
    }

    // EFFECTS: Creates the button bar, and the buttons required, and has them lead
    // to appropriate methods/events
    @SuppressWarnings("methodlength") // get approved by TA
    public JPanel buttons() {
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(3, 1, 3, 3));
        buttons.setBackground(Color.lightGray);

        JButton addIncome = new JButton("Add Income");
        JButton addExpense = new JButton("Add Expense");
        JButton removeIncome = new JButton("Remove Income");
        JButton removeExpense = new JButton("Remove Expense");
        JButton modifyIncome = new JButton("Modify Income");
        JButton modifyExpense = new JButton("Modify Expense");
        JButton saveProgram = new JButton("Save Program");
        JButton reloadProgress = new JButton("Reload Progress");
        JButton viewLogo = new JButton("View Logo");
        JButton viewIncomes = new JButton("View Incomes");
        JButton viewExpenses = new JButton("View Expenses");

        addIncome.setBackground(Color.MAGENTA);
        removeIncome.setBackground(Color.MAGENTA);
        modifyIncome.setBackground(Color.MAGENTA);
        addExpense.setBackground(Color.GREEN);
        removeExpense.setBackground(Color.GREEN);
        modifyExpense.setBackground(Color.GREEN);
        saveProgram.setBackground(Color.PINK);
        reloadProgress.setBackground(Color.PINK);

        addIncome.addActionListener(ae -> addIncome());
        addExpense.addActionListener(ae -> addExpense());
        removeIncome.addActionListener(ae -> removeIncome());
        removeExpense.addActionListener(ae -> removeExpense());
        modifyIncome.addActionListener(ae -> modifyIncome());
        modifyExpense.addActionListener(ae -> modifyExpense());
        saveProgram.addActionListener(ae -> saveProgram());
        reloadProgress.addActionListener(ae -> reloadProgress());
        viewLogo.addActionListener(ae -> viewLogo());
        viewIncomes.addActionListener(ae -> viewIncomesList());
        viewExpenses.addActionListener(ae -> viewExpensesList());

        buttons.add(addIncome);
        buttons.add(addExpense);
        buttons.add(removeIncome);
        buttons.add(removeExpense);
        buttons.add(modifyIncome);
        buttons.add(modifyExpense);
        buttons.add(saveProgram);
        buttons.add(reloadProgress);
        buttons.add(viewLogo);
        buttons.add(viewIncomes);
        buttons.add(viewExpenses);

        return buttons;
    }

    // Referrenced stackoverflow
    // (https://stackoverflow.com/questions/40068703/how-to-get-user-input-as-a-double-and-then-perform-calculations-with-it)
    // MODIFIES: this
    // EFFECTS: adds a new income to the list of incomes
    public void addIncome() {
        try {
            String name = JOptionPane.showInputDialog("Please enter the title of your income");
            String strAmount = JOptionPane.showInputDialog("Please enter the amount of your income");

            Double amount = Double.parseDouble(strAmount);

            Income income = new Income(name, amount);

            incomes.addIncome(income);
            JOptionPane.showMessageDialog(null, "Added Income Successfully!", "Success!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to Add Income", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a new expense to the list of expenses
    public void addExpense() {
        try {
            String name = JOptionPane.showInputDialog("Please enter the title of your expense");
            String strAmount = JOptionPane.showInputDialog("Please enter the amount of your expense");

            Double amount = Double.parseDouble(strAmount);

            Expense expense = new Expense(name, amount);

            expenses.addExpense(expense);
            JOptionPane.showMessageDialog(null, "Added Expense Successfully!", "Success!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to Add Expense", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: removes an income from the list of incomes
    public void removeIncome() {
        try {
            String name = JOptionPane.showInputDialog("Please enter the title of the income you'd like to remove");
            String strAmount = JOptionPane.showInputDialog("Please enter the amount of the income");

            Double amount = Double.parseDouble(strAmount);

            incomes.removeIncome(name, amount);
            JOptionPane.showMessageDialog(null, "Removed Income Successfully!", "Success!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to Remove Income", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: removes an expense from the list of expenses
    public void removeExpense() {
        try {
            String name = JOptionPane.showInputDialog("Please enter the title of the expense you'd like to remove");
            String strAmount = JOptionPane.showInputDialog("Please enter the amount of the expense");

            Double amount = Double.parseDouble(strAmount);

            expenses.removeExpense(name, amount);
            JOptionPane.showMessageDialog(null, "Removed Expense Successfully!", "Success!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to Remove Expense", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // REQUIRES: incomes > 0
    // MODIFIES: this
    // EFFECTS: Changes the income name or amount based on user preferences.
    public void modifyIncome() {
        try {
            String choice = JOptionPane
                    .showInputDialog("Would you like to modify by title (input T) or by amount (input A)?");

            if (choice.equals("T")) {
                String name = JOptionPane.showInputDialog("Which title would you like to modify?");
                String updatedName = JOptionPane.showInputDialog("Enter updated title:");

                incomes.modifyIncomeName(name, updatedName);
            }

            if (choice.equals("A")) {
                String strAmount = JOptionPane.showInputDialog("Which amount would you like to modify?");
                Double amount = Double.parseDouble(strAmount);

                String strUpdatedAmt = JOptionPane.showInputDialog("Enter updated amount:");
                Double updatedAmount = Double.parseDouble(strUpdatedAmt);

                incomes.modifyIncomeAmount(amount, updatedAmount);
            }
            JOptionPane.showMessageDialog(null, "Modified Successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to Modify", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // REQUIRES: expenses > 0
    // MODIFIES: this
    // EFFECTS: Changes the expense name or amount based on user preferences.
    public void modifyExpense() {
        try {
            String choice = JOptionPane
                    .showInputDialog("Would you like to modify by title (input T) or by amount (input A)?");

            if (choice.equals("T")) {
                String name = JOptionPane.showInputDialog("Which title would you like to modify?");
                String updatedName = JOptionPane.showInputDialog("Enter updated title:");

                expenses.modifyExpenseName(name, updatedName);
            }

            if (choice.equals("A")) {
                String strAmount = JOptionPane.showInputDialog("Which amount would you like to modify?");
                Double amount = Double.parseDouble(strAmount);

                String strUpdatedAmt = JOptionPane.showInputDialog("Enter updated amount:");
                Double updatedAmount = Double.parseDouble(strUpdatedAmt);

                expenses.modifyExpenseAmount(amount, updatedAmount);
            }
            JOptionPane.showMessageDialog(null, "Modified Successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to Modify", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Referrenced StackOverflow
    // (https://stackoverflow.com/questions/5255726/display-list-on-a-jframe)
    // (https://stackoverflow.com/questions/3269516/java-arraylists-into-jlist)
    // EFFECTS: Displays the list of incomes.
    public void viewIncomesList() {
        JFrame f = new JFrame("List of Incomes");
        JList<Income> viewIncomes = new JList<>(incomes.getIncomes().toArray(new Income[0]));
        f.add(viewIncomes);
        f.pack();
        f.setSize(500, 500);
        f.setVisible(true);
    }

    // EFFECTS: Displays the list of expenses.
    public void viewExpensesList() {
        JFrame f = new JFrame("List of Expenses");
        JList<Expense> viewExpenses = new JList<>(expenses.getExpenses().toArray(new Expense[0]));
        f.add(viewExpenses);
        f.pack();
        f.setSize(500, 500);
        f.setVisible(true);
    }

    // EFFECTS: Saves the program to File
    public void saveProgram() {
        try {
            saveIncomes();
            saveExpenses();
            JOptionPane.showMessageDialog(null, "Saved Successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to Write to File", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Effects: Reloads progress to program
    public void reloadProgress() {
        try {
            reloadIncomes();
            reloadExpenses();
            JOptionPane.showMessageDialog(null, "Read Successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to Read File", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // EFFECTS: saves the expenses to file
    private void saveExpenses() {
        try {
            jsonWriterExp.open();
            jsonWriterExp.writeExpenses(expenses);
            jsonWriterExp.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to Write to File", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // EFFECTS: saves the incomes to file
    private void saveIncomes() {
        try {
            jsonWriterInc.open();
            jsonWriterInc.writeIncomes(incomes);
            jsonWriterInc.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to Write to File", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads expenses from file
    private void reloadExpenses() {
        try {
            expenses = jsonReaderExp.readExpenses();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to Read File", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads incomes from file
    private void reloadIncomes() {
        try {
            incomes = jsonReaderInc.readIncomes();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to Read File", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Referrenced:
    // https://medium.com/@michael71314/java-lesson-22-inserting-images-onto-the-jframe-a0a0b6540cca
    // EFFECTS: Displays App Logo in a picture format
    public void viewLogo() {
        Frame frame = new JFrame("WealthHealth Logo");
        frame.setSize(600, 600);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(new ImageIcon(
                "C:\\Users\\Intikhab\\Desktop\\Jaza\\UBC\\CPSC 210\\PROJECT\\ProjectStarter\\images\\Logo.PNG")
                .getImage()
                .getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
        frame.add(label);
        frame.pack();
        frame.setVisible(true);
    }
}
