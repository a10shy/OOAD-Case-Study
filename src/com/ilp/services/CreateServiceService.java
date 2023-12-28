package com.ilp.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Service;

public class CreateServiceService {
	public static ArrayList<Service> createServices() {
		ArrayList<Service> serviceList = new ArrayList<Service>();
//		Service service1 = new Service("S101", "CashDeposit", 0);
//		serviceList.add(service1);
//		Service service2 = new Service("S102", "ATMWithdrawl", 0);
//		serviceList.add(service2);
//		Service service3 = new Service("S103", "OnlineBanking", 0);
//		serviceList.add(service3);
//		Service service4 = new Service("S104", "MobileBanking", 0);
//		serviceList.add(service4);
//		Service service5 = new Service("S105", "ChequeDeposit", 0.3);
//		serviceList.add(service5);
		char choice;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter the Service Code: (Eg:S106)");
			String serviceCode = scanner.nextLine();
			System.out.println("Enter the Service Name: ");
			String serviceName = scanner.nextLine();
			System.out.println("Enter the Rate: ");
			double rate = scanner.nextDouble();
			Service service = new Service(serviceCode, serviceName, rate);
			serviceList.add(service);
			System.out.print("Do you want to Create Another Service (Y/N)");
			choice = scanner.next().charAt(0);
			scanner.nextLine();
		} while (choice == 'y');
//		System.out.println(serviceList);
		return serviceList;
	}
}
