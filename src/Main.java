import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String username;
        String password;
        System.out.println("**************************************");
        System.out.println("Welcome to Personal Finance Manager");
        System.out.println("**************************************");
        System.out.print("Enter username: ");
        username=scanner.nextLine();
        System.out.print("Enter password: ");
        password=scanner.nextLine();

        BankAccount account=new BankAccount(username,password);
        Transaction transaction=new Transaction(account.username, account.password);


        double IncomeAmount;
        String category;
        LocalDate date;
        String description;

        while(true){
            System.out.println("=== Personal Finance Manager ===");
            System.out.println("1.Add Transaction");
            System.out.println("2.View Transaction");
            System.out.println("3.View Summary");
            System.out.println("4.Exit");
            System.out.print("Enter your choice: ");
            int choice;
            choice=scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 -> {
                    System.out.println("=== Transaction ===");
                    System.out.print("Enter amount (positive for income, negative for expense): ");
                    IncomeAmount=scanner.nextDouble();

                    transaction.totalIncome(IncomeAmount);
                    transaction.totalExpense(IncomeAmount);
                    scanner.nextLine();
                    System.out.print("Enter category: " );
                    category=scanner.nextLine();
                    if (category.isEmpty()) {
                        System.out.println("Category cannot be empty.");
                        return;
                    }

                    System.out.print("Enter date (YYYY-MM-DD:) ");
                    date = LocalDate.parse(scanner.nextLine());

                    System.out.print("Enter description: ");
                    description=scanner.nextLine();

                    transaction.addTransaction(IncomeAmount, category, date, description);
                    System.out.println("Transaction added!");
                }
                case 2 -> {
                    System.out.println("=== View Transaction ===");
                    transaction.displayTransactions();
                }
                case 3 -> transaction.viewSummary();
                case 4 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                }
                default -> {
                    System.out.println("Invalid choice");
                    System.out.println("Please enter 1,2,3 or 4");
                }
            }

        }


    }
}
