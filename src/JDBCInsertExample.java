import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class JDBCInsertExample {

    public static void main(String[] args) {
        // Corrected JDBC URL
        String jdbcURL = "jdbc:mysql://localhost:3306/test"; // <- fixed this
        String username = "root"; // replace with your MySQL username
        String password = "Selciya&143"; // replace with your actual MySQL password

        try {
            // Connect to database
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("✅ Connected to database.");

            Statement stmt = connection.createStatement();

            // Create table if not exists
            String createTableSQL = "CREATE TABLE IF NOT EXISTS employee ("
                    + "empcode INT PRIMARY KEY, "
                    + "empname VARCHAR(50), "
                    + "empage INT, "
                    + "esalary DOUBLE)";
            stmt.executeUpdate(createTableSQL);
            System.out.println("✅ Table created.");

 
            String insertSQL1 = "INSERT INTO employee VALUES (101, 'Selciya', 25, 10000)";
            String insertSQL2 = "INSERT INTO employee VALUES (102, 'Kavya', 30, 20000)";
            String insertSQL3 = "INSERT INTO employee VALUES (103, 'Joe', 20, 40000)";
            String insertSQL4 = "INSERT INTO employee VALUES (104, 'Juana', 40, 80000)";
            String insertSQL5 = "INSERT INTO employee VALUES (105, 'Shameer', 25, 90000)";

            stmt.executeUpdate(insertSQL1);
            stmt.executeUpdate(insertSQL2);
            stmt.executeUpdate(insertSQL3);
            stmt.executeUpdate(insertSQL4);
            stmt.executeUpdate(insertSQL5);

            System.out.println(" Data inserted successfully.");

            connection.close();
        } catch (SQLException e) {
            System.out.println(" Error while connecting or executing SQL: " + e.getMessage());
        }
    }
}
