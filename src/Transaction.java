import java.time.LocalDate;

public class Transaction extends BankAccount{
    public double IncomeAmount;

    public String lastCategory;
    public LocalDate lastDate;
    public String lastDescription;
    public double balance;
    public double balanceE;

    public Transaction(String username, String password) {
        super(username, password);
    }

    public void addTransaction(double amount, String category, LocalDate date, String description){
        this.IncomeAmount=amount;
        this.lastCategory=category;
        this.lastDate=date;
        this.lastDescription=description;
    }

    void displayTransactions() {
         if(IncomeAmount==0){
            System.out.println("No Transactions found");
        }
        System.out.println("=== Transaction for "+getUsername()+" ===");
        System.out.println(lastCategory + ": "+'$'+IncomeAmount+" on "+lastDate+" "+" ("+lastDescription+")");
    }
    double totalIncome(double IncomeAmount){
        if(IncomeAmount>0){
            balance+=IncomeAmount;
        }
        return balance;
    }
    double totalExpense(double IncomeAmount){
        if(IncomeAmount<0){
            balanceE+=IncomeAmount;
        }
        return balanceE;
    }

    void viewSummary(){
        System.out.println("=== Financial Summary ===");
        System.out.println("Total Income: $"+totalIncome(IncomeAmount));
        System.out.println("Total Expenses: $"+totalExpense(IncomeAmount));
        if (lastCategory != null) {
            System.out.println("Last Transaction Category: " + lastCategory);
        }
    }
}
