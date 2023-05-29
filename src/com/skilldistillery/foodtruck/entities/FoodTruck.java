package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private int currentNumberOfTrucks;
	private int id;
	private String name;
	private String foodType;
	private double rating;

	@Override
	public String toString() {
		String stars = "";
		String noStar = "";
		int i, count;
		for (i = 0, count = 0; i < rating; i++) {

			stars = stars + "★";
			count++;
		}
		if (count != 5) {
			for (int k = 5; k > count; k--) {
				noStar = noStar + "☆";
			}

		}
		return "" + name + "(Id." + (id + getCurrentNumberOfTrucks()) + ") Serves " + foodType + ". Rated " + stars
				+ noStar;
	}

	public FoodTruck(String name, String type, double rating) {
		this.name = name;
		this.foodType = type;
		this.rating = rating;
		id = 100 + getCurrentNumberOfTrucks();
		currentNumberOfTrucks++;
	}

	public FoodTruck() {
		id = 100 + getCurrentNumberOfTrucks();
		currentNumberOfTrucks++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getCurrentNumberOfTrucks() {
		return currentNumberOfTrucks;
	}

	public void setCurrentNumberOfTrucks(int currentNumberOfTrucks) {
		this.currentNumberOfTrucks = currentNumberOfTrucks;
	}

}
