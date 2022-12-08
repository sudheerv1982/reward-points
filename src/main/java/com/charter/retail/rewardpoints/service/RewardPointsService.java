package com.charter.retail.rewardpoints.service;

import com.charter.retail.rewardpoints.exception.RPException;
import com.charter.retail.rewardpoints.model.CustomerRewardPoints;

public interface RewardPointsService {
	
	public CustomerRewardPoints getRewardPointsByCustoemrID(Integer customerId) throws RPException;

}
