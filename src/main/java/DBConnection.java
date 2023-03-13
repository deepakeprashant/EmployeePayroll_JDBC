import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DBConnection {
    String jdbcUrl = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
    String userName = "root";
    String password = "root";
    Connection conn;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath", e);
        }
        listDrivers();

        try {
            System.out.println("Connecting to database" + jdbcUrl);
            conn = DriverManager.getConnection(jdbcUrl, userName, password);
            System.out.println("Connection Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()){
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(" "+driverClass.getClass().getName());
        }
    }
}
