/**
 * Enum representing different units of time and their conversion factors to the
 * base unit (seconds).
 *
 * Each constant defines how many seconds one unit corresponds to. For example,
 * 1 MINUTE = 60 seconds. This enum is used for converting between different
 * time units.
 */
public enum Time implements Units {
	MILLISECOND(0.001), SECOND(1.0), MINUTE(60.0), HOUR(3600.0), DAY(86400.0);

	private final double toSecondFactor;

	Time(double factor) {
		this.toSecondFactor = factor;
	}

	@Override
	public double getToBaseFactor() {
		return toSecondFactor;
	}
}