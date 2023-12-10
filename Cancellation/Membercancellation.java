package Cancellation;

//import GUI.Databaseconnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Membercancellation {
    public static void cancelMembership(Connection connection, int memberId) throws SQLException {
        String sql = "UPDATE members SET is_active_member = false WHERE membership_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, memberId);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                System.out.println("No rows affected. Member with ID " + memberId + " not found.");
            } else {
                System.out.println("Membership canceled successfully for member with ID " + memberId);
            }
        } catch (SQLException e) {
            System.out.println("Error canceling membership: " + e.getMessage());
            throw e; // rethrowing the exception to signal the error to the caller
        }
    }
}
