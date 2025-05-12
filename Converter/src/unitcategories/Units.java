package unitcategories;
/**
 * A marker interface for unit enums that support conversion to a common base
 * unit.
 *
 * Any enum that implements this interface must provide a method to return a
 * conversion factor to its respective base unit (e.g., metre for length, litre
 * for volume, kilogram for weight).
 */
public interface Units {

	/**
	 * Returns the conversion factor from this unit to the category's base unit.
	 *
	 * @return the factor to multiply a value with in order to convert it to the
	 *         base unit
	 */
	double getToBaseFactor();
}