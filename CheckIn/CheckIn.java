package CheckIn;
import java.util.Scanner;
//Ceddy
//Puneeth
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
        return false;//set to false just so we can build and run (laura)
    }

// method to send user to membership portal
    private static void toPortal() {
        // same with this -ced
        System.out.println("Redirecting to membership portal.");
    }
}
