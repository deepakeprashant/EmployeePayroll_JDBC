import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeePayrollServiceTest {
    @Test
    public void givenRetrieveEmployeePayrollData_FromDB(){
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeeDetails> employeePayrollList =
                employeePayrollService.readEmployeeData(EmployeePayrollService.IOService.DB_IO);
        Assertions.assertEquals(8,employeePayrollList.size());
    }
}
