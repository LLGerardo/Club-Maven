package MembershipPortal;
import Creation.Member;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
private static final int WIDTH = 500;
//setting height
private static final int HEIGHT = 500;
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

//l
/* This membership sets the username of to that of the logged in member.
 * @PARAM: Member to access member name
 * @METHOD: Returns username of member
 */
    public static String setUsername(Member member){
    username = member.getUsername();
    return username;
}



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
		panel_one.setLayout(new GridLayout(12,1,6,6));
        //adding the Welcome label
        panel_one.add(welcome);
        //adding the request label
        panel_one.add(REQUEST_LABEL);
        //adding the request button
        panel_one.add(REQUEST_BUTTON);
        //adding the change label
        panel_one.add(CHANGE_DETAILS);
        //adding details button
        panel_one.add(DETAILS_BUTTON);
        //change length
        panel_one.add(CHANGE_LENGTH);
        //adding jcombobox
        panel_one.add(CHANGE_PULLDOWN);
        //adding confirm
        panel_one.add(CONFIRM);
        //adding cancel
        panel_one.add(CANCEL_MEM);
        //cancel button
        panel_one.add(CANCEL_BUTTON);
        //adding bigger panel
        JPanel big_panel = new JPanel();
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


