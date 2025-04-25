import javax.swing.*;
import java.awt.*;

public class ConverterView {

	JComboBox inputBox;
	JComboBox outputBox;
	JTextField inputTextField;
	JTextField outputTextField;
	JButton convertButton;
	JPanel panel1;
	JPanel panel2;
	JFrame frame;

	public ConverterView() {
		createComponents();
		layoutComponents();
		frame.pack();
		frame.setVisible(true);
	}

	private void createComponents() {
		frame = new JFrame("Unit Converter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(600, 100));
		frame.setLayout(new GridLayout(2, 0));

		panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		panel2 = new JPanel(new GridBagLayout());

		inputTextField = new JTextField();
		inputTextField.setPreferredSize(new Dimension(100, 20));
		outputTextField = new JTextField();
		outputTextField.setPreferredSize(new Dimension(100, 20));

		convertButton = new JButton("Convert");

		String[] inputUnits = { "inch", "centimeter"};
		String[] outputUnits = { "centimeter", "inch"};

		inputBox = new JComboBox(inputUnits);
		outputBox = new JComboBox(outputUnits);
	}

	private void layoutComponents() {
		panel1.add(inputTextField);
		panel1.add(inputBox);
		panel1.add(outputTextField);
		panel1.add(outputBox);

		panel2.add(convertButton);

		frame.add(panel1);
		frame.add(panel2);

		frame.setLocationRelativeTo(null);
	}
	
	protected JButton getConvertButton() {
		return convertButton;
	}
	
	protected String getInputTextField() {
		return (String) inputTextField.getText();
	}
	
	protected String getInputUnit() {
		return (String) inputBox.getSelectedItem();
	}

}
