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
    @Test
    public void givenEmployeePayrollSalaryUpdateMatches(){
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeeDetails> employeePayrollList =
                employeePayrollService.readEmployeeData(EmployeePayrollService.IOService.DB_IO);
        boolean result = employeePayrollService.updateEmployeeSalary("Sakshi",250000.0);
        Assertions.assertEquals(true,result);
    }

    @Test
    public void givenEmployeePayrollSalaryUpdateMatchesUsingPreparedStatement(){
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeeDetails> employeePayrollList =
                employeePayrollService.readEmployeeData(EmployeePayrollService.IOService.DB_IO);
        boolean result = employeePayrollService.updateEmployeeSalaryUsingPreparedStatement("Sakshi",750000.0);
        Assertions.assertEquals(true,result);
    }


    @Test
    public void givenRetrieveAllEmployee_ParticularDataRange(){
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeeDetails> employeeDetailsList =
                 employeePayrollService.readEmployeeParticularDataRage(EmployeePayrollService.IOService.DB_IO,70000.0);
        Assertions.assertEquals(8,employeeDetailsList.size());
    }
}
