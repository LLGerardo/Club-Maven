package MembershipPortal;

import Creation.Member;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

/* This class is designed to take create a GUI that will take in member requests to request check-in,
 * change their data, to change the length of their memberships, and to cancel their memberships.
 */
public class MembershipPanel{

//String for membername
private static String username = "Member";
//label for Welcome
private static JLabel welcome = new JLabel("Welcome to Club Maven, " + username + "!");
//setting width of panel
private static final int WIDTH = 400;
//setting height
private static final int HEIGHT = 600;
//label for entering member ID
private static final JLabel MEM_ID_LABEL = new JLabel("Enter Member ID");
//text area for MemberID
private static final JTextArea MEM_ID_TEXT = new JTextArea();
//button for Enter Id
private static final JButton MEM_ID_BUTTON = new JButton("Enter ID");
//label for request
private static final JLabel REQUEST_LABEL = new JLabel("Request Check-in Barcode: ");
//label for change details
private static final JLabel CHANGE_DETAILS = new JLabel("Change Personal Information: ");
//label for change membership length
private static final JLabel CHANGE_LENGTH = new JLabel("Change Membership Length: ");
//label static final
private static final JLabel CANCEL_MEM = new JLabel("Cancel Membership");
//button for Check-in
private static final JButton REQUEST_BUTTON = new JButton("Request Check-in");
//button for Change Details button
private static final JButton DETAILS_BUTTON = new JButton("Change Details");
//String Array list
private static final String [] MONTHS = {"add three months", "add two months", "add one month","subtract one month", "subtract two months", "subtract three months" };
//combobox for Change Membership Length 
private static final JComboBox<String> CHANGE_PULLDOWN = new JComboBox<String>(MONTHS);
//adding the confirm button
private static final JButton CONFIRM = new JButton("Confirm Change");
//button for change
private static final JButton CANCEL_BUTTON = new JButton("Cancel");



    public static void createMemberPanel(){
        JFrame frame = new JFrame("Membership Portal");
        frame.setSize(WIDTH,HEIGHT);
		//sets the default to close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set to visible
		frame.setVisible(true);
		//JPanel Object
		JPanel panel_one = new JPanel();
		//Setting the panel layout, seven rows, two columns
		panel_one.setLayout(new GridLayout(16,1,6,6));
        //adding the color
        panel_one.setBackground(Color.LIGHT_GRAY);
        //adding the Welcome label
        panel_one.add(welcome);
        //adding the member ID Label
        panel_one.add(MEM_ID_LABEL);
        //adding the text area
        panel_one.add(MEM_ID_TEXT);
        //adding the text button
        panel_one.add(MEM_ID_BUTTON);
        //adding the action listener
        MEM_ID_BUTTON.addActionListener(new ActionListener(){
            //this method will set the member ID
            @Override
            public void actionPerformed(ActionEvent e) {
               username = MEM_ID_TEXT.getText();
               welcome.setText("Welcome back, " + username +"!");
               System.out.println(username);
                // TODO Auto-generated method stub
                //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }});
        //adding the request label
        panel_one.add(REQUEST_LABEL);
        //adding the request button
        panel_one.add(REQUEST_BUTTON);
        //adding the action listener
        REQUEST_BUTTON.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                BarCodePanel.createBarcode();
                // TODO Auto-generated method stub
                //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            //this method will send a bar code to the member
        });
        //adding the change label
        panel_one.add(CHANGE_DETAILS);
        //adding details button
        panel_one.add(DETAILS_BUTTON);
        //adding action Listener
        DETAILS_BUTTON.addActionListener(new ActionListener(){
            //this action listener will implement a change in the membership length
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }});
        //change length
        panel_one.add(CHANGE_LENGTH);
        //adding jcombobox
        panel_one.add(CHANGE_PULLDOWN);
        //adding confirm
        panel_one.add(CONFIRM);
        //adding the action listener
        CONFIRM.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            //this method will confirm the change
            
        });
        //adding cancel
        panel_one.add(CANCEL_MEM);
        //cancel button
        panel_one.add(CANCEL_BUTTON);
        //adding the action listener
        CANCEL_BUTTON.addActionListener(new ActionListener(){
            //this method will call cancellation method
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }});
        //adding bigger panel
        JPanel big_panel = new JPanel();
        //setting the color
        big_panel.setBackground(Color.LIGHT_GRAY);
        //adding the smaller panel
        big_panel.add(panel_one);
        //adding to the frame;
        frame.add(big_panel);


    }
    
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            
            MembershipPanel.createMemberPanel();
        }
    
    }


