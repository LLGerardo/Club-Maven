package Cancellation;

//import GUI.Databaseconnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class Membercancellation {

    /*This method runs a squl query that gets a certain membership ID and sets the column is_active_member
     * to false to signify a member's cancellation, if succcesful, it prints out a message 
     * signifying so, otherwise, it returns an error message. This method is called in MembershipPanel.java
     * and is incorporated into the "cancel" action listner.
     */

    public static void cancelMembership(Connection connection, int memberId) throws SQLException {
        //sql query
        String sql = "UPDATE members SET is_active_member = false WHERE membership_id = ?";
        //ensuring changes are added to the appropriate row
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, memberId);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                System.out.println("No rows affected. Member with ID " + memberId + " not found.");
            } else {
                System.out.println("Membership canceled successfully for member with ID " + memberId);
            }
        } catch (SQLException e) {
            System.out.println("Error cancelling membership: " + e.getMessage());
            throw e; // rethrowing the exception to signal the error to the caller
        }
    }
}
