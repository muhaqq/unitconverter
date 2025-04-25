import java.awt.event.ActionEvent;

public class ConverterController {

	ConverterModel model;
	ConverterView view;

	public ConverterController(ConverterModel model, ConverterView view) {
		this.model = model;
		this.view = view;
	}

	private void addListeners() {

		view.getConvertButton().addActionListener(this::convert);

	}

	private void converct(ActionEvent e) {

		Double inputText = Double.parseDouble(view.getInputTextField().getText());

		if (view.getInputUnit().equals("inch")) {
			
			Double output;
			output = inputText * model.getCentimeter();
			view.outputTextField.setText(String.valueOf(output));

		} else if (view.getInputTextField().equals("centimeter")) {

			Double output;
			output = inputText * model.getFoot();
			view.outputTextField.setText(String.valueOf(output));

		}

	}

}
