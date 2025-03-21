package ra.bussiness.designimpl;

import ra.bussiness.dao.IEmployeeDao;
import ra.bussiness.daoimpl.EmployeeDaoImpl;
import ra.bussiness.design.IEmployeeDesign;
import ra.bussiness.entity.Employee;

import java.util.List;

public class EmployeeDesignImpl implements IEmployeeDesign {
    private static final IEmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeDao.findById(id);
    }

    @Override
    public void save(Employee entity) {
        employeeDao.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        employeeDao.deleteById(id);
    }

    @Override
    public List<Employee> filterByEmployeeName(String name) {
        return employeeDao.filterByEmployeeName(name);
    }

    @Override
    public List<Employee> filterBestSalary() {
        return employeeDao.filterBestSalary();
    }

    @Override
    public List<Employee> filterByDepartment(Integer id) {
        return employeeDao.filterByDepartment(id);
    }
}
