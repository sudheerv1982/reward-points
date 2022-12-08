package com.charter.retail.rewardpoints;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.charter.retail.rewardpoints.service.RewardPointsService;

@SpringBootTest
class RewardPointsApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
    private RewardPointsService rewardPointsService;

    @Test
    public void getRewardPointsByCustoemrID() {
    	try {
			assertNotNull(rewardPointsService.getRewardPointsByCustoemrID(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
