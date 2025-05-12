package unitcategories;
/**
 * Enum representing various units of length and their conversion factors to the
 * base unit (metre).
 * 
 * Each enum constant holds a factor that converts it to metres. This allows
 * easy conversion between units by converting first to the base unit and then
 * to the target unit.
 */
public enum Length implements Units {

	MILLIMETRE(0.001), CENTIMETRE(0.01), DECIMETRE(0.1), METRE(1.0), KILOMETRE(1000.0), INCH(0.0254), FOOT(0.3048),
	YARD(0.9144), MILE(1609.344), NAUTICAL_MILE(1852.0);

	private final double toMetreFactor;

	/**
	 * Constructs a Length enum constant with the given conversion factor to metres.
	 *
	 * @param factor the factor to convert this unit to metres
	 */
	Length(double factor) {
		this.toMetreFactor = factor;
	}

	/**
	 * Returns the conversion factor from this unit to the base unit (metre).
	 *
	 * @return conversion factor to metres
	 */
	@Override
	public double getToBaseFactor() {
		return toMetreFactor;
	}
}