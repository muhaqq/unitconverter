import java.awt.event.ActionEvent;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

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
 * Controller class that connects the ConverterModel and ConverterView.
 * 
 * It handles user interactions such as selecting a unit category and updates
 * the view accordingly. The controller maps each UnitCategory to its
 * corresponding Units enum and updates the unit selection boxes dynamically.
 */
public class ConverterController {

	private final ConverterModel model;
	private final ConverterView view;

	/**
	 * Constructs the controller, assigns the model and view, and registers UI event
	 * listeners.
	 *
	 * @param model the underlying conversion logic model
	 * @param view  the UI component for user interaction
	 */
	public ConverterController(ConverterModel model, ConverterView view) {
		this.model = model;
		this.view = view;
		addListeners();
	}

	/**
	 * Registers all required listeners to UI components.
	 */
	private void addListeners() {
		view.getCategoryBox().addActionListener(this::selectUnit);
		view.getConvertButton().addActionListener(this::convert);
	}

	/**
	 * Updates the input and output unit combo boxes based on the selected unit
	 * category.
	 * 
	 * This method is triggered when the user selects a different category (e.g.,
	 * LENGTH, WEIGHT) from the category combo box. It uses a predefined mapping of
	 * categories to available units (stored in a Map<UnitCategory, Units[]>) to
	 * update the unit selection options accordingly.
	 *
	 * @param e the ActionEvent triggered by selecting a new item in the category
	 *          combo box
	 */
	private void selectUnit(ActionEvent e) {
		UnitCategory selectedCategory = (UnitCategory) view.getCategoryBox().getSelectedItem();
		Units[] units = model.unitMap.get(selectedCategory);

		if (units != null) {
			view.getInputBoxUnit().setModel(new DefaultComboBoxModel<>(units));
			view.getOutputBoxUnit().setModel(new DefaultComboBoxModel<>(units));
		}
	}

	/**
	 * Handles the conversion logic when the user clicks the "Convert" button.
	 *
	 * Retrieves the input value and selected units from the view, delegates the
	 * conversion to the model, and displays the result rounded to 4 decimal places.
	 * If the input is invalid (non-numeric), an error message is shown.
	 *
	 * @param e the ActionEvent triggered by clicking the "Convert" button
	 */
	private void convert(ActionEvent e) {
		try {
			double value = view.getInputValue();
			Units inputType = (Units) view.getInputBoxUnit().getSelectedItem();
			Units outputType = (Units) view.getOutputBoxUnit().getSelectedItem();
			double output = model.convertUnit(value, inputType, outputType);
//			String formatted = String.format("%.4f", output);
			view.getOutputValueTextField().setText(String.valueOf(output));

		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "Please enter a valid input!", "Input Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}