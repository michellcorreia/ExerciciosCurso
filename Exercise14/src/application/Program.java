package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
																									// Exercicio de COMPOSIÇÃO

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");
		
	
		System.out.print("Enter the departament's name: ");
		String departmentName = sc.nextLine();
		Department department = new Department(departmentName);
		System.out.println("-Enter worker data-");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base Salary: ");
		Double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, department);	
		
		System.out.print("How many contracts to this worker? ");
		Integer contracts = sc.nextInt();
		for(int i=0; i<contracts; i++) {
			System.out.println();
			sc.nextLine();
			System.out.println("Enter contract number #" + (i+1) + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf1.parse(sc.nextLine());
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			Integer hours = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		sc.nextLine();
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		Date dateChoice = sdf2.parse(sc.nextLine());
				
	
		
		System.out.println(worker.toString(dateChoice));
		
		
		
		
		
		sc.close();
	}

}
