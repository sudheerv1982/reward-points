package com.charter.retail.rewardpoints.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charter.retail.rewardpoints.exception.RPException;
import com.charter.retail.rewardpoints.model.CustomerRewardPoints;
import com.charter.retail.rewardpoints.service.RewardPointsService;

@RestController
@RequestMapping("/rewardpoints")
public class RewardPointsController {
	public static final Logger logger = LoggerFactory.getLogger(RewardPointsController.class);
	
	@Autowired
	private RewardPointsService rewardPointsService;

	@GetMapping(value = "/customerId/{customerId}")
	public ResponseEntity<CustomerRewardPoints> getRewardPointsByCustoemrID(@PathVariable("customerId") Integer customerId) throws RPException {
		CustomerRewardPoints customerRewardPoints = rewardPointsService.getRewardPointsByCustoemrID(customerId);
		ResponseEntity<CustomerRewardPoints> entity = new ResponseEntity<>(customerRewardPoints, HttpStatus.OK);
		logger.debug("Final entity of CustomerRewardPoints: " + entity);
		return entity;
		
	}

}
