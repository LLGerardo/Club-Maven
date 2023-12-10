//Sumayli

package Cancellation;

import GUI.Databaseconnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Membercancellation {
    /*This method cancels a member's membership by setting their status to false. 
        A member's information is not completely wiped out. A sql query runs that updates the table
        and sets is_active_member cloumn to false given the membership ID.*/
    public static void cancelMembership(Connection connection, int memberId) throws SQLException {
        //sql query
        String sql = "UPDATE members SET is_active_member = false WHERE membership_id = ?";
        //implementing changes into cloumn
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, memberId);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Membership cancellation failed, no rows affected.");
            }
        }
    }
    public static void main(String[] args) {
        int cancelmember = 3; 
        Connection connection = null; 
        try {
            // Initializing connection here, make sure it's open
            connection = Databaseconnector.getConnection();

            // Calling the cancelMembership method with the connection parameter
            cancelMembership(connection, cancelmember);
            System.out.println("\n Membership cancelled successfully. \n");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Closing the connection in a finally block to ensure it's closed even if an exception occurs
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

