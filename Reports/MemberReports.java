package Reports;
import GUI.Databaseconnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberReports {

    public static void main(String[] args) {
        generateInactiveMembersReport();
        generateExpiredMembershipReport();
    }

    public static void generateInactiveMembersReport() {
        try {
            // Getting a connection to the database 
            Connection connection = Databaseconnector.getConnection();

            // SQL query that retrieves inactive members that have cancelled membership and are no longer a member
            String inactiveMembersSql = "SELECT * FROM members WHERE is_active_member = false";
            try (PreparedStatement inactiveMembersStatement = connection.prepareStatement(inactiveMembersSql)) {
                // Executing the query
                ResultSet inactiveMembersResultSet = inactiveMembersStatement.executeQuery();

                // Processing the results for inactive members
                System.out.println("Inactive Members Report:");
                while (inactiveMembersResultSet.next()) {
                    // Retrieveing data from the result set
                    int memberId = inactiveMembersResultSet.getInt("membership_id");
                    String firstName = inactiveMembersResultSet.getString("first_name");
                    String lastName = inactiveMembersResultSet.getString("last_name");

                    // Displaying the data 
                    System.out.println("Member ID: " + memberId + ", Name: " + firstName + " " + lastName);
                }
                System.out.println(); 
            }

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void generateExpiredMembershipReport() {
        try {
            // Getting a connection to the database using your Databaseconnector class
            Connection connection = Databaseconnector.getConnection();

            // Preparing the SQL query for expired memberships
            String expiredMembershipsSql = "SELECT * FROM members WHERE membership_end_date < CURRENT_DATE";
            try (PreparedStatement expiredMembershipsStatement = connection.prepareStatement(expiredMembershipsSql)) {
                // Execute the query
                ResultSet expiredMembershipsResultSet = expiredMembershipsStatement.executeQuery();

                // Processing the results for expired memberships
                System.out.println("Expired Memberships Report:");
                while (expiredMembershipsResultSet.next()) {
                    // Retrieveing data from the result set
                    int memberId = expiredMembershipsResultSet.getInt("membership_id");
                    String firstName = expiredMembershipsResultSet.getString("first_name");
                    String lastName = expiredMembershipsResultSet.getString("last_name");

                    // Displaying the data 
                    System.out.println("Member ID: " + memberId + ", Name: " + firstName + " " + lastName);
                }
                System.out.println(); 
            }

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
