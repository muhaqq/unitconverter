/**
 * Represents the broad categories of measurable units used in the converter.
 *
 * Each category corresponds to a set of specific units (e.g., LENGTH includes
 * metre, kilometre, etc.). This enum is used to determine which group of units
 * should be displayed and converted.
 */
public enum UnitCategory {
	LENGTH, WEIGHT, TEMPERATURE, TIME, VOLUME, AREA, SPEED, ENERGY
}