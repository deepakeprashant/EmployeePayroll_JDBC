public class EmployeeDetails {
    int id;
    String name,department,phone_number;
    double basic_pay;


    public EmployeeDetails(int id, String name, String department, String phone_number, double basic_pay) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.phone_number = phone_number;
        this.basic_pay = basic_pay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBasic_pay() {
        return basic_pay;
    }

    public void setBasic_pay(double basic_pay) {
        this.basic_pay = basic_pay;
    }
}
