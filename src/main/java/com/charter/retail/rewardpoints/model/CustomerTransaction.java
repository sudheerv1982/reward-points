package com.charter.retail.rewardpoints.model;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerTransaction {
	Integer customerId;
	String customerName;
	Date transactionDate;
	BigDecimal transactionAmount;

	public CustomerTransaction() {

	}

	public CustomerTransaction(Integer customerId, String customerName, Date transactionDate,
			BigDecimal transactionAmount) {

		this.customerId = customerId;
		this.customerName = customerName;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
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

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Override
	public String toString() {
		return "CustomerTransaction [customerId=" + customerId + ", customerName=" + customerName + ", transactionDate="
				+ transactionDate + ", transactionAmount=" + transactionAmount + "]";
	}

}
