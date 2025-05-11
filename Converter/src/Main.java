/**
 * Entry point of the Unit Converter application.
 *
 * This class initializes the MVC components: - View: handles the GUI - Model:
 * contains the conversion logic - Controller: connects user interaction with
 * model and view updates
 */
public class Main {

	public static void main(String[] args) {
		ConverterView view = new ConverterView();
		ConverterModel model = new ConverterModel();
		new ConverterController(model, view);
	}

}