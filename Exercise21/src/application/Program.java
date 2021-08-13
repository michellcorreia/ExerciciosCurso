package application;
import entities.Account;
import exceptions.DomainExceptions;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String args[]){
        
        try{
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);


            System.out.println("Enter Account Data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.print("Holder: ");
            String holder = sc.nextLine();
            System.out.print("Initial Balance: ");
            Double balance = sc.nextDouble();
            System.out.print("Withdraw Limit: ");
            Double withdrawLimit = sc.nextDouble();
            
            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.println();
            System.out.print("Enter Amount for withdraw: ");
            Double amount = sc.nextDouble();
            account.withdraw(amount);
            System.out.print("New Balance: " + String.format("%.2f", account.getBalance()));
            

            sc.close();
        }

        catch(DomainExceptions e){
            System.out.println("Withdraw error: " + e.getMessage());
        }

       
    }
}
