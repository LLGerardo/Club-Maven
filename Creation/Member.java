package Creation; // i have no clue what creation does but it yells at me if its not here. If you understand please explain
import java.time.LocalDate;
import java.time.Period;

public class Member {
    private static int nextMembershipId = 1;

    private String firstName;
    private String lastName;
    private String username;
    private LocalDate dateOfBirth;
    private String address;
    private String phone;
    private String email;
    private int age;
    private int visitCounter;
    private String preferredContactMethod;
    private LocalDate creationDate;
    private boolean isActiveMember;
    private String membershipPlan;
    private LocalDate membershipEndDate;
    private int membershipId;

    public Member(String firstName, String lastName, String username, LocalDate dateOfBirth,
                  String address, String phone, String email, String preferredContactMethod,
                  LocalDate creationDate, boolean isActiveMember, String membershipPlan) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.preferredContactMethod = preferredContactMethod;
        this.creationDate = creationDate;
        this.isActiveMember = isActiveMember;
        this.membershipPlan = membershipPlan;
        this.age = calculateAge(dateOfBirth);
        this.membershipEndDate = calculateMembershipEndDate(creationDate, membershipPlan);
        this.membershipId = nextMembershipId++;
    }

    // Getter methods for attributes

    public int getAge() {
        return age;
    }

    public void verifyAge() {
        LocalDate currentDate = LocalDate.now();
        Period ageDifference = Period.between(dateOfBirth, currentDate);

        if (ageDifference.getYears() < 18) {
            throw new IllegalArgumentException("Member is under 18 years old.");
        }
    }

    public LocalDate getMembershipEndDate() {
        return membershipEndDate;
    }

    public int getMembershipId() {
        return membershipId;
    }

    private int calculateAge(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }

    private LocalDate calculateMembershipEndDate(LocalDate startDate, String plan) {
        // Logic to calculate the membership end date based on the start date and plan
        // TODO: his is a placeholder //need to implement more logic
        return startDate.plusMonths(12); //one-year membership
    }
    void delete() { 
        // TODO: Implement this feature
        // marking them as inactive or removing them from a database?
        // set isActiveMember to false or perform any necessary cleanup
        isActiveMember = false;
    }

    LocalDate start() {
        // TODO: Implement this feature 
        // This method could be used to get the start date of the membership.
        return creationDate;
    }

    boolean active() {
        // TODO: Implement this feature
        // This method checks if the membership is currently active.
        return isActiveMember;
    }

    boolean visitCountdown() {
        // TODO: Implement this feature
        // This method could be used to check if the member's visit countdown has reached <= 0.
        // You would need to add a variable representing the visit countdown and decrement it accordingly.
        // For example:
        // return visitCountdown <= 0;
        // where visitCountdown is a member variable that you would decrement over time.
        // Make sure to initialize it appropriately when a member is created.
        int visitCounter= this.visitCounter;
        if (visitCounter<=0){

        }
        
        return false; // TODO: Placeholder, replace with actual implementation
    }

    int visitStreak() {
        // TODO: Implement this feature
        // This method could be used to get the all-time visit streak of the member.
        // You would need to add a variable representing the visit streak and update it based on the member's activity.
        // For example:
        // return visitStreak;
        // where visitStreak is a member variable that you would update based on the member's visits.
        return 0; // Placeholder, replace with actual implementation
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Membership ID: ").append(membershipId).append("\n");
        sb.append("Name: ").append(firstName).append(" ").append(lastName).append("\n");
        sb.append("Username: ").append(username).append("\n");
        sb.append("Date of Birth: ").append(dateOfBirth).append("\n");
        sb.append("Address: ").append(address).append("\n");
        sb.append("Phone: ").append(phone).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Age: ").append(age).append("\n");
        sb.append("Preferred Contact Method: ").append(preferredContactMethod).append("\n");
        sb.append("Creation Date: ").append(creationDate).append("\n");
        sb.append("Active Membership: ").append(isActiveMember).append("\n");
        sb.append("Membership Plan: ").append(membershipPlan).append("\n");
        sb.append("Membership End Date: ").append(membershipEndDate).append("\n");

        return sb.toString();
    }
}