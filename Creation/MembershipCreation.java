package Creation;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//Adam
//Laura

public class MembershipCreation {
    public void createMember() { //create new member process
        Scanner scan = new Scanner(System.in); //use scanner to read input
        System.out.println("Enter your first name: ");// name
        String firstName=scan.nextLine().toLowerCase(); //store in all lowercase

        System.out.println("Enter your last name: "); 
        String lastName=scan.nextLine().toLowerCase(); 

        String username=firstName+lastName;//create username 

        System.out.println("Enter your date of birth (yyyy-MM-dd): ");//DOB
        String dobInput = scan.next();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //define expected date format
        LocalDate dateOfBirth = null;
        try {      
            dateOfBirth = LocalDate.parse(dobInput, dateFormatter);//parse the input into a LocalDate object
            System.out.println("Date of Birth: " + dateOfBirth); //print the parsed date
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
        }

        System.out.println("Enter your Home Address (1234 Broadway Ave, Chicago,IL 60660)");//Address
        String address = scan.nextLine();
        System.out.println("Enter your phone number (xxx-xxx-xxxx): ");//Phone
        String phone=scan.next();
        System.out.println("Enter your email (xxxx@zzz.com): ");//email
        String email = scan.next();
        isValidEmail(email);//verifyEmail throw exception if not real email
        System.out.println("Enter your preferred Contact Method? (Email, Phone, Mail, or None): ");//prompt for//Contact Method
        String preferredContactMethod = scan.nextLine();
        LocalDate creationDate = LocalDate.now();//creation date
        System.out.println("Choose a membership plan (6 months, 1 year, or 3 years): "); //membership plan (6 months, 1 year, or 3 year)
        String membershipPlan = scan.nextLine();
        LocalDate membershipEndDate = calculateMembershipEndDate(creationDate, membershipPlan); // calculate end date accoridng to chosen membership plan (6 months, 1 year, or 3 year)
        boolean isActiveMember = true;
        Member member = new Member(firstName,lastName, username, dateOfBirth,
        address, phone, email, preferredContactMethod,
        creationDate, isActiveMember, membershipPlan);//create member object
        int membershipId = member.getMembershipId();//membership ID generation
       
        System.out.println("Membership ID: " + membershipId); // tell user membershipId number and when this cycle ends
        System.out.println("Membership will end on: " + membershipEndDate);
        member.verifyAge();//verifyAge throw exception if under 18 years
        scan.close(); // close scanner
    }
    
    public static boolean isValidEmail(String email) throws IllegalArgumentException{ //verify valid email format not necessaril
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";//regular expression for basic email format
        Pattern pattern = Pattern.compile(emailRegex);// pattern object
        Matcher matcher = pattern.matcher(email);// matcher object
        if (matcher.matches()){// if the email matches the pattern
            return true;
        } else {
            throw new IllegalArgumentException("Invalid email format: " + email);
        }
    }

    private LocalDate calculateMembershipEndDate(LocalDate startDate, String plan) {
        switch (plan.toLowerCase().trim()) {
            case "6 months":
                return startDate.plusMonths(6);
            case "6":
                return startDate.plusMonths(6);
            case "1 year":
                return startDate.plusYears(1);
            case "1":
                return startDate.plusYears(1);
            case "3 years":
                return startDate.plusYears(3);
            case "3":
                return startDate.plusYears(3);
            default:
                throw new IllegalArgumentException("Invalid membership plan: " + plan);
        }
    }
}
