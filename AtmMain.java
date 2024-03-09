import java.io.*;
import java.util.*;

public class AtmMain 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, ATM> array = new HashMap<>();
        int n = 1;
        do 
        {
            try 
            {
                System.out.println("Enter 0:Exit 1:New User 2:Existing User");
                System.out.print("Enter your option:");
                n = Integer.parseInt(br.readLine());
                if (n == 1) 
                {
                    System.out.print("Enter Id:");
                    String id = br.readLine();
                    if (array.containsKey(id)) 
                    {
                        System.out.println("Id already Existed");
                    } 
                    else 
                    {
                        System.out.print("Create a PIN(4 Numbers):");
                        int p = Integer.parseInt(br.readLine());
                        if ((p + "").length() == 4)
                            array.put(id, new ATM(id, p, 0));
                        else
                            System.out.println("PIN  must be of length 4.");
                    }

                } 
                else if(n==2)
                {
                    System.out.print("Enter ID:");
                    String id = br.readLine();
                    if (array.containsKey(id)) 
                    {
                        System.out.print("Enter PIN");
                        int pp = Integer.parseInt(br.readLine());
                        if (array.get(id).PIN != pp)
                            System.out.println("Password Not Correct");
                        else 
                        {
                            ATM a = array.get(id);
                            int t = 1;
                            while (t != 0) 
                            {
                                System.out.println("Enter 0:Exit 1.Deposit 2.WithDraw 3.Check Balance");
                                System.out.print("Enter option:");
                                t = Integer.parseInt(br.readLine());
                                double amount;
                                switch (t) 
                                {
                                    case 1:
                                        System.out.print("Enter amount to deposit:");
                                        amount = Double.parseDouble(br.readLine());
                                        a.deposit(amount);
                                        break;
                                    case 2:
                                        System.out.print("Enter amount to WithDraw:");
                                        amount = Double.parseDouble(br.readLine());
                                        a.withDraw(amount);
                                        break;
                                    case 3:
                                        System.out.println(a.checkBalance() + "$");
                                        break;
                                    case 0:
                                        break;
                                    default:
                                        System.out.println("Invalid Input");
                                }
                            }
                        }
                    } 
                    else 
                    {
                        System.out.println("Id not found");
                    }
                }
            } 
            catch (Exception e) 
            {
                n = 5;
            }
        } while (n != 0);
        System.out.println();
        System.out.println("Thank you for using our ATM");
    }
}
