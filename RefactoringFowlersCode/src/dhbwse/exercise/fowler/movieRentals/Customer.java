package dhbwse.exercise.fowler.movieRentals;

import java.util.ArrayList;

public class Customer {
	private String name;
	private ArrayList<Rental> rentals = new ArrayList<Rental>();

	public Customer(String newname) {
		name = newname;
	};

	public void addRental(Rental arg) {
		rentals.add(arg);
	};

	public String getName() {
		return name;
	};

	public String createBill() {
		// add header
		String result = "Rental Record for " + this.getName() + "\n";
		result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

		for (Rental rental : rentals) {
			// show figures for this rental
			result += rental.printBillingLineForRental();
		}
		
		// add footer lines
		result += "Amount owed is " + String.valueOf(calculateTotalBillingAmount()) + "\n";
		result += "You earned " + String.valueOf(calculateTotalFrequentRenterPoints()) + " frequent renter points";
		return result;
	}

	private int calculateTotalFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for (Rental rental : rentals) {
			frequentRenterPoints += rental.calculateFrequentRenterPointsFor();
		}
		return frequentRenterPoints;
	}

	private double calculateTotalBillingAmount() {
		double totalAmount = 0;
		for (Rental rental : rentals) {
			totalAmount += rental.calculateBillingAmount();
		}
		return totalAmount;
	}

}
