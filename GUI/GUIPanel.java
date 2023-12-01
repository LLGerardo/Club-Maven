package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;



/*This class creates a GUI in order to register a new club member. This class will require
 * several libraries from the swing library. 
 * intended for use by the club staff The constants are the width
 * and height of the GUI, the Labels, Text areas, and Buttons */

public class GUIPanel {
	//GUI width
	private static final int WIDTH = 500;
	//GUI height
	private static final int HEIGHT = 600;
	//Creating a new font object
	private static final Font ARIAL = new Font("Arial", Font.BOLD, 14);
	//Label for the Last name
	private static final JLabel LASTNAME = new JLabel("Enter New Customer Last Name: ");
	//Text area for the customer's last name, where the staff member will input
	private static final JTextArea CUST_LASTNAME = new JTextArea();
	//Label for for the customer's first name
	private static final JLabel FIRSTNAME = new JLabel("Enter New Customer First Name: ");
	//Text for the first name
	private static final JTextArea CUST_FIRSTNAME = new JTextArea();
	//Label for the gender
	private static final JLabel GENDER = new JLabel("Enter New Custumer Gender: ");
	//creating a list of strings to be placed into the Gender ComboBox, the ComboBox itself will
	//instantiatied in the creation of the GUI
	private static final String [] GEN_LIST = {"Female", "Male", "Other"};
	//the JComboBox for the Gender Choice. These are JCF members that take 
	private static final JComboBox<String> GENDER_CHOICE = new JComboBox<String>(GEN_LIST);
	//Label for the customer's date of birth
	private static final JLabel DATE_OF_BIRTH = new JLabel("Customer's Date of Birth: ");
	//text field for date of birth
	private static final JTextArea ENTER_DOB = new JTextArea("mm/dd/yyyy");
	//label for the for the membership length
	private static final JLabel MEM_LENGTH = new JLabel("Enter Memberhsip Length: ");
	//creating the string array for the gym memberships
	private static final String [] MEMBER_LENGTH = {"3 months", "6 months", "12 months", "24 months"};
	//the pulldown menu for membership lengths
	private static final JComboBox<String> MEM_LENS = new JComboBox<String>(MEMBER_LENGTH);
	//Label for the payment type
	private static final JLabel PAYMENT_TYPE = new JLabel("Enter Customer Payment Type: ");
	//creating array of strings
	private static final String [] PAYMENT_METHODS = {"Credit Card", "Debit", "Payment App", "Cash"};
	//creating the pulldown menu for the credit card payments
	private static final JComboBox<String> PAYMENT_PULLDOWN = new JComboBox<String>(PAYMENT_METHODS);
	//membership start date Label
	private static final JLabel START_DATE = new JLabel("Membership Start Date: ");
	//membership start date text
	private static final JTextArea ENTER_START = new JTextArea("mm/dd/yyyy");
	//Label for additional notes
	private static final JLabel NOTES_LABEL = new JLabel("Additional Notes on Customers: ");
	//text area for notes
	private static final JTextArea NOTES = new JTextArea("Notes");
	//JButton for Create New Customer
	private static final JButton CREATE = new JButton("Create New Customer");
	//JButton for Reset
	private static final JButton RESET = new JButton("Reset");
			
	//pull down menu for customer Gender 
	
	
	
/*METHOD: creates a GUI panel for user input. The method requires the instantiation of 
 *JFrame and panel objects in order to implement the GUI.
 *The instance of the panel, which sets the outlay of the labels and text areas
* @PARAM: None*/
	
	
	
	public static void createGUI() {
		
		
		JFrame frame = new JFrame();
		//setting the size of JFrame
		frame.setSize(WIDTH,HEIGHT);
		//sets the default to close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set to visible
		frame.setVisible(true);
		//JPanel Object
		JPanel panel_one = new JPanel();
		//Setting the panel layout, seven rows, two columns
		panel_one.setLayout(new GridLayout(13,2,6,6));
		
		//Setting the BackGround Color
		panel_one.setBackground(Color.GRAY);
		
		//adding constants to the panel
		//adding the last name label to panel
		panel_one.add(LASTNAME);
		//setting the font
		LASTNAME.setFont(ARIAL);
		//setting the color
		LASTNAME.setForeground(Color.BLUE);
		//adding the first name label to the panel
		panel_one.add(FIRSTNAME);
		//setting the font
		FIRSTNAME.setFont(ARIAL);
		//setting test color
		FIRSTNAME.setForeground(Color.BLUE);
		//adding the last name text area
		panel_one.add(CUST_LASTNAME);
		
		//adding the first name text area 
		panel_one.add(CUST_FIRSTNAME);
		//adding the label for the Gender label
		panel_one.add(GENDER);
		//setting font
		GENDER.setFont(ARIAL);
		//setting color
		GENDER.setForeground(Color.BLUE);
		//adding the label for date of birth
		panel_one.add(DATE_OF_BIRTH);
		//setting font
		DATE_OF_BIRTH.setFont(ARIAL);
		//setting color
		DATE_OF_BIRTH.setForeground(Color.BLUE);
		panel_one.add(DATE_OF_BIRTH);
		
		//adding the pull down to the panel
		panel_one.add(GENDER_CHOICE);
		//adding the DOB Text Area
		panel_one.add(ENTER_DOB);
		//adding label for membership length
		panel_one.add(MEM_LENGTH);
		//setting font
		MEM_LENGTH.setFont(ARIAL);
		//setting color
		MEM_LENGTH.setForeground(Color.BLUE);
		//adding label
		panel_one.add(PAYMENT_TYPE);
		//adding font
		PAYMENT_TYPE.setFont(ARIAL);
		//adding color
		PAYMENT_TYPE.setForeground(Color.BLUE);
		//adding to the panel
		panel_one.add(MEM_LENS);
		//adding payment pull down
		panel_one.add(PAYMENT_PULLDOWN);
		//adding the payment
		panel_one.add(START_DATE);
		//adding font
		START_DATE.setFont(ARIAL);
		//adding color
		START_DATE.setForeground(Color.BLUE);
		//adding payment type
		PAYMENT_TYPE.setForeground(Color.BLUE);
		//adding notes label
		panel_one.add(NOTES_LABEL);
		//adding font
		NOTES_LABEL.setFont(ARIAL);
		//adding color
		NOTES_LABEL.setForeground(Color.BLUE);
		//adding text area
		panel_one.add(ENTER_START);
		//adding text area
		panel_one.add(NOTES);
		//adding button
		panel_one.add(CREATE);
		//adding button for reset
		panel_one.add(RESET);
		//adding the action listeners. When looking at the 
		CREATE.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				String lastname = CUST_LASTNAME.getText();
				String firstname = CUST_FIRSTNAME.getText();
				String gen = (String) GENDER_CHOICE.getSelectedItem();
				String dob = ENTER_DOB.getText();
				String payment = (String) PAYMENT_PULLDOWN.getSelectedItem();
				String memb_length = (String) MEM_LENS.getSelectedItem();
				String start_date = ENTER_START.getSelectedText();
				String customer_notes = NOTES.getText();


				System.out.println(lastname);
				System.out.println(firstname);
				System.out.println(gen);
				System.out.println(dob);
				System.out.println(payment);
				System.out.println(memb_length);
				System.out.println(start_date);
				System.out.println(customer_notes);
				
			
		}
				
	});

	RESET.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			CUST_LASTNAME.setText(null);
			CUST_FIRSTNAME.setText(null);
			GENDER_CHOICE.setSelectedItem(null);

			ENTER_DOB.setText(null);
			PAYMENT_PULLDOWN.setSelectedItem(null);
			MEM_LENS.setSelectedItem(null);
			ENTER_START.setText(null);
			NOTES.setText(null);
			throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
		}
		
		
	});
		
		//This the larger panel into which our panel will be nested
		JPanel big_panel = new JPanel();
		big_panel.setBackground(Color.GRAY);
		big_panel.add(panel_one);
		
		
		
		
		//adding the panel to the bigger panel
		frame.add(big_panel);
			
	}
}
