import java.util.List;

public class EmployeePayrollService {

    public List<EmployeeDetails> readEmployeeData(IOService dbIo) {
        if (dbIo.equals(IOService.DB_IO)){
            this.employeePayrollList = new EmployeePayrollDBService().readData();
        }
        return employeePayrollList;
    }

    public enum IOService {CONSOLE_IO, FILE_IO , DB_IO}
    public List<EmployeeDetails> employeePayrollList;
}
