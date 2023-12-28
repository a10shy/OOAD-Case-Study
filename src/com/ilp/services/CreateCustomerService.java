package com.ilp.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;

public class CreateCustomerService {
	Customer customer = null;

	public static Customer createCustomer(Account account) {
		if (account != null) {
			ArrayList<Account> accountList = new ArrayList<Account>();
			accountList.add(account);
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Customer Code:");
			String customerCode = scanner.nextLine();
			System.out.println("Enter Customer Name:");
			String customerName = scanner.nextLine();
			Customer customer = new Customer(customerCode, customerName, accountList);
//			System.out.println(customer);
			return customer;
		} else {
			return null;
		}
	}

	public static Account createAccount(ArrayList<Product> productList) {
		if (productList.size() != 0) {
			int counter = 1;
			System.out.println("****Accounts Available***********");
			for (Product product : productList) {
				System.out.println(counter + ". " + product.getProductName());
				counter++;
			}
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter your choice:");
			int accountChoice = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter Account No:");
			String accountNo = scanner.nextLine();
			System.out.println("Enter Account Balance:");
			double balance = scanner.nextDouble();
			if (productList.get(accountChoice - 1) instanceof SavingsMaxAccount) {
				SavingsMaxAccount savingsMaxAccount = (SavingsMaxAccount) productList.get(accountChoice - 1);
				while (balance < (savingsMaxAccount.getMinimumBalance())) {
					System.out.println("Enter Balance Greater than 1000:");
					balance = scanner.nextDouble();
				}
			}
			Account account = new Account(accountNo, productList.get(accountChoice - 1).getProductName(), balance,
					productList.get(accountChoice - 1));
//			System.out.println(account);
			return account;
		} else {
			System.out.println("No Products Available to Create a Customer");
			return null;
		}

	}

}
