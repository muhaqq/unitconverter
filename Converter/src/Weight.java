public enum Weight implements Units {

	MILLIGRAM(0.000001), GRAM(0.001), KILOGRAM(1.0), TONNE(1000.0), OUNCE(0.0283495), POUND(0.453592);

	private final double toKilogramFactor;

	Weight(double factor) {
		this.toKilogramFactor = factor;
	}

	@Override
	public double getToBaseFactor() {
		return toKilogramFactor;
	}
}