public enum Length implements Units {

	MILLIMETRE(0.001), CENTIMETRE(0.01), DECIMETRE(0.1), METRE(1.0), KILOMETRE(1000), INCH(0.0254), FOOT(0.3048),
	YARD(0.9144), MILE(1609.344), NAUTICAL_MILE(1852);

	private final double toMetreFactor;

	Length(double factor) {
		this.toMetreFactor = factor;
	}

	@Override
	public double getToBaseFactor() {
		return toMetreFactor;
	}

}