package dhbwse.exercise.fowler.movierentals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import dhbwse.exercise.fowler.movierentals.ChildrensPrice;
import dhbwse.exercise.fowler.movierentals.Customer;
import dhbwse.exercise.fowler.movierentals.Movie;
import dhbwse.exercise.fowler.movierentals.NewReleasePrice;
import dhbwse.exercise.fowler.movierentals.RegularPrice;
import dhbwse.exercise.fowler.movierentals.Rental;

class CustomerTest {

	Customer customer;
	List<Rental> rentals;

	static List<Rental> createTestRentals() {
		List<Rental> rentals = new ArrayList<Rental>(3);
		rentals.add(new Rental(new Movie("The Tester", new RegularPrice()), 5));
		rentals.add(new Rental(new Movie("The Tester 2", new NewReleasePrice()), 5));
		rentals.add(new Rental(new Movie("The Tester 4 Kids", new ChildrensPrice()), 10));
		return rentals;
	}

	@BeforeEach
	void setUp() throws Exception {
		this.rentals = createTestRentals();
		customer = new Customer("Test Customer");
		rentals.forEach(rental -> customer.addRental(rental));
	}

	@Test
	void testCreateBillExpectSuccess() {
		String expectedBill = StringUtils.replaceWhitespaceCharacters(
				"Rental Record for Test Customer\r\n" + "\tTitle\t\tDays\tAmount\r\n" + "\tThe Tester\t\t5\t6.5\r\n"
						+ "\tThe Tester 2\t\t5\t15.0\r\n" + "\tThe Tester 4 Kids\t\t10\t12.0\r\n"
						+ "Amount owed is 33.5\r\n" + "You earned 4 frequent renter points",
				"");
		String actualBill = StringUtils.replaceWhitespaceCharacters(customer.createBill(), "");
		Assertions.assertEquals(expectedBill, actualBill);
	}

}
