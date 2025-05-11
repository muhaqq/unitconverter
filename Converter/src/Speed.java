public enum Speed implements Units {
	METRES_PER_SECOND(1.0), KILOMETRES_PER_HOUR(0.27777778), MILES_PER_HOUR(0.44704), FEET_PER_SECOND(0.3048),
	KNOT(0.514444);

	private final double toMetresPerSecond;

	Speed(double factor) {
		this.toMetresPerSecond = factor;
	}

	@Override
	public double getToBaseFactor() {
		return toMetresPerSecond;
	}
}