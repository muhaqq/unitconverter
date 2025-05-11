public enum Volume implements Units {
	MILLILITRE(0.001), CENTILITRE(0.01), DECILITRE(0.1), LITRE(1.0), CUBIC_METRE(1000.0), CUBIC_CENTIMETRE(0.001),
	CUBIC_INCH(0.0163871), CUBIC_FOOT(28.3168), GALLON_US(3.78541), GALLON_UK(4.54609);

	private final double toLitreFactor;

	Volume(double d) {
		this.toLitreFactor = d;
	}

	@Override
	public double getToBaseFactor() {
		return toLitreFactor;
	}
}