package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
    public static void main(String args[]) throws ParseException{
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        
        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<n; i++){
            System.out.println("Product #" + (i+1) + " data: ");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();

            if(Objects.equals(ch, "u".charAt(0))){
                sc.nextLine();
                System.out.print("Manufacture Date (DD/MM/YYYY): ");
                Date manufactureDate = sdf.parse(sc.nextLine());
                list.add(new UsedProduct(name, price, manufactureDate));
            }
            else if(Objects.equals(ch, "i".charAt(0))){
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customsFee));
            }
            else{
                list.add(new Product(name, price));
            }
        }
        System.out.println("");
        System.out.println("PRICE TAGS:");
        for(Product prod : list){
            System.out.println(prod.priceTag());
        }




        sc.close();
    }
}
