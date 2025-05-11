/**
 * Enum representing weight units and their conversion factors to the base unit
 * (kilogram).
 * 
 * Each enum constant stores a conversion factor relative to kilograms. This
 * allows for consistent and reusable conversion logic across the application.
 */
public enum Weight implements Units {

	/** Milligram: 1 mg = 0.000001 kg */
	MILLIGRAM(0.000001),

	/** Gram: 1 g = 0.001 kg */
	GRAM(0.001),

	/** Kilogram (base unit): 1 kg = 1.0 kg */
	KILOGRAM(1.0),

	/** Tonne: 1 t = 1000 kg */
	TONNE(1000.0),

	/** Ounce: 1 oz ≈ 0.02835 kg */
	OUNCE(0.0283495),

	/** Pound: 1 lb ≈ 0.45359 kg */
	POUND(0.453592);

	/** Conversion factor to kilograms (the base unit) */
	private final double toKilogramFactor;

	/**
	 * Constructs a weight unit with a specified conversion factor to kilograms.
	 *
	 * @param factor the conversion factor to the base unit (kilogram)
	 */
	Weight(double factor) {
		this.toKilogramFactor = factor;
	}

	/**
	 * Returns the conversion factor to the base unit (kilogram).
	 *
	 * @return conversion factor as a double
	 */
	@Override
	public double getToBaseFactor() {
		return toKilogramFactor;
	}
}