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
			
			frequentRenterPoints += calculateFrequentRenterPointsFor(rental);
			// show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t"
					+ String.valueOf(rental.calculateBillingAmount()) + "\n";
			totalAmount += rental.calculateBillingAmount();;
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}

	private int calculateFrequentRenterPointsFor(Rental rental) {
		int additionalFrequentRenterPoints = 0;
		// add frequent renter points
		additionalFrequentRenterPoints++;
		// add bonus for a two day new release rental
		if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
			additionalFrequentRenterPoints++;
		return additionalFrequentRenterPoints;
	}

}
