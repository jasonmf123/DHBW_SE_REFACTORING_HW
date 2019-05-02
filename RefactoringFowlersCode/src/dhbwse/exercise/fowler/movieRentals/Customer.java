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
			double thisAmount = 0;
			// determine amounts for each line
			thisAmount = calculateAmountFor(rental);
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
				frequentRenterPoints++;
			// show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t"
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}

	private double calculateAmountFor(Rental rental) {
		double calculatedAmount = 0;
		switch (rental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			calculatedAmount += 2;
			if (rental.getDaysRented() > 2)
				calculatedAmount += (rental.getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			calculatedAmount += rental.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			calculatedAmount += 1.5;
			if (rental.getDaysRented() > 3)
				calculatedAmount += (rental.getDaysRented() - 3) * 1.5;
			break;
		}
		return calculatedAmount;
	}

}
