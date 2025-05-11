/**
 * Enum representing different units of speed and their conversion factors to
 * the base unit (metres per second).
 *
 * Each constant defines how many metres per second correspond to one unit of
 * the respective speed. For example, 1 KILOMETRES_PER_HOUR = 0.27777778 m/s.
 * This enum enables consistent unit conversions by standardizing all values to
 * metres per second internally.
 */
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