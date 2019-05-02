package dhbwse.exercise.fowler.movierentals;

abstract class Price {
	
	abstract double calculateBillingAmount(int daysRented);
	abstract int calculateFrequentRenterPoints(int daysRented);
}