import javax.swing.*;
import java.awt.*;

public class ConverterView {

	private JComboBox<Units> inputBox;
	private JComboBox<Units> outputBox;
	private JTextField sourceValue;
	private JTextField targetValue;
	private JButton convertButton;
	private JPanel panel1;
	private JPanel panel2;
	private JFrame frame;

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

		sourceValue = new JTextField();
		sourceValue.setPreferredSize(new Dimension(100, 20));
		targetValue = new JTextField();
		targetValue.setPreferredSize(new Dimension(100, 20));

		convertButton = new JButton("Convert");

		inputBox = new JComboBox<>(Units.values());
		outputBox = new JComboBox<>(Units.values());
	}

	private void layoutComponents() {
		panel1.add(sourceValue);
		panel1.add(inputBox);
		panel1.add(targetValue);
		panel1.add(outputBox);

		panel2.add(convertButton);

		frame.add(panel1);
		frame.add(panel2);

		frame.setLocationRelativeTo(null);
	}

	protected void updateOutputView(int number) {
		targetValue.setText(String.valueOf(number));
	}

	protected JButton getConvertButton() {
		return convertButton;
	}

	protected int getSourceValue() {
		return Integer.parseInt(sourceValue.getText());
	}

	protected Units getInputUnit() {
		return (Units) inputBox.getSelectedItem();
	}
	
	protected Units getOutputUnit() {
		return (Units) outputBox.getSelectedItem();
	}

}
