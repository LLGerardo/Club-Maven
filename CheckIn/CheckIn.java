package CheckIn;
import java.util.Scanner;
import GUI.DatabaseConnector; // added this to utilize the database i think (laura)
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Ceddy
//
//Adam

//i asked adam to take a look - ced
public class CheckIn {
//Start with scanner input from user
//If time permits we’ll advance to a barcode
//Increment counters
    //^update: scrapped

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scan barcode/Enter membership ID:");
        String input = scanner.nextLine();

    // check the validity of the membership
        boolean isMembershipValid = checkValidity(input);

        if (isMembershipValid) {
            System.out.println("Check-in successful!");

            toPortal();
        } else {
            System.out.println("Check-in failed, invalid membership.");
        }
        scanner.close();
    }

// method to check membership validity
    private static boolean checkValidity(String memberID){
        // puneeth can you figure out logic pls -ced
        //ok nvm.
        //check if membership id exists in database
        //i'll need to take a look at the database to do this i think -ced
//ok, i got the confirmation from partner that i'd have to do this too. - ced
        
        String[] validIDs = //valid ids;
        for (String ID : validIDs) {
            if (ID.equals(memberID)) {
                return true;
            }
        }
        return false;//set to false just so we can build and run (laura) //TODO:finish this
        //ok i tried just now -ced
        //looks good maybe talk to tofumni about how to connect the database to this (laura)
    }

// method to send user to membership portal
    private static void toPortal() {
        // same with this -ced
        //ok nvm
        //what will the portal be? what will it be on? will it use a url to redirect to?
        System.out.println("Redirecting to membership portal.");
    }
}
