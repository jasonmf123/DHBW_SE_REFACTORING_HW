package dhbwse.exercise.fowler.movierentals;

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