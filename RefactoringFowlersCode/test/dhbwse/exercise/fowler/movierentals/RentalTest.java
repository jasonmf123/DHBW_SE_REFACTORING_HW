package dhbwse.exercise.fowler.movierentals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentalTest {

	private Rental rental;
	private String testTitle = "The Testinator";
	private int rentDuration = 5;

	@BeforeEach
	void setUp() throws Exception {
		rental = new Rental(new Movie(testTitle, new NewReleasePrice()), rentDuration);
	}

	@Test
	void testCalculateBillingAmountExpectSuccess() {
		double expected = 15;
		double actual = rental.calculateBillingAmount();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testCalculateGainedFrequentRenterPointsExpectSuccess() {
		int expected = 2;
		int actual = rental.calculateGainedFrequentRenterPoints();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testPrintBillingLineForRentalExpectSuccess() {
		String expected = "\t" + testTitle + "\t" + "\t" + rentDuration + "\t" + String.valueOf(15.0) + "\n";
		String actual = rental.printBillingLineForRental();
		Assertions.assertEquals(expected, actual);

	}

}
