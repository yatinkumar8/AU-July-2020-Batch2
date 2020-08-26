/*
* 5) Establish a jdbc connection to a database and print first 10 rows of the table.
* */



import java.sql.*;

class JDBC {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/HOSPITAL";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "@yatin1997";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // Open a connection
            System.out.println("Connecting to a selected database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            // Execute a query
            System.out.println("Creating statement...");
            statement = connection.createStatement();

            String sql = "SELECT * FROM DOCTORS";
            ResultSet rs = statement.executeQuery(sql);
            // Extract data from result set
            while (rs.next()) {
                int id = rs.getInt("DOCTOR_ID");
                String name = rs.getString("DOCTOR_NAME");
                String address = rs.getString("DOCTOR_ADDRESS");
                int salary= rs.getInt("DOCTOR_SALARY");
                int departmentId= rs.getInt("DEPARTMENT_ID");
                System.out.format("%10d%16s%16s%10d%10d",id,name,address,salary,departmentId);
                System.out.println();
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null){
                    connection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Connection Closed");
    }
}