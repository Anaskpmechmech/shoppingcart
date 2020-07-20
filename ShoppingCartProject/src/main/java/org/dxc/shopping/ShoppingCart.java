package org.dxc.shopping;

import java.util.Scanner;

import org.dxc.shopping.exception.ProductException;
import org.dxc.shopping.model.Product;
import org.dxc.shopping.service.CartOperationServiceImpl;
import org.dxc.shopping.service.CartOperations;

public class ShoppingCart {

	public static void main(String[] args) throws ProductException {
		Scanner s=new Scanner(System.in);
		Product p1=new Product(null, 0, 0);
		System.out.println("Enter the tax percentage");
		float tax=s.nextFloat();
		s.nextLine();
		CartOperations C=new CartOperationServiceImpl(tax);
		int i=0;
		C.removeFromCart(p1);
		while(i<5) {
		System.out.println("Enter the name of the product");
		String name=s.nextLine();
		System.out.println("Enter the product price");
		float price=s.nextFloat();
		s.nextLine();
		System.out.println("Enter the quantity of the product");
		int quantity=s.nextInt();
		s.nextLine();
		Product p=new Product(name,price,quantity);
		C.addToCart(p);
		i++;
	}
		float invoice=C.getInvoiceAmount();
		System.out.println("Total invoice amount = "+invoice);
		System.out.println("Enter the product name to be removed");
		String rname=s.nextLine();
		p1=new Product(rname,0,0);
		C.removeFromCart(p1);
		invoice=C.getInvoiceAmount();
		System.out.println("Total invoice amount = "+invoice);
}}