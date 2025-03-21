package ra.bussiness.designimpl;

import ra.bussiness.dao.IDepartmentDao;
import ra.bussiness.daoimpl.DepartmentDaoImpl;
import ra.bussiness.design.IDepartmentDesign;
import ra.bussiness.entity.CountEmployee;
import ra.bussiness.entity.Department;

import java.util.List;

public class DepartmentDesignImpl implements IDepartmentDesign {
    private static final IDepartmentDao departmentDao = new DepartmentDaoImpl();
    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public Department findById(Integer id) {
        return departmentDao.findById(id);
    }

    @Override
    public void save(Department entity) {
        departmentDao.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        departmentDao.deleteById(id);
    }

    @Override
    public void toggleStatus(int id) {
        departmentDao.toggleStatus(id);
    }

    @Override
    public CountEmployee employeeWithMostDepartments() {
        return departmentDao.employeeWithMostDepartments();
    }

    @Override
    public boolean checkEmployeeInDepartmentById(int id) {
        return departmentDao.checkEmployeeInDepartmentById(id);
    }
}
