package CheckIn;
import java.util.Scanner;
//Ceddy
//
public class CheckIn {
//Start with scanner input from user
//If time permits we’ll advance to a barcode
//Increment counters

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scan barcode/Enter membership ID");
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
        String[] validIDs = //valid ids;
        for (String ID : validIDs) {
            if (ID.equals(memberID) {
                return true;
            }
        }
        return false;//set to false just so we can build and run (laura) //TODO:finish this
        //ok i tried just now -ced
    }

// method to send user to membership portal
    private static void toPortal() {
        // same with this -ced
        //ok nvm
        //what will the portal be? what will it be on? will it use a url to redirect to?
        System.out.println("Redirecting to membership portal.");
    }
}
