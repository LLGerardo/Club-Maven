package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Statement;
import java.time.LocalDate;

import Creation.Member;

/*This class handles databse connection to the project */
public class Databaseconnector {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres?currentSchema=syseng";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "Tofunmi2002!";

    /*This method coonects DB to project by getting the Driver manager */
    public static Connection getConnection() throws SQLException {
        try {
            //don't know what this is but saw it on stack overflow and 
            //it solved the issue with db not connecting
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL JDBC Driver not found.", e);
        }
    }
    /*This method runs a sql query that fills in a new members information into the dtatbase table. */
    public static void insertMember(Member member) {
        //query that enters information of member into table
        String sql = "INSERT INTO members (first_name, last_name, username, date_of_birth, address, phone, email, " +
                "preferred_contact_method, creation_date, is_active_member, membership_plan, membership_end_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        /*Getter methods from Member class are called to insert info into  */
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS)) {
            /*prepared staements are called to execute sql query and each set method that corresponds
            with a column sets values into the cloumn using a getter methods from the Member class.*/
            preparedStatement.setString(1, member.getFirstName());
            preparedStatement.setString(2, member.getLastName());
            preparedStatement.setString(3, member.getUsername());
            preparedStatement.setDate(4, java.sql.Date.valueOf(member.getDateOfBirth()));
            preparedStatement.setString(5, member.getAddress());
            preparedStatement.setString(6, member.getPhone());
            preparedStatement.setString(7, member.getEmail());
            preparedStatement.setString(8, member.getPreferredContactMethod());
            preparedStatement.setDate(9, java.sql.Date.valueOf(member.getCreationDate()));
            preparedStatement.setBoolean(10, member.isActiveMember());
            preparedStatement.setString(11, member.getMembershipPlan());
            LocalDate creationDate = member.getCreationDate();
            int membershipPlanDuration = parseMembershipPlan(member.getMembershipPlan());
            //end date calculation using membership plan and creationdate
            LocalDate membershipEndDate = creationDate.plusMonths(membershipPlanDuration);
            preparedStatement.setDate(12, java.sql.Date.valueOf(membershipEndDate));


            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating member failed, no rows affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static int parseMembershipPlan(String membershipPlan) {
        // Implementing logic to parse the membership plan string and return the duration as an integer
        return Integer.parseInt(membershipPlan.replaceAll("\\D+", ""));
    }
}
