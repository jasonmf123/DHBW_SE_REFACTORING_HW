package dhbwse.exercise.fowler.movieRentals;

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