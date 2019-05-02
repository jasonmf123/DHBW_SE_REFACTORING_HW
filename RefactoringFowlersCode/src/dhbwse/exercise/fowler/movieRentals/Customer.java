package dhbwse.exercise.fowler.movieRentals;

import java.util.ArrayList;

class Customer {
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
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + this.getName() + "\n";
		result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

		for (Rental rental : rentals) {
			
			frequentRenterPoints += rental.calculateFrequentRenterPointsFor();
			// show figures for this rental
			result += rental.printBillingLineForRental();
			totalAmount += rental.calculateBillingAmount();;
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}




}
