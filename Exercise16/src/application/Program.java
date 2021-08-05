package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	public static void main(String []args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("-Enter Client Data-");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth Date: ");
		Date birthDate = sdf1.parse(sc.nextLine());
		Client client = new Client (name, email, birthDate);
		
		System.out.println("");
		System.out.println("-Enter Order Data-");
		System.out.print("Status: ");
		String status = sc.nextLine();
		Date moment = new Date();
		Order order = new Order(client, OrderStatus.valueOf(status), moment);

		System.out.print("How many items to this order? ");
		Integer itemQuantity = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<itemQuantity; i++){
			System.out.println("Enter #" + (i+1) + " Item Data: ");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product Price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer productQuantity = sc.nextInt();
			sc.nextLine();

			OrderItem orderItem = new OrderItem(productQuantity, productPrice, new Product(productName,productPrice));
			order.addItem(orderItem);
		}
		System.out.println("");
		System.out.println("ORDER SUMMARY:");
		System.out.println("Order Moment: " + sdf2.format(order.getMoment()));
		System.out.println("Order Status: " + order.getStatus());
		System.out.println(client);
		System.out.println("Order Items: ");
		System.out.println(order);
		System.out.println("Total price = $" + order.total());
		
		
		sc.close();
	}
}

