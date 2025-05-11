/**
 * Enum representing volume units and their conversion factors to the base unit
 * (litre).
 *
 * Each enum constant stores a conversion factor relative to litres. This allows
 * for consistent unit conversions using a common base.
 */
public enum Volume implements Units {

	/** Millilitre: 1 mL = 0.001 L */
	MILLILITRE(0.001),

	/** Centilitre: 1 cL = 0.01 L */
	CENTILITRE(0.01),

	/** Decilitre: 1 dL = 0.1 L */
	DECILITRE(0.1),

	/** Litre (base unit): 1 L = 1.0 L */
	LITRE(1.0),

	/** Cubic metre: 1 m³ = 1000 L */
	CUBIC_METRE(1000.0),

	/** Cubic centimetre: 1 cm³ = 0.001 L */
	CUBIC_CENTIMETRE(0.001),

	/** Cubic inch: 1 in³ ≈ 0.01639 L */
	CUBIC_INCH(0.0163871),

	/** Cubic foot: 1 ft³ ≈ 28.3168 L */
	CUBIC_FOOT(28.3168),

	/** US gallon: 1 gal (US) ≈ 3.78541 L */
	GALLON_US(3.78541),

	/** UK gallon: 1 gal (UK) ≈ 4.54609 L */
	GALLON_UK(4.54609);

	/** Conversion factor to litres (the base unit) */
	private final double toLitreFactor;

	/**
	 * Constructs a volume unit with a specified conversion factor to litres.
	 *
	 * @param d the conversion factor to the base unit (litre)
	 */
	Volume(double d) {
		this.toLitreFactor = d;
	}

	/**
	 * Returns the conversion factor to the base unit (litre).
	 *
	 * @return conversion factor as a double
	 */
	@Override
	public double getToBaseFactor() {
		return toLitreFactor;
	}
}