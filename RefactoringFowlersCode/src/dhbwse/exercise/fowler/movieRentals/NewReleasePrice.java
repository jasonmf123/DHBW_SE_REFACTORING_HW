package dhbwse.exercise.fowler.movieRentals;

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