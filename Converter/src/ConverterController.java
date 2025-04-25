import java.awt.event.ActionEvent;

public class ConverterController {

	ConverterModel model;
	ConverterView view;

	public ConverterController(ConverterModel model, ConverterView view) {
		this.model = model;
		this.view = view;
		this.addListeners();
	}

	private void addListeners() {
		view.getConvertButton().addActionListener(this::convert);
	}

	private void convert(ActionEvent e) {

		int input = view.getSourceValue();
		int result = 0;

		if (view.getInputUnit() == Units.CENTIMETRE && view.getOutputUnit() == Units.METRE) {

			result = model.convertCentimetreToMetre(input);

		} else if (view.getInputUnit() == Units.METRE && view.getOutputUnit() == Units.CENTIMETRE) {

			result = model.convertMetreToCentimetre(input);

		} else if (view.getInputUnit() == view.getOutputUnit()) {
			System.out.println("Fehler");
		}

		view.updateOutputView(result);

	}

}
