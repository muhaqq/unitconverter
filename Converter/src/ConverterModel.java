import java.util.Map;

import unitcategories.Area;
import unitcategories.Energy;
import unitcategories.Length;
import unitcategories.Speed;
import unitcategories.Temperature;
import unitcategories.Time;
import unitcategories.UnitCategory;
import unitcategories.Units;
import unitcategories.Volume;
import unitcategories.Weight;

/**
 * The model class responsible for unit conversion logic.
 */
public class ConverterModel {

	/**
	 * A predefined mapping from unit categories (e.g., LENGTH, TIME) to the
	 * corresponding enum values that implement the Units interface.
	 */
	protected final Map<UnitCategory, Units[]> unitMap = Map.of(UnitCategory.LENGTH, Length.values(), UnitCategory.WEIGHT,
			Weight.values(), UnitCategory.TEMPERATURE, Temperature.values(), UnitCategory.TIME, Time.values(),
			UnitCategory.VOLUME, Volume.values(), UnitCategory.AREA, Area.values(), UnitCategory.SPEED, Speed.values(),
			UnitCategory.ENERGY, Energy.values());
	
	/**
	 * Converts a given value from one unit to another using a common base unit.
	 *
	 * @param value the numeric value to convert
	 * @param from  the source unit (must implement Units)
	 * @param to    the target unit (must implement Units)
	 * @return the converted value in the target unit
	 */
	protected double convertUnit(double value, Units from, Units to) {
		double base = value * from.getToBaseFactor();
		return base / to.getToBaseFactor();
	}
}