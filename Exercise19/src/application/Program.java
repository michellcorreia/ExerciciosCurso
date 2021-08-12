package application;
import entities.Person;
import entities.LegalPerson;
import entities.NaturalPerson;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Program{
    public static void main(String args[]){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Person> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<n; i++){
            System.out.println("Tax payer #" + (i+1) + " data:");
            System.out.print("Individual or company (i/c)? ");
            char choice = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            Double annualEarnings = sc.nextDouble();     
            
            if(Objects.equals(choice, "i".charAt(0))){
                System.out.print("Health expenditures: ");
                Double healthExpenses = sc.nextDouble();

                list.add(new NaturalPerson(name, annualEarnings, healthExpenses));
            }
            else{
                System.out.print("Number of employees: ");
                int employeeQuantity = sc.nextInt();
                sc.nextLine();

                list.add(new LegalPerson(name, annualEarnings, employeeQuantity));
            }    
        }
       
        System.out.println();
        System.out.println("TAXES PAID: ");
        Double sum = 0.0;
        for(Person x : list){
            System.out.println(x.getName() + ": $ " + String.format("%.2f", x.taxes()));
            sum += x.taxes();
        }
        System.out.println();
        System.out.println("Total taxes: $ " + String.format("%.2f", sum));

        sc.close();
    }
}