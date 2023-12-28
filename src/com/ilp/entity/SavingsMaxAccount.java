package com.ilp.entity;

import java.util.ArrayList;

public class SavingsMaxAccount extends Product {
	private double minimumBalance =1000;

	public SavingsMaxAccount(String productCode, String productName, ArrayList<Service> serviceList,
			double minimumBalance) {
		super(productCode, productName, serviceList);
		this.setMinimumBalance(minimumBalance);
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
}
