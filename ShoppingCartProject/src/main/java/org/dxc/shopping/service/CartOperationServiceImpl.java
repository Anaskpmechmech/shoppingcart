package org.dxc.shopping.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.dxc.shopping.exception.ProductException;
import org.dxc.shopping.model.Product;

public class CartOperationServiceImpl implements CartOperations{
	private float tax_percentage;
	private float invoiceAmount; 
	private ArrayList<Product> item=new ArrayList<Product>();
	public CartOperationServiceImpl(float tax_percentage) {
		this.tax_percentage=tax_percentage;
	}
	public float getInvoiceAmount() {
		return invoiceAmount;
	}
	public float addToCart(Product p) {
		item.add(p);
		System.out.println(item);
		float cost=(p.getPrice()*p.getQuantity())+(((p.getPrice()*p.getQuantity())*this.tax_percentage)/100);
		invoiceAmount=invoiceAmount+cost;
		return cost;
	}
	public void removeFromCart(Product p) {
		Iterator<Product> iter=item.iterator();
		String name=p.getName();
		boolean r=false;
		for(Product p2:item) {
			if(p2.getName().equals(p.getName())){         // loop for checking user entered product is available or not
				r=true;
				break;}}
		try {
		if(item.isEmpty())
			throw new ProductException();                 // throws exception if cart is empty
		if(r!=true) {
			throw new ProductException();}               // throws exception if cart doesn't contain user entered product name 
		}catch(ProductException e)	{                    // to remove
			System.out.println("ProductException:"+e);}
		while(iter.hasNext()) {
			Product p1=iter.next();
			if(p1.getName().equalsIgnoreCase(p.getName())){
			float cost=((p1.getPrice()*p1.getQuantity())+((p1.getPrice()*p1.getQuantity())*tax_percentage)/100);
			invoiceAmount=invoiceAmount-cost;
			iter.remove();}
			
		}System.out.println(item);
	}}
		
	
	
