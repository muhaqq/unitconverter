import javax.swing.*;
import java.awt.*;

/**
 * View class responsible for creating and displaying the GUI of the unit
 * converter. It provides access to key UI components for the controller to
 * interact with.
 */
public class ConverterView {

	private static final Dimension FIELD_SIZE = new Dimension(100, 20);
	private static final Dimension BUTTON_SIZE = new Dimension(250, 30);
	private static final Dimension WINDOW_SIZE = new Dimension(450, 300);

	private JFrame frame;

	private JLabel titleLabel;
	private JLabel categoryLabel;
	private JLabel resultLabel;
	private JLabel inputLabel;

	private JComboBox<UnitCategory> categoryBox;
	private JComboBox<Units> inputBoxUnit, outputBoxUnit;

	private JButton convertButton;

	private JPanel upperPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;

	private JTextField inputValueTextField, outputValueTextField;

	GridBagConstraints gbc;

	/**
	 * Constructs the view and initializes all components and layout.
	 */
	public ConverterView() {
		createComponents();
		layoutComponents();
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Initializes all Swing components used in the UI.
	 */
	private void createComponents() {
		titleLabel = new JLabel("Unit Converter");
		titleLabel.setFont(new Font("Calibri", Font.BOLD, 20));

		gbc = new GridBagConstraints();

		frame = new JFrame("Unit Converter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(WINDOW_SIZE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);

		categoryLabel = new JLabel("Category:");
		inputLabel = new JLabel("Input:");
		inputValueTextField = new JTextField();
		inputValueTextField.setPreferredSize(FIELD_SIZE);

		resultLabel = new JLabel("Result:");
		outputValueTextField = new JTextField();
		outputValueTextField.setPreferredSize(FIELD_SIZE);
		outputValueTextField.setBackground(new Color(245, 245, 245));
		outputValueTextField.setFont(new Font("Calibri", Font.BOLD, 12));
		outputValueTextField.setEditable(false);

		convertButton = new JButton("Convert");
		convertButton.setPreferredSize(BUTTON_SIZE);
		convertButton.setFont(new Font("Calibri", Font.BOLD, 15));

		inputBoxUnit = new JComboBox<>(Length.values());
		outputBoxUnit = new JComboBox<>(Length.values());
		categoryBox = new JComboBox<>(UnitCategory.values());

		upperPanel = new JPanel();
		upperPanel.setBackground(Color.LIGHT_GRAY);
		upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		middlePanel = new JPanel();
		middlePanel.setLayout(new GridBagLayout());

		lowerPanel = new JPanel();
		lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	}

	/**
	 * Arranges the components on the frame using GridBagLayout and FlowLayouts.
	 */
	private void layoutComponents() {
		upperPanel.add(titleLabel);

		gbc.insets = new Insets(10, 5, 10, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		addComponent(middlePanel, categoryLabel, 0, 0);
		addComponent(middlePanel, categoryBox, 1, 0);
		addComponent(middlePanel, inputLabel, 0, 1);
		addComponent(middlePanel, inputValueTextField, 1, 1);
		addComponent(middlePanel, inputBoxUnit, 2, 1);
		addComponent(middlePanel, resultLabel, 0, 4);
		addComponent(middlePanel, outputValueTextField, 1, 4);
		addComponent(middlePanel, outputBoxUnit, 2, 4);

		lowerPanel.add(convertButton);

		frame.add(upperPanel, BorderLayout.NORTH);
		frame.add(middlePanel, BorderLayout.CENTER);
		frame.add(lowerPanel, BorderLayout.SOUTH);
	}

	/**
	 * Adds a component to a panel using GridBagConstraints.
	 *
	 * @param panel the panel to add to
	 * @param comp  the component to add
	 * @param x     grid x position
	 * @param y     grid y position
	 */
	private void addComponent(JPanel panel, Component comp, int x, int y) {
		gbc.gridx = x;
		gbc.gridy = y;
		panel.add(comp, gbc);
	}

	/** @return the category combo box */
	protected JComboBox<UnitCategory> getCategoryBox() {
		return categoryBox;
	}

	/** @return the input unit combo box */
	protected JComboBox<Units> getInputBoxUnit() {
		return inputBoxUnit;
	}

	/** @return the output unit combo box */
	protected JComboBox<Units> getOutputBoxUnit() {
		return outputBoxUnit;
	}

	/** @return the text field displaying the result */
	protected JTextField getOutputValueTextField() {
		return outputValueTextField;
	}

	/**
	 * Parses the value from the input field as double.
	 *
	 * @return the numeric input value entered by the user
	 * @throws NumberFormatException if the input is not a valid number
	 */
	protected double getInputValue() {
		return Double.parseDouble(inputValueTextField.getText());
	}

	/** @return the convert button */
	protected JButton getConvertButton() {
		return convertButton;
	}
}