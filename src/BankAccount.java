import java.time.LocalDate;

public class BankAccount {
    public String username;
    public String password;
//    public double balance;

    public BankAccount(String username,String password){
        this.username=username;
        this.password=password;
//        this.balance=0;
    }
    public String getUsername(){
        return username;
    }

}
