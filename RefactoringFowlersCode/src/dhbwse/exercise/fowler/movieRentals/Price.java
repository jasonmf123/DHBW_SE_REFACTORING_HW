package dhbwse.exercise.fowler.movieRentals;

abstract class Price {
	
	abstract double calculateBillingAmount(int daysRented);
	abstract int calculateFrequentRenterPoints(int daysRented);
}