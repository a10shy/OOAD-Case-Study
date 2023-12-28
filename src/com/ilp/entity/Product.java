package com.ilp.entity;

import java.util.ArrayList;

public abstract class Product {
	private String productName;
	private String productCode;
	private ArrayList<Service> serviceList = new ArrayList<Service>();
	public Product(String productCode, String productName, ArrayList<Service> serviceList) {
		this.productCode = productCode;
		this.productName = productName;
		this.serviceList = serviceList;
	}
	public String getProductCode() {
		return productCode;
	}
	public String getProductName() {
		return productName;
	}
	public ArrayList<Service> getServiceList() {
		return serviceList;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setServiceList(ArrayList<Service> serviceList) {
		this.serviceList = serviceList;
	}
}