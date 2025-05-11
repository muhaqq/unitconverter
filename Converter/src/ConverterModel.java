/**
 * The model class responsible for unit conversion logic.
 */
public class ConverterModel {

	/**
	 * Converts a given value from one unit to another using a common base unit.
	 *
	 * @param value the numeric value to convert
	 * @param from  the source unit (must implement Units)
	 * @param to    the target unit (must implement Units)
	 * @return the converted value in the target unit
	 */
	protected double convertUnit(double value, Units from, Units to) {
		double base = value * from.getToBaseFactor(); // convert to base unit
		return base / to.getToBaseFactor(); // convert to target unit
	}
}