public enum Energy implements Units {
	JOULE(1.0), KILOJOULE(1000.0), CALORIE(4.184), KILOCALORIE(4184.0), WATT_HOUR(3600.0), KILOWATT_HOUR(3_600_000.0),
	ELECTRONVOLT(1.60218e-19), BTU(1055.06);

	private final double toJouleFactor;

	Energy(double factor) {
		this.toJouleFactor = factor;
	}

	@Override
	public double getToBaseFactor() {
		return toJouleFactor;
	}
}