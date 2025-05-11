
public class ConverterModel {

	protected double convertUnit(double value, Units from, Units to) {
		double base = value * from.getToBaseFactor();
		return base / to.getToBaseFactor();
	}

}
