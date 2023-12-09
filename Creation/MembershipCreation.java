package Creation;

import GUI.Databaseconnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MembershipCreation {
    /*This method creates a new member. A new member object is cerated and a member is added to the database  */
    public void createMember(String firstName, String lastName, String dobInput, String address,
            String phone, String email, String preferredContactMethod, LocalDate creationdate, String membershipPlan) {
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            LocalDate dateOfBirth = LocalDate.parse(dobInput, dateFormatter);
            LocalDate creationDate = LocalDate.now();
            String username = generateUniqueUsername(firstName, lastName);

            Member member = new Member(firstName, lastName, username, dateOfBirth, address, phone, email,
                    preferredContactMethod,
                    creationDate, true, membershipPlan);

            Databaseconnector.insertMember(member);

            System.out.println("Member created successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating member: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An unexpected error occurred during member creation.");
        }
    }
    /*This method generates a username for a club memeber using their first and last name. 
    Isusername method is called to check if the username already exists in the databse,
    while it's true, a suffix is added and increments until it is unique */
    private String generateUniqueUsername(String firstName, String lastName) {
        String baseUsername = firstName.toLowerCase() + lastName.toLowerCase();
        String generatedUsername = baseUsername;
        int suffix = 1;
        while (isUsernameTaken(generatedUsername)) {
            generatedUsername = baseUsername + suffix;
            suffix++;
        }

        return generatedUsername;
    }
    /* This method checks if a username is already in the database and returns a boolean.
        It checks by running a query that selects all members with a given username 
        and returns the count, if the count si greater than 0, it returns true*/
    private boolean isUsernameTaken(String username) {
        try (Connection connection = Databaseconnector.getConnection()) {
            String query = "SELECT COUNT(*) FROM members WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    resultSet.next();
                    int count = resultSet.getInt(1);

                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }
    /* This method checks that the email is in the right format and returns an error message if it is'nt */
    public static boolean isValidEmail(String email) throws IllegalArgumentException {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        } else {
            throw new IllegalArgumentException("Invalid email format: " + email);
        }
    }
}
