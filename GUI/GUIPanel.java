package GUI;

import Creation.MembershipCreation;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeFormatterBuilder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUIPanel {
    //GUI width
    private static final int WIDTH = 600;
    //GUI height
    private static final int HEIGHT = 750;
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
    private static final JTextArea ENTER_DOB = new JTextArea("mm-dd-yyyy");
    //label for the for the membership length
    private static final JLabel MEM_LENGTH = new JLabel("Enter Memberhsip Length: ");
    //creating the string array for the gym memberships
    private static final String [] MEMBER_LENGTH = {"3 months", "6 months", "12 months", "24 months", "36 months"};
    //the pulldown menu for membership lengths
    private static final JComboBox<String> MEM_LENS = new JComboBox<String>(MEMBER_LENGTH);
    //Label for the payment type
    private static final JLabel PAYMENT_TYPE = new JLabel("Enter Customer Payment Type: ");
    //creating array of strings
    private static final String [] PAYMENT_METHODS = {"Credit Card", "Debit", "Payment App", "Cash"};
    //creating the pulldown menu for the credit card payments
    private static final JComboBox<String> PAYMENT_PULLDOWN = new JComboBox<String>(PAYMENT_METHODS);
    //Label for phone number
    private static final JLabel PHONE_NUMB = new JLabel("Customer Phone Number: ");
    //text area for Phone
    private static final JTextArea ENTER_PHONE = new JTextArea("###-###-####");
    //Label for email
    private static final JLabel CUS_EMAIL = new JLabel("Customer Email: ");
    //text are for email
    private static final JTextArea ENTER_EMAIL = new JTextArea(1,1);
    //Label for address 
    private static final JLabel ADDRESS_LABEL = new JLabel("Customer Address: ");
    //Text Area for address 
    private static final JTextArea ENTER_ADD = new JTextArea();
    //Label for preferred customer contact
    private static final JLabel PREF_CONTACT = new JLabel("Preferred Customer Contact");
    //String array for contact choices
    private static final String [] CONTACT_LIST = {"Phone Call", "SMS", "Email"};
    //the pulldown for the preffered contact
    private static final JComboBox<String> CONTACT_PULL = new JComboBox<String>(CONTACT_LIST);
    //membership start date Label
    private static final JLabel START_DATE = new JLabel("Membership Start Date: ");
    //membership start date text
    private static final JTextArea ENTER_START = new JTextArea("mm-dd-yyyy");
    //JButton for Create New Customer
    private static final JButton CREATE = new JButton("Create New Customer");
    //JButton for Reset
    private static final JButton RESET = new JButton("Reset");
    //placeholder
	private static final JLabel PLACE_HOLDER = new JLabel(" ");
	//placeholder two
	private static final JLabel PLACE_HOLDER2 = new JLabel(" ");
    
    public static void createGUI() {
        // DateTimeFormatter form = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        JFrame frame = new JFrame("Club Maven GUI");
        // setting the size of JFrame
        frame.setSize(WIDTH, HEIGHT);
        // sets the default to close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set to visible
        frame.setVisible(true);
        // JPanel Object
        JPanel panel_one = new JPanel();
        // Setting the panel layout, seven rows, two columns
        panel_one.setLayout(new GridLayout(19, 2, 6, 6));

        // Setting the BackGround Color
        panel_one.setBackground(Color.GRAY);

        // adding constants to the panel
        // adding the last name label to panel
        panel_one.add(LASTNAME);
        // setting the font
        LASTNAME.setFont(ARIAL);
        // setting the color
        LASTNAME.setForeground(Color.BLUE);
        // adding the first name label to the panel
        panel_one.add(FIRSTNAME);
        // setting the font
        FIRSTNAME.setFont(ARIAL);
        // setting test color
        FIRSTNAME.setForeground(Color.BLUE);
        // adding the last name text area
        panel_one.add(CUST_LASTNAME);

        // adding the first name text area
        panel_one.add(CUST_FIRSTNAME);
        // adding the label for the Gender label
        panel_one.add(GENDER);
        // setting font
        GENDER.setFont(ARIAL);
        // setting color
        GENDER.setForeground(Color.BLUE);
        // adding the label for date of birth
        panel_one.add(DATE_OF_BIRTH);
        // setting font
        DATE_OF_BIRTH.setFont(ARIAL);
        // setting color
        DATE_OF_BIRTH.setForeground(Color.BLUE);
        panel_one.add(DATE_OF_BIRTH);

        // adding the pull down to the panel
        panel_one.add(GENDER_CHOICE);
        // adding the DOB Text Area
        panel_one.add(ENTER_DOB);
        // adding label for membership length
        panel_one.add(MEM_LENGTH);
        // setting font
        MEM_LENGTH.setFont(ARIAL);
        // setting color
        MEM_LENGTH.setForeground(Color.BLUE);
        // adding label
        panel_one.add(PAYMENT_TYPE);
        // adding font
        PAYMENT_TYPE.setFont(ARIAL);
        // adding color
        PAYMENT_TYPE.setForeground(Color.BLUE);
        // adding to the panel
        panel_one.add(MEM_LENS);
        // adding payment pull down
        panel_one.add(PAYMENT_PULLDOWN);
        // adding the payment
        panel_one.add(START_DATE);
        // adding font
        START_DATE.setFont(ARIAL);
        // adding color
        START_DATE.setForeground(Color.BLUE);
        // adding payment type
        PAYMENT_TYPE.setForeground(Color.BLUE);
        // phone number label
        panel_one.add(PHONE_NUMB);
        // setting text
        PHONE_NUMB.setFont(ARIAL);
        // setting color
        PHONE_NUMB.setForeground(Color.BLUE);
        // adding text area
        panel_one.add(ENTER_START);
        // adding text area for phone
        panel_one.add(ENTER_PHONE);
        // adding email label
        panel_one.add(CUS_EMAIL);
        // setting Text
        CUS_EMAIL.setFont(ARIAL);
        // setting color
        CUS_EMAIL.setForeground(Color.BLUE);
        // adding label for
        panel_one.add(PREF_CONTACT);
        // setting the font
        PREF_CONTACT.setFont(ARIAL);
        // setting the color
        PREF_CONTACT.setForeground(Color.BLUE);
        // adding text area for Phone
        panel_one.add(ENTER_EMAIL);
        // adding the pulldown
        panel_one.add(CONTACT_PULL);
        //adding label for 
		
		panel_one.add(ADDRESS_LABEL);
		//set font
		ADDRESS_LABEL.setFont(ARIAL);
		//setting color
		ADDRESS_LABEL.setForeground(Color.BLUE);
		//adding the placeholder
		panel_one.add(PLACE_HOLDER);
		//adding text area for address
		panel_one.add(ENTER_ADD);
		//adding the placeholder
		panel_one.add(PLACE_HOLDER2);
        panel_one.add(CREATE);
        // adding button for reset
        panel_one.add(RESET);

        CREATE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lastname = CUST_LASTNAME.getText();
                String firstname = CUST_FIRSTNAME.getText();
                // String gen = (String) GENDER_CHOICE.getSelectedItem();
                String date_of_birth = ENTER_DOB.getText();
                LocalDate dob = LocalDate.parse(date_of_birth, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
                // String payment = (String) PAYMENT_PULLDOWN.getSelectedItem();
                String memb_length = (String) MEM_LENS.getSelectedItem();
                String phone = ENTER_PHONE.getText();
                String email = ENTER_EMAIL.getText();
                String prefcontact = (String) CONTACT_PULL.getSelectedItem();
                String address = ENTER_ADD.getText();
                String membership_plan = memb_length;
                // String start_date = ENTER_START.getText();
                LocalDate creationDate = LocalDate.now();
                // Calling the createMember method from MembershipCreation
                MembershipCreation membershipCreation = new MembershipCreation();
                membershipCreation.createMember(firstname, lastname, date_of_birth, address, phone, email, prefcontact,
                        creationDate, membership_plan);
            }
        });

        RESET.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reset all input fields
                CUST_LASTNAME.setText("");
                CUST_FIRSTNAME.setText("");
                GENDER_CHOICE.setSelectedIndex(0);
                ENTER_DOB.setText("mm-dd-yyyy");
                MEM_LENS.setSelectedIndex(0);
                PAYMENT_PULLDOWN.setSelectedIndex(0);
                ENTER_PHONE.setText("###-###-####");
                ENTER_EMAIL.setText("");
                CONTACT_PULL.setSelectedIndex(0);
                ENTER_ADD.setText("");
                ENTER_START.setText("mm-dd-yyyy");

            }
        });

        frame.add(panel_one);
        frame.revalidate();
    }
}
