package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	private FoodTruck[] fleet = new FoodTruck[5];
	private Scanner sc = new Scanner(System.in);
	private FoodTruck foodTruck = new FoodTruck();

	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();

		app.run();
	}

	public void run() {

		createTruck(fleet);
		mainMenu(foodTruck.getCurrentNumberOfTrucks());
	}

	public void mainMenu(int numberOfTrucks) {

		boolean keepGoing = true;
		String choice;
		while (keepGoing) {
			printMenu();

			choice = sc.next();

			switch (choice) {

			case "1":// List trucks

				for (int i = 0; i < numberOfTrucks; i++) {
					String list = fleet[i].toString();
					System.out.println(list);
				}
				continue;

			case "2":// Average rating of all trucks
				double average = 0;
				for (int i = 0; i < numberOfTrucks; i++) {
					average = average + fleet[i].getRating();

				}
				average = average / numberOfTrucks;
				System.out.println(average);
				continue;

			case "3":// Pick best truck
				int bestTruck = 0;
				for (int i = 1; i < numberOfTrucks; i++) {
					if (fleet[i].getRating() > fleet[bestTruck].getRating()) {
						bestTruck = i;
					}
				}
				System.out.println(fleet[bestTruck].toString());
				continue;

			case "4":// Quit
				System.out.println("Thank you for using our app");
				sc.close();
				keepGoing = false;
				break;

			default:
				System.out.println("Invalid entry, please pick a number from 1-4.");
				continue;

			}

		}

	}

	public void createTruck(FoodTruck[] fleet) {

		boolean keepGoing = true;
		int i = 0;
		String truckName;
		String foodType;
		int rating = 0;
		while (keepGoing) {
			if (i == 5) {
				keepGoing = false;
				break;
			}

			System.out.println("What is the name of food truck " + (i + 1) + "?\n" + "-- enter 'quit' to stop early--");

			truckName = sc.nextLine();

			if (truckName.equalsIgnoreCase("quit")) {
				keepGoing = false;
				break;
			}

			System.out.println("What kind of food do they serve?");

			foodType = sc.nextLine();

			System.out.println("How would you rate them 1 - 5?");

			while (!sc.hasNextInt()) {
				System.out.println("please pick a number between 1-5");
				sc.nextLine();
			}

			rating = sc.nextInt();

			while (rating > 5 || rating < 1) {
				System.out.println("please pick a number between 1-5");
				rating = sc.nextInt();
			}

			sc.nextLine();

			foodTruck = new FoodTruck(truckName, foodType, rating);
			fleet[i] = foodTruck;
			i++;
			foodTruck.setCurrentNumberOfTrucks(i);
		}

	}

	public void printMenu() {
		System.out.println(" _________________________________");
		System.out.println("|---------------Menu--------------|");
		System.out.println("|                                 |");
		System.out.println("|1) List all food trucks.         |");
		System.out.println("|                                 |");
		System.out.println("|2) Average rating of food trucks.|");
		System.out.println("|                                 |");
		System.out.println("|3) Highest rated food truck.     |");
		System.out.println("|                                 |");
		System.out.println("|4) Quit.                         |");
		System.out.println("|_________________________________|");

	}

}
