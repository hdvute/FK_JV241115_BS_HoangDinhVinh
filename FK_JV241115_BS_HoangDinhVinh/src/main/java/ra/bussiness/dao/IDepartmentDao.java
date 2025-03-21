package ra.bussiness.dao;

import ra.bussiness.entity.CountEmployee;
import ra.bussiness.entity.Department;

public interface IDepartmentDao extends IGenericDao<Department, Integer> {
    void toggleStatus(int id);
    CountEmployee employeeWithMostDepartments();
    boolean checkEmployeeInDepartmentById(int id);
}
