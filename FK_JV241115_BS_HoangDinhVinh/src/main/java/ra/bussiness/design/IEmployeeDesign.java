package ra.bussiness.design;

import ra.bussiness.entity.Employee;

import java.util.List;

public interface IEmployeeDesign extends IGenericDesign<Employee, Integer> {
    List<Employee> filterByEmployeeName(String name);
    List<Employee> filterBestSalary();
    List<Employee> filterByDepartment(Integer id);
}
