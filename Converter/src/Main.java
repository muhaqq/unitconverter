import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		ConverterView view = new ConverterView();
		ConverterModel model = new ConverterModel();
		new ConverterController(model, view);
	}

}
