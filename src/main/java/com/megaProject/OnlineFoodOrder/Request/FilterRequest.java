package com.megaProject.OnlineFoodOrder.Request;

public class FilterRequest {
	
	private int time;
	private double minCost;
	private double avgCost;
	
	

	public FilterRequest(int time, double minCost, double avgCost) {
		super();
		this.time = time;
		this.minCost = minCost;
		this.avgCost = avgCost;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public double getMinCost() {
		return minCost;
	}

	public void setMinCost(double minCost) {
		this.minCost = minCost;
	}

	public double getAvgCost() {
		return avgCost;
	}

	public void setAvgCost(double avgCost) {
		this.avgCost = avgCost;
	}
	
}
