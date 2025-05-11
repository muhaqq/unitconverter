/**
 * Enum representing various units of energy and their conversion factors to the
 * base unit (joule).
 *
 * Each enum constant defines how many joules one unit equals. This enables
 * consistent conversion by converting first to joules, then from joules to the
 * desired unit.
 */
public enum Energy implements Units {

	JOULE(1.0), KILOJOULE(1000.0), CALORIE(4.184), KILOCALORIE(4184.0), WATT_HOUR(3600.0), KILOWATT_HOUR(3_600_000.0),
	ELECTRONVOLT(1.60218e-19), BTU(1055.06);

	private final double toJouleFactor;

	/**
	 * Constructs an Energy unit with the specified conversion factor to joules.
	 *
	 * @param factor conversion factor from this unit to joules
	 */
	Energy(double factor) {
		this.toJouleFactor = factor;
	}

	/**
	 * Returns the conversion factor from this energy unit to the base unit (joule).
	 *
	 * @return conversion factor to joules
	 */
	@Override
	public double getToBaseFactor() {
		return toJouleFactor;
	}
}