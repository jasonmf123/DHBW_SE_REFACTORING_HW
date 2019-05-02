package dhbwse.exercise.fowler.movieRentals;

class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie newmovie, int newdaysRented) {
		movie = newmovie;
		daysRented = newdaysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}
	
	public double calculateBillingAmount() {
		double calculatedAmount = 0;
		switch (this.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			calculatedAmount += 2;
			if (this.getDaysRented() > 2)
				calculatedAmount += (this.getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			calculatedAmount += this.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			calculatedAmount += 1.5;
			if (this.getDaysRented() > 3)
				calculatedAmount += (this.getDaysRented() - 3) * 1.5;
			break;
		}
		return calculatedAmount;
	}
	
	public String printBillingLineForRental() {
		return "\t" + this.getMovie().getTitle() + "\t" + "\t" + this.getDaysRented() + "\t"
				+ String.valueOf(this.calculateBillingAmount()) + "\n";
	}
	
	public int calculateFrequentRenterPointsFor() {
		int additionalFrequentRenterPoints = 0;
		// add frequent renter points
		additionalFrequentRenterPoints++;
		// add bonus for a two day new release rental
		if ((this.getMovie().getPriceCode() == Movie.NEW_RELEASE) && this.getDaysRented() > 1)
			additionalFrequentRenterPoints++;
		return additionalFrequentRenterPoints;
	}
	
	
}