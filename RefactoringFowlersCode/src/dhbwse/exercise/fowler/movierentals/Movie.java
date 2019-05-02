package dhbwse.exercise.fowler.movierentals;

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

