package com.charter.retail.rewardpoints.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.charter.retail.rewardpoints.model.CustomerRewardPoints;
import com.charter.retail.rewardpoints.model.CustomerTransaction;
import com.charter.retail.rewardpoints.model.RewardPoint;

@Component
@Service("rewardPointsService")
public class RewardPointsServiceImpl implements RewardPointsService{
	public static final Logger logger = LoggerFactory.getLogger(RewardPointsService.class);
	
	public CustomerRewardPoints getRewardPointsByCustoemrID(Integer customerId){
		CustomerRewardPoints customerRewardPoints = new CustomerRewardPoints();
		List<CustomerTransaction> customerTransactionsList = getCustomerTransactions(customerId);
		logger.debug("Customer transactions for CustomerID :: " +  customerId + " :: " + customerTransactionsList);
		if(customerTransactionsList!=null && customerTransactionsList.size()>0) {
			customerRewardPoints.setCustomerId(customerTransactionsList.get(0).getCustomerId());
			customerRewardPoints.setCustomerName(customerTransactionsList.get(0).getCustomerName());
			customerRewardPoints.setTotalPoints(0);
			customerRewardPoints.setMonthlyPoints(new HashMap<Integer, Integer>());
		}
		calculatePoints(customerRewardPoints, customerTransactionsList);
		logger.debug("Final Customer Reward Points object :: " + customerRewardPoints);
		return customerRewardPoints;
	}
	
	private void calculatePoints(CustomerRewardPoints customerRewardPoints,
			List<CustomerTransaction> customerTransactionsList) {
		List<RewardPoint> rewardPoints = getRewardPoints();
		for (CustomerTransaction customerTransaction : customerTransactionsList) {
			for (RewardPoint rewardPoint : rewardPoints) {
				Integer amount = rewardPoint.getAmount();
				BigDecimal transactionAmount = customerTransaction.getTransactionAmount();
				if (transactionAmount.compareTo(new BigDecimal(amount)) > 0) {
					int points = (transactionAmount.subtract(new BigDecimal(amount))).intValue();
					int month = customerTransaction.getTransactionDate().getMonth();
					if(customerRewardPoints.getMonthlyPoints().get(month) == null){
						customerRewardPoints.getMonthlyPoints().put(month, points);
					} else {
						customerRewardPoints.getMonthlyPoints().put(month, customerRewardPoints.getMonthlyPoints().get(month) + points);
					}
					customerRewardPoints.setTotalPoints(customerRewardPoints.getTotalPoints() + points);
				}
			}
		}
	}

	private List<RewardPoint> getRewardPoints() {
		// Ideal case is to configure these in a DB and pull them dynamically.
		// That way we can configure points on the fly with out deploying the
		// application.

		List<RewardPoint> rewardPointList = new ArrayList<RewardPoint>();
		rewardPointList.add(new RewardPoint(50, 1));
		rewardPointList.add(new RewardPoint(100, 1));
		logger.debug("Configured reward points in the system :: " + rewardPointList);
		return rewardPointList;

	}
	
	private List<CustomerTransaction> getCustomerTransactions(Integer customerId){
		// Ideal case is to configure these in a DB and pull them dynamically.
		// For this demo we are storing this static data set
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");      
		List<CustomerTransaction> customerTransactionsList = new ArrayList<CustomerTransaction>();
		try {
			customerTransactionsList.add(new CustomerTransaction(new Integer(1), "Joe", formatter.parse("10-10-2022"), new BigDecimal(123)));
			customerTransactionsList.add(new CustomerTransaction(new Integer(1), "Joe", formatter.parse("10-26-2022"), new BigDecimal(52)));
			customerTransactionsList.add(new CustomerTransaction(new Integer(1), "Joe", formatter.parse("11-10-2022"), new BigDecimal(35)));
			customerTransactionsList.add(new CustomerTransaction(new Integer(1), "Joe", formatter.parse("11-14-2022"), new BigDecimal(234)));
			customerTransactionsList.add(new CustomerTransaction(new Integer(1), "Joe", formatter.parse("12-04-2022"), new BigDecimal(74)));
			customerTransactionsList.add(new CustomerTransaction(new Integer(2), "Smith", formatter.parse("10-10-2022"), new BigDecimal(74)));
			customerTransactionsList.add(new CustomerTransaction(new Integer(2), "Smith", formatter.parse("11-11-2022"), new BigDecimal(234)));
			customerTransactionsList.add(new CustomerTransaction(new Integer(2), "Smith", formatter.parse("12-01-2022"), new BigDecimal(78)));
			customerTransactionsList.add(new CustomerTransaction(new Integer(2), "Smith", formatter.parse("12-03-2022"), new BigDecimal(123)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return customerTransactionsList.stream().filter(t -> t.getCustomerId().intValue() == customerId.intValue())
				.collect(Collectors.toList());

	}

}
