package dhbwse.exercise.fowler.movieRentals;

public class Movie {
	private String title;
	private Price priceCode;

	public Movie(String newtitle, Price newpriceCode) {
		title = newtitle;
		priceCode = newpriceCode;
	}

	public Price getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(Price newPriceCode) {
		priceCode = newPriceCode;
	}

	public String getTitle() {
		return title;
	};
	
}

abstract class Price {
	
	abstract double calculateBillingAmount(int daysRented);
	abstract int calculateFrequentRenterPoints(int daysRented);
}

class NewReleasePrice extends Price {

	@Override
	double calculateBillingAmount(int daysRented) {
		return daysRented * 3;
	}

	@Override
	int calculateFrequentRenterPoints(int daysRented) {
		return daysRented>1 ?  2 :  1;
	}
	
}

class RegularPrice extends Price {

	@Override
	double calculateBillingAmount(int daysRented) {
		double calculatedAmount = 0;
		calculatedAmount += 2;
		if (daysRented > 2)
			{calculatedAmount += (daysRented - 2) * 1.5;}
		return calculatedAmount;
	}

	@Override
	int calculateFrequentRenterPoints(int daysRented) {
		return 1;
	}	
}

class ChildrensPrice extends Price {
	@Override
	double calculateBillingAmount(int daysRented) {
		double calculatedAmount = 0;
		calculatedAmount += 1.5;
		if (daysRented > 3) {
			calculatedAmount += (daysRented - 3) * 1.5;}
		return calculatedAmount;
	}

	@Override
	int calculateFrequentRenterPoints(int daysRented) {
		return 1;
	}	
}

