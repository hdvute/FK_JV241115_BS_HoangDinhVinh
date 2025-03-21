package ra.bussiness.dao;

import ra.bussiness.entity.Employee;

import java.util.List;

public interface IEmployeeDao extends IGenericDao<Employee, Integer> {
    List<Employee> filterByEmployeeName(String name);
    List<Employee> filterBestSalary();
    List<Employee> filterByDepartment(Integer id);
}
