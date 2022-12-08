package com.charter.retail.rewardpoints.model;

import java.util.Map;

public class CustomerRewardPoints {
	Integer customerId;
	String customerName;
	Map<Integer,Integer> monthlyPoints;
	Integer totalPoints;

	public CustomerRewardPoints() {
	}

	public CustomerRewardPoints(Integer customerId, String customerName, Map<Integer,Integer> monthlyPoints,
			Integer totalPoints) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.monthlyPoints = monthlyPoints;
		this.totalPoints = totalPoints;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Map<Integer,Integer> getMonthlyPoints() {
		return monthlyPoints;
	}

	public void setMonthlyPoints(Map<Integer,Integer> monthlyPoints) {
		this.monthlyPoints = monthlyPoints;
	}

	public Integer getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(Integer totalPoints) {
		this.totalPoints = totalPoints;
	}

	@Override
	public String toString() {
		return "CustomerRewardPoints [customerId=" + customerId + ", customerName=" + customerName + ", monthlyPoints="
				+ monthlyPoints + ", totalPoints=" + totalPoints + "]";
	}

}
