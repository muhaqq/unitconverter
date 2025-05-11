import java.awt.event.ActionEvent;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;

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
	 * A predefined mapping from unit categories (e.g., LENGTH, TIME) to the
	 * corresponding enum values that implement the Units interface.
	 */
	private final Map<UnitCategory, Units[]> unitMap = Map.of(UnitCategory.LENGTH, Length.values(), UnitCategory.WEIGHT,
			Weight.values(), UnitCategory.TEMPERATURE, Temperature.values(), UnitCategory.TIME, Time.values(),
			UnitCategory.VOLUME, Volume.values(), UnitCategory.AREA, Area.values(), UnitCategory.SPEED, Speed.values(),
			UnitCategory.ENERGY, Energy.values());

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
		Units[] units = unitMap.get(selectedCategory);

		if (units != null) {
			view.getInputBoxUnit().setModel(new DefaultComboBoxModel<>(units));
			view.getOutputBoxUnit().setModel(new DefaultComboBoxModel<>(units));
		}
	}

	/**
	 * Converts the input value from the selected input unit to the selected output
	 * unit.
	 * 
	 * This method is triggered when the user clicks the "Convert" button. It
	 * retrieves the numeric value and selected units from the view, performs the
	 * conversion via the model, and then updates the output field with the result.
	 * 
	 * @param e the ActionEvent triggered by clicking the "Convert" button
	 */
	private void convert(ActionEvent e) {
		double value = view.getInputValue();
		Units inputType = (Units) view.getInputBoxUnit().getSelectedItem();
		Units outputType = (Units) view.getOutputBoxUnit().getSelectedItem();

		double output = model.convertUnit(value, inputType, outputType);
		view.getOutputValueTextField().setText(String.valueOf(output));
	}
}