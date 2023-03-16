import java.util.List;

public class EmployeePayrollService {

    public enum IOService {CONSOLE_IO, FILE_IO , DB_IO}
    public List<EmployeeDetails> employeePayrollList;

    public List<EmployeeDetails> readEmployeeData(IOService dbIo) {
        if (dbIo.equals(IOService.DB_IO)){
            this.employeePayrollList = new EmployeePayrollDBService().readData();
        }
        displayEmployeeData(employeePayrollList );
        return employeePayrollList;
    }
    public void displayEmployeeData(List<EmployeeDetails> employeePayrollList){
        for (EmployeeDetails empData : this.employeePayrollList) {
            System.out.println(empData.id+" "+empData.name+" "+empData.department+" "
                    + empData.basic_pay+" "+empData.phone_number);
        }
    }

    public boolean updateEmployeeSalary(String name, double salary) {
        int result = new EmployeePayrollDBService().updateEmployeeData(name ,salary);
        if (result == 0){
            return false;
        }
        EmployeeDetails employeeDetails = this.getEmployeeData(name);
        if (employeeDetails != null){
            employeeDetails.basic_pay = salary;
        }
        displayEmployeeData(employeePayrollList);
        return true;
    }
    public boolean updateEmployeeSalaryUsingPreparedStatement(String name, double salary) {
        int result = new EmployeePayrollDBService().updateEmployeeDataUsePreparedStatement(name ,salary);
        if (result == 0){
            return false;
        }
        EmployeeDetails employeeDetails = this.getEmployeeData(name);
        if (employeeDetails != null){
            employeeDetails.basic_pay = salary;
        }
        displayEmployeeData(employeePayrollList);
        return true;
    }

    private EmployeeDetails getEmployeeData(String name) {
        return this.employeePayrollList.stream()
                .filter(n->n.name.equals(name))
                .findFirst()
                .orElse(null);
    }
}
