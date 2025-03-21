package ra.bussiness.design;

import ra.bussiness.entity.CountEmployee;
import ra.bussiness.entity.Department;

public interface IDepartmentDesign extends IGenericDesign<Department, Integer> {
    void toggleStatus(int id);
    CountEmployee employeeWithMostDepartments();
    boolean checkEmployeeInDepartmentById(int id);
}
