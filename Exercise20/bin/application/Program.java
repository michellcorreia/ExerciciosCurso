package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String args[]) {
   
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy");
	Reservation res = new Reservation();

	try{
	    System.out.print("Room number: ");
	    int roomNumber = sc.nextInt();
	    sc.nextLine();
	    System.out.print("Check-in date (dd/MM/yyyy): ");
	    Date checkin = sdf.parse(sc.nextLine());
	    System.out.print("Check-out date (dd/MM/yyyy): ");
	    Date checkout = sdf.parse(sc.nextLine());
	    res.updateDates(checkin, checkout, sc);
	    res = new Reservation(roomNumber, res.getCheckin(), res.getCheckout());
        
        System.out.println(res);
	    System.out.println();

	
	    System.out.println("Enter data to update the reservation: ");
	    System.out.print("Check-in date (dd/MM/yyyy): ");
	    checkin = sdf.parse(sc.nextLine());
	    System.out.print("Check-out date (dd/MM/yyyy): ");
	    checkout = sdf.parse(sc.nextLine());
	    res.updateDates(checkin, checkout, sc);

	    System.out.println(res);
	}
    catch(ParseException e){
        System.out.println("Invalid date Format."); // <-- faz o tratamento caso haja algum erro do tipo ParseException. O throws foi apagado lá encima, não é mais necessário depois disso.
    }
    catch(DomainException e){
        System.out.println("Error in reservation: " + e.getMessage());  // <-- e.getMessage() traz a mensagem definida na classe Reservation
    }
    catch(RuntimeException e){              // <-- faz o tratamento de qualquer outro tipo de exceção não definida pelos "catch"'s
        System.out.println("Unexpected Error! :(");
    }
	sc.close(); 
	
	}
}
