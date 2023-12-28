package com.ilp.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;

public class ManageAccountServices {

	public static Customer manageAccount(Customer customer) {
		if(customer!=null) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Service> serviceList = new ArrayList<Service>();
		System.out.println("Enter the Customer id:");
		String customerId = scanner.nextLine();
		if (customerId.compareTo(customer.getCustomerCode()) != 0) {
			System.out.println("This Customer doesn't Exist");
			return customer;
		} else {
			System.out.println(customer.getCustomerName() + " has the following accounts");
			for (Account account : customer.getAccountList()) {
				System.out.println(account.getAccountType());
			}

			System.out.println("Enter the Account to Proceed with:");
			String accountName = scanner.nextLine();
			System.out.println("1.Deposit \t2.Withdraw \t3.Display Balance ");
			System.out.println("Enter your choice:");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the amount to be deposited:");
				double amount = scanner.nextDouble();
				for (Account account : customer.getAccountList()) {
					if ((account.getAccountType()).equalsIgnoreCase(accountName)) {
						if ((account.getAccountType()).equalsIgnoreCase("loan account")) {
							LoanAccount loanAccount = (LoanAccount) account.getProduct();
							System.out.println("Select Deposit Type:");
							System.out.println("1. Cash Deposit 2. Cheque Deposit");
							int choiceLoanAccount = scanner.nextInt();
							scanner.nextLine();
							switch (choiceLoanAccount) {
							case 1:
								account.setBalance(account.getBalance() + amount);
								System.out.println("Cash Deposited Succesfully");
								break;
							case 2:
								account.setBalance(
										account.getBalance() + (amount - amount * loanAccount.getChequeDeposit()));
								System.out.println("Cheque Deposited Succesfully");
								break;
							default:
								System.out.println("Invalid Deposit Option");
								break;
							}
//							System.out.println(account);

						} else {
							account.setBalance(account.getBalance() + amount);
							System.out.println("Deposited Succesfully");
//							System.out.println(account);

						}
					}
				}
				// deposit
				break;
			case 2:
				System.out.println("Enter the amount to be Withdrawed:");
				amount = scanner.nextDouble();
				for (Account account : customer.getAccountList()) {
					if ((account.getAccountType()).equalsIgnoreCase(accountName)) {
						if (account.getBalance() > amount) {
							if ((account.getAccountType()).equalsIgnoreCase("savings max account")) {
								SavingsMaxAccount savingsMaxAccount = (SavingsMaxAccount) account.getProduct();
								double minimumBalance = savingsMaxAccount.getMinimumBalance();
								if ((account.getBalance() - amount) < minimumBalance) {
									System.out.println("Please maintain Minimum Account Balance");
									break;
								} else {
									account.setBalance(account.getBalance() - amount);
									System.out.println("Amount Withdrawn Successfully");
//									System.out.println(account);
									break;
								}
							} else {
								account.setBalance(account.getBalance() - amount);
								System.out.println("Amount Withdrawn Successfully");
								break;
							}
						} else {
							System.out.println("Insufficient Balance");
							break;
						}
					}

				}
				// withdraw
				break;
			case 3:
				DisplayAccountServices.displayAccount(customer, accountName);
				// display
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}

			return customer;
		}
	}else {
		System.out.println("No Valid Customer");
		return null;
	}
}}
