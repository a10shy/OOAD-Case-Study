package com.ilp.services;

import java.util.ArrayList;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Service;

public class DisplayAccountServices {

	public static void displayAccount(Customer customer) {
		if(customer!=null) {
		for(Account account:customer.getAccountList()) {
			ArrayList<Service> serviceList=new ArrayList<Service>();
		System.out.println("*************************Customer-Account Details********************************");
		System.out.println("Customer Id \t CustomerName \t AccountType \t Balance");
		System.out.println("*********************************************************************************");
				System.out.println(customer.getCustomerCode() + "\t\t" + customer.getCustomerName() + "\t\t"
						+ account.getAccountType() + "\t" + account.getBalance());
				System.out.println("\n");
				System.out.println("Services Provided");
				serviceList = account.getProduct().getServiceList();
				for (Service service : serviceList) {
					System.out.print(service.getServiceName() + " ");
				}
				System.out.println("\n\n");

		}}
		else {
			System.out.println("No Customer is generated currently");

		}
	}
	public static void displayAccount(Customer customer, String accountName) {
		ArrayList<Service> serviceList = new ArrayList<Service>();

		System.out.println("*************************Customer-Account Details********************************");
		System.out.println("Customer Id \t CustomerName \t AccountType \t Balance");
		System.out.println("*********************************************************************************");
		for (Account account : customer.getAccountList()) {
			if ((account.getAccountType()).equalsIgnoreCase(accountName)) {
				System.out.println(customer.getCustomerCode() + "\t\t" + customer.getCustomerName() + "\t\t"
						+ account.getAccountType() + "\t" + account.getBalance());
				System.out.println("Services Provided");
				serviceList = account.getProduct().getServiceList();
				for (Service service : serviceList) {
					System.out.print(service.getServiceName() + " ");
				}
			}
		}
	}
	}
	
