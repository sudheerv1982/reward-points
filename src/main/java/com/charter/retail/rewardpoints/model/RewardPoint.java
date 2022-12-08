package com.charter.retail.rewardpoints.model;

public class RewardPoint {
	Integer amount;
	Integer points;

	public RewardPoint() {
	}

	public RewardPoint(Integer amount, Integer points) {
		this.amount = amount;
		this.points = points;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "RewardPoints [amount=" + amount + ", points=" + points + "]";
	}

}
