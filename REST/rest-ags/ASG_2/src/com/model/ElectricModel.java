package com.model;

public class ElectricModel {
	
	private double initialReading;
	private double monthlyReading;
	public static final double COST_PER_UNIT = 2.4;
	private double totalBill;
	
	public ElectricModel(){
		
	}
	
	public ElectricModel(double initialReading, double MonthReading){
		this.initialReading = initialReading;
		this.monthlyReading = MonthReading;
	}

	public void setInitialReading(double initialReading) {
		this.initialReading = initialReading;
	}

	public void setMonthReading(double MonthReading) {
		this.monthlyReading = MonthReading;
	}
	
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	
	public double getInitialReading() {
		return this.initialReading;
	}
	
	public double getMonthlyReading() {
		return this.monthlyReading;
	}
	
	public double getTotalBill() {
		return this.totalBill;
	}
	
	@Override
	public String toString() {
		return "Total Bill : "+this.getTotalBill();
	}
}
