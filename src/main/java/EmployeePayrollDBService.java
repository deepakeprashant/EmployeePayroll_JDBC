import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDBService {
    public List<EmployeeDetails> readData() {
        String sql = "select * from employee_payroll";
        List<EmployeeDetails> employeePayrollList = new ArrayList<>();
        try {
            Connection conn = new DBConnection().getConnection();
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String department = result.getString("department");
                String phone_number = result.getString("phone_number");
                double basic_pay = result.getDouble("basic_pay");
                employeePayrollList.add(new EmployeeDetails(id, name, department, phone_number, basic_pay));
            }
            conn.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeePayrollList;
    }

    public int updateEmployeeData(String name, double salary) {
        String sql= String.format("update employee_payroll set basic_pay = %.2f where name ='%s'",salary,name);
        try (Connection conn = new DBConnection().getConnection()){
            Statement statement = conn.createStatement();
            return statement.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0   ;
    }

    public int updateEmployeeDataUsePreparedStatement(String name, double salary) {
        String sql = "update employee_payroll set basic_pay = ? where name =?";
        try (Connection conn = new DBConnection().getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setDouble(1,salary);
            preparedStatement.setString(2,name);
            return preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public List<EmployeeDetails> readDataRange(double salary) {
        String sql= String.format("select * from employee_payroll where basic_pay<= 7000000");
        List<EmployeeDetails> employeePayrollList = new ArrayList<>();
        try {
            Connection conn = new DBConnection().getConnection();
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String department = result.getString("department");
                String phone_number = result.getString("phone_number");
                double basic_pay = result.getDouble("basic_pay");
                employeePayrollList.add(new EmployeeDetails(id, name, department, phone_number, basic_pay));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeePayrollList;
    }
}
