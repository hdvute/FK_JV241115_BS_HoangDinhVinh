package ra.bussiness.entity;

import ra.bussiness.config.InputMethods;

import java.util.Date;

public class Employee {
    private int employeeId;
    private String employeeName;
    private String position;
    private double salary;
    private Date hireDate;
    private int departmentId;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String position, double salary, Date hireDate, int departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
        this.departmentId = departmentId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }


    public void inputData(){
        System.out.println("Nhập tên nhân viên");
        this.employeeName = InputMethods.getString();
        System.out.println("Nhập vị trí công việc");
        this.position = InputMethods.getString();
        System.out.println("Nhập mức lương");
        this.salary = InputMethods.getDouble();
        System.out.println("Nhập ngày tuyển dụng");
        this.hireDate = InputMethods.getDate();
        System.out.println("Nhập Id phòng ban");
        this.departmentId = InputMethods.getInteger();
    }
    public void displayData(){
        System.out.printf("|%-5d|%-20s|%-20s|%12.0f|%-12tF|%-5d|\n",
                this.employeeId,subStringName(this.employeeName,20),subStringName(this.position,20),
                this.salary,this.hireDate,this.departmentId);
        System.out.printf("+%s+%s+%s+%s+%s+%s+\n",
                "-".repeat(5),"-".repeat(20),"-".repeat(20),
                "-".repeat(12),"-".repeat(12),"-".repeat(5));
    }
    private String subStringName(String str, int max){
        return str.length()>max? (str.substring(0,max-3)+"...") : str;
    }

}
