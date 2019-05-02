package dhbwse.exercise.fowler.movierentals;

/**
 * Note that Java console applications need to be run through the java runtime
 * by running "java -jar JarFile.jar" in the command line. Java console
 * applications can not be previewed in the Compiler IDE, only applets can.
 */
public class Program {
	/**
	 * This is the main entry point for the application
	 */

	public static void main(String args[]) {
		System.out.println("Welcome to the Movie Store");
		System.out.println("Let's get the Statement");
		System.out.println("----------------------------------");
		System.out.println(generareSampleData().createBill());
		System.out.println("----------------------------------");
	}

	private static Customer generareSampleData() {
		Movie movie1 = new Movie("movie1", new NewReleasePrice());
		Movie movie2 = new Movie("movie2", new ChildrensPrice());
		Customer customer = new Customer("Joe");
		customer.addRental(new Rental(movie1, 10));
		customer.addRental(new Rental(movie2, 5));
		return customer;
	}
}
