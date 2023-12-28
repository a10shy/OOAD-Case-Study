package com.ilp.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.CurrentAccount;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;

public class CreateProductService {

	public static ArrayList<Product> createProduct(ArrayList<Service> serviceList) {
		ArrayList<Product> productList = new ArrayList<Product>();
		if (serviceList.size() != 0) {
			Scanner scanner = new Scanner(System.in);
			char choice;
//			System.out.println(serviceList);
			
//			SavingsMaxAccount savingsMaxAccountTemp = new SavingsMaxAccount("P101", "Savings Max Account", serviceList,
//					1000);
//			productList.add(savingsMaxAccountTemp);
//			CurrentAccount currentAccountTemp = new CurrentAccount("P102", "Current Account", serviceList);
//			productList.add(currentAccountTemp);
//			LoanAccount loanAccountTemp = new LoanAccount("P103", "Loan Account", serviceList, 0.3);
//			productList.add(loanAccountTemp);

			do {
				ArrayList<Service> productServiceList = new ArrayList<Service>();
//
				System.out.println("Enter the Product Name");
				String productName = (scanner.nextLine());

				System.out.println("Enter the Product Code");
				String productCode = scanner.nextLine();
//
				switch (productName.toLowerCase()) {
				case "savings max account":
					for (Service service : serviceList) {
						String serviceName = service.getServiceName();
						if (serviceName.equalsIgnoreCase("Cash Deposit")
								|| serviceName.equalsIgnoreCase("ATM Withdrawl")
								|| serviceName.equalsIgnoreCase("Online Banking")) {
							productServiceList.add(service);
							System.out.println(serviceName + " Service Added");
						} else {
							System.out.println("Do you want to add " + serviceName + " Service to your Product(Y/N)");
							char serviceChoice = scanner.next().charAt(0);
							if (serviceChoice == 'y') {
								productServiceList.add(service);
								System.out.println(serviceName + " Service Added");

							}

						}

					}

					double minimumBalance = 1000;
					SavingsMaxAccount savingsMaxAccount = new SavingsMaxAccount(productCode, productName,
							productServiceList, minimumBalance);
					productList.add(savingsMaxAccount);
					System.out.println(productName + " Created Successfully");

					// create SavingsMaxAccount
					break;
				case "current account":

					for (Service service : serviceList) {
						String serviceName = service.getServiceName();
						if (serviceName.equalsIgnoreCase("Cash Deposit")
								|| serviceName.equalsIgnoreCase("ATM Withdrawl")
								|| serviceName.equalsIgnoreCase("Online Banking")
								|| serviceName.equalsIgnoreCase("Mobile Banking")) {
							productServiceList.add(service);
							System.out.println(serviceName + " Service Added");

						} else {
							System.out.println("Do you want to add " + serviceName + " Service to your Product(Y/N)");
							char serviceChoice = scanner.next().charAt(0);
							if (serviceChoice == 'y') {
								productServiceList.add(service);
								System.out.println(serviceName + " Service Added");

							}

						}

					}
					CurrentAccount currentAccount = new CurrentAccount(productCode, productName, productServiceList);
					productList.add(currentAccount);
					System.out.println(productName + " Created Successfully");

//				// create CurrentAccount
//
					break;
				case "loan account":
//					System.out.println("la");
					for (Service service : serviceList) {
						String serviceName = service.getServiceName();
						if (serviceName.equalsIgnoreCase("Cash Deposit")
								|| serviceName.equalsIgnoreCase("Cheque Deposit")) {
							productServiceList.add(service);
							System.out.println(serviceName + " Service Added");

						} else {
							System.out.println("Do you want to add " + serviceName + " Service to your Product(Y/N)");
							char serviceChoice = scanner.next().charAt(0);
							if (serviceChoice == 'y') {
								productServiceList.add(service);
								System.out.println(serviceName + " Service Added");

							}

						}
					}
					double chequeDeposit = 0.3;
					LoanAccount loanAccount = new LoanAccount(productCode, productName, productServiceList,
							chequeDeposit);
					productList.add(loanAccount);
					System.out.println(productName + " Created Successfully");

					// create LoanAccount

					break;
				default:
					System.out.println("Please Recheck the Product Name you have typed!!!\n");
					break;
				}
				System.out.print("Do you want to Create Another Product (Y/N)");
				choice = scanner.next().charAt(0);
				scanner.nextLine();
			} while (choice == 'y');
//			System.out.println(productList.size());

			return productList;
		} else {
			System.out.println("Create Services First to Create a product!!!\n");
			return productList;
		}

	}
}
