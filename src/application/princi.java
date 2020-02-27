package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class princi {
	private static Product p;

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the numberof products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Common, used or imported (c/u/i)? ");
			char cui = sc.next().charAt(0);
			System.out.println("Product #" + i + " date: ");
			if(cui == 'c') {
				System.out.println("Name: ");
				String name = sc.next();
				System.out.println("Price: ");
				Double price = sc.nextDouble();
				
				
				list.add(new Product(name, price));
				
			} else if(cui == 'i'){
				System.out.println("Name: ");
				String name = sc.next();
				System.out.println("Price: ");
				Double price = sc.nextDouble();
				System.out.println("Customs fee: ");
				Double customsFee = sc.nextDouble();
				
				
				list.add( new ImportedProduct(name, price, customsFee));
				
				
			}else {
				System.out.println("Name: ");
				String name = sc.next();
				System.out.println("Price: ");
				Double price = sc.nextDouble();
				System.out.println("manufature date");
				Date manufatureDate = sdf.parse(sc.next());
				
				
				list.add( new UsedProduct(name, price, manufatureDate));
		
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS:");

		for (Product p : list) {
			System.out.println(p.priceTag());
		}
		
		sc.close();
	}
}
