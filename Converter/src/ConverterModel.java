
public class ConverterModel {

	private static final double CENTIMETER = 30.48;
	private static final double FOOT = 0.3;
	
	protected double getCentimeter() {
		return CENTIMETER;
	}

	protected double getFoot() {
		return FOOT;
	}

	protected double convertIntoCentimeter(int foot) {
		return CENTIMETER * foot;
	}

	protected double convertIntoFoot(int centimeter) {
		return FOOT * centimeter;
	}
	
}
