package ra.bussiness.entity;

import ra.bussiness.config.InputMethods;
import ra.bussiness.design.IDepartmentDesign;
import ra.bussiness.designimpl.DepartmentDesignImpl;

public class Department {
    private int departmentId;
    private String departmentName;
    private Boolean departmentStatus;

    public Department() {
    }

    public Department(int departmentId, String departmentName, Boolean departmentStatus) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentStatus = departmentStatus;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Boolean getDepartmentStatus() {
        return departmentStatus;
    }

    public void setDepartmentStatus(Boolean departmentStatus) {
        this.departmentStatus = departmentStatus;
    }
    public void inputData(){
        //IDepartmentDesign departmentDesign = new DepartmentDesignImpl();
        System.out.println("Nhập tên phòng ban");
        this.departmentName = InputMethods.getString();
    }
    public void displayData(){
        System.out.printf("|%-5d|%-20s|%-20s|\n",this.departmentId,subStringName(this.departmentName,20), this.departmentStatus?"Hoạt động":"Ngừng hoặt động");
        System.out.printf("+%s+%s+%s+\n", "-".repeat(5),"-".repeat(20),"-".repeat(20));
    }
    private String subStringName(String str, int max){
        return str.length()>max? (str.substring(0,max-3)+"...") : str;
    }

}
