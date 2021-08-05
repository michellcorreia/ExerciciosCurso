package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;
import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {
    public static void main(String args[]){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employeeList = new ArrayList<>();
        
        
        System.out.print("Enter the number of employees: ");
        Integer employeeQuantity = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<employeeQuantity; i++){
            System.out.println("Employee #" + (i+1) + " data:");
            System.out.print("Outsourced (y/n)? ");
            char outsourced = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Hours: ");
            Integer hours = sc.nextInt();
            sc.nextLine();
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();

            if(Objects.equals(outsourced, "y".charAt(0))){
                System.out.print("Additional charge: ");
                Double additionalCharge = sc.nextDouble();
                employeeList.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            }
            else{
                employeeList.add(new Employee(name, hours, valuePerHour));
            } 
        }

        System.out.println("");
        System.out.println("Payments:");
        for(Employee x: employeeList){
            System.out.println(x.getName() + " - $ " + String.format("%.2f", x.payment()));
        }
        sc.close();
    }
}
