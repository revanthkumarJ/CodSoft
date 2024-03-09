import java.util.*;

public class ATM {
    String ID;
    int PIN;
    double balance;
    Scanner sc = new Scanner(System.in);
    ATM(String Id, int PIN, double b) 
    {
        this.ID = Id;
        this.PIN = PIN;
        this.balance = b;
    }

    public void withDraw(double amount) 
    {
        if (amount > balance)
            System.out.println("Balance Not sufficient for withDrawl");
        else
            balance = balance - amount;
    }

    public void deposit(double amount) 
    {
        balance += amount;
    }

    public double checkBalance()
    {
        return balance;
    }
}