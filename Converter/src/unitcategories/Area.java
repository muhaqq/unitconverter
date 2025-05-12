package unitcategories;
public enum Area implements Units {
	SQUARE_MILLIMETRE(0.000001), SQUARE_CENTIMETRE(0.0001), SQUARE_METRE(1.0), SQUARE_KILOMETRE(1_000_000.0),
	HECTARE(10_000.0), ACRE(4046.8564224), SQUARE_INCH(0.00064516), SQUARE_FOOT(0.09290304), SQUARE_YARD(0.83612736),
	SQUARE_MILE(2_589_988.110336);

	private final double toSquareMetreFactor;

	Area(double factor) {
		this.toSquareMetreFactor = factor;
	}

	@Override
	public double getToBaseFactor() {
		return toSquareMetreFactor;
	}
}