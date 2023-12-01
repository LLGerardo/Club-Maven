package GUI.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnector {
    public static Connection connect() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/your_database_name";
        String username = "your_username";
        String password = "your_password";
        return DriverManager.getConnection(url, username, password);
    }

    public static void insertData() {
        try (Connection connection = connect()) {
            String sql = "INSERT INTO club_member (\"First name\", \"Last name\", gender, date_of_birth, address, Phone, email, preferredContactMethod, membership_length, start_date, End_date, notes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, GUIPanel.CUST_FIRSTNAME.getText());
                statement.setString(2, GUIPanel.CUST_LASTNAME.getText());
                statement.setString(3, GUIPanel.GENDER_CHOICE.getSelectedItem().toString());
                statement.setString(4, GUIPanel.ENTER_DOB.getText());
                statement.setString(5, GUIPanel.ADDRESS.getText());
                statement.setString(6, GUIPanel.PHONE.getText());
                statement.setString(7, GUIPanel.EMAIL.getText());
                statement.setString(8, GUIPanel.PREFERRED_CONTACT_METHOD.getText());
                statement.setString(9, GUIPanel.MEM_LENS.getSelectedItem().toString());
                statement.setString(10, GUIPanel.ENTER_START.getText());
                statement.setString(11, GUIPanel.END_DATE.getText());
                statement.setString(12, GUIPanel.NOTES.getText());

                int rowsInserted = statement.executeUpdate();
                System.out.println(rowsInserted + " row(s) inserted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

