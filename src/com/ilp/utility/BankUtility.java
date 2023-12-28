package com.ilp.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Service;
import com.ilp.services.CreateServiceService;
import com.ilp.services.CreateCustomerService;
import com.ilp.services.CreateProductService;
import com.ilp.services.DisplayAccountServices;
import com.ilp.services.ManageAccountServices;

public class BankUtility {

	public static void main(String[] args) {
		char choice;
		ArrayList<Service> serviceList = new ArrayList<Service>();
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Account> accountList = new ArrayList<Account>();

		Customer customer = null;
		do {
		System.out.println("******Welcome To Bank************ ");
		System.out.println(
				"1.Create Service\n2.Create Product\n3.Create Customer\n4.Manage Accounts\n5.Display Customer\n6.Exit");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your choice: ");
		int menuChoice = scanner.nextInt();
		scanner.nextLine();
		
			switch (menuChoice) {
			case 1:
				// Create Service
				serviceList.addAll(CreateServiceService.createServices());
				break;
			case 2:
				// Create product

				productList.addAll(CreateProductService.createProduct(serviceList));
				break;
			case 3:
				// Create Customer

				if(customer==null) {
					Account account = CreateCustomerService.createAccount(productList);
					accountList.add(account);
					customer = CreateCustomerService.createCustomer(account);

				}
				else {
					accountList.add(CreateCustomerService.createAccount(productList));
					customer.setAccountList(accountList);
					System.out.println(customer);
				}
				break;
			case 4:
				// Manage Account

					customer = ManageAccountServices.manageAccount(customer);
					break;
			case 5:
				// Display Account

					DisplayAccountServices.displayAccount(customer);
					break;
			case 6:
				System.out.println("Successfully Exiting from the Program");
				return ;


			default:
				break;
			}
			System.out.println("Do you want to Select Another Option from Menu(Y/N):");
			choice = scanner.next().charAt(0);
			
		} while(choice=='y');
	}

}
