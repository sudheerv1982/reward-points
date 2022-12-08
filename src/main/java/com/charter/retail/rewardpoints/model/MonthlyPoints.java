package com.charter.retail.rewardpoints.model;

public class MonthlyPoints {
	Integer month;
	Integer points;

	public MonthlyPoints(Integer month, Integer points) {
		this.month = month;
		this.points = points;
	}

	public MonthlyPoints() {
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "MonthlyPoints [month=" + month + ", points=" + points + "]";
	}

}
