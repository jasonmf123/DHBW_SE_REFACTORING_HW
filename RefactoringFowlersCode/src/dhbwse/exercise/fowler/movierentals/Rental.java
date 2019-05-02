package dhbwse.exercise.fowler.movierentals;

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
		return this.getMovie().getPriceCode().calculateBillingAmount(this.getDaysRented());
	}
	
	public String printBillingLineForRental() {
		return "\t" + this.getMovie().getTitle() + "\t" + "\t" + this.getDaysRented() + "\t"
				+ String.valueOf(this.calculateBillingAmount()) + "\n";
	}
	
	public int calculateGainedFrequentRenterPoints() {
		return this.getMovie().getPriceCode().calculateFrequentRenterPoints(this.getDaysRented());
	}
	
	
}