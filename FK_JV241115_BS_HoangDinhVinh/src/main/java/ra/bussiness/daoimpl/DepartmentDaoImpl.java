package ra.bussiness.daoimpl;

import ra.bussiness.config.ConnectionDB;
import ra.bussiness.dao.IDepartmentDao;
import ra.bussiness.entity.CountEmployee;
import ra.bussiness.entity.Department;
import ra.bussiness.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements IDepartmentDao {
    @Override
    public List<Department> findAll() {
        Connection conn = ConnectionDB.openConnection();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from departments");
            ResultSet rs = ps.executeQuery();
            List<Department> list = new ArrayList<>();
            while(rs.next()){
                Department department = new Department(
                        rs.getInt("department_id"),
                        rs.getString("department_name"),
                        rs.getBoolean("department_status")
                );
                list.add(department);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return List.of();
    }

    @Override
    public Department findById(Integer id) {
        Connection conn = ConnectionDB.openConnection();
        try{
            PreparedStatement pre = conn.prepareStatement("select * from departments where department_id=?");
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                Department department = new Department(
                        rs.getInt("department_id"),
                        rs.getString("department_name"),
                        rs.getBoolean("department_status")
                );
                return department;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return null;
    }

    @Override
    public void save(Department entity) {
        Connection conn = ConnectionDB.openConnection();
        PreparedStatement pre = null;
        try{
            // Kiem tra co ton tai Id khong
            if(findById(entity.getDepartmentId())==null){
                // add
                pre = conn.prepareStatement("insert into departments(department_name) values(?)");
                pre.setString(1, entity.getDepartmentName());
            }else{
                // update (edit)
                pre = conn.prepareStatement("update departments set department_name=? where department_id=?");
                pre.setString(1, entity.getDepartmentName());
                pre.setInt(2, entity.getDepartmentId());
            }
            pre.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void deleteById(Integer id) {
        Connection conn = ConnectionDB.openConnection();
        try{
            PreparedStatement pre = conn.prepareStatement("delete from departments where department_id=?");
            pre.setInt(1, id);
            pre.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void toggleStatus(int id) {
        Connection conn = ConnectionDB.openConnection();
        try{
            PreparedStatement pre = conn.prepareStatement("update departments set department_status = !department_status where department_id=?");
            pre.setInt(1, id);
            pre.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public CountEmployee employeeWithMostDepartments() {
        Connection conn = ConnectionDB.openConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(
                    "select d.department_id, d.department_name, count(e.employee_id) AS total_employees\n" +
                            "from Departments d\n" +
                            "JOIN Employee e ON d.department_id = e.department_id\n" +
                            "GROUP BY d.department_id, d.department_name\n" +
                            "ORDER BY total_employees DESC\n" +
                            "LIMIT 1;");
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                CountEmployee countEmployee = new CountEmployee(
                        rs.getInt("department_id"),
                        rs.getString("department_name"),
                        rs.getInt("total_employees")
                );
                return countEmployee;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return null;
    }

    @Override
    public boolean checkEmployeeInDepartmentById(int id) {
        Connection conn = ConnectionDB.openConnection();
        List<Employee> list = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from employee where department_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Employee employee = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("employee_name"),
                        rs.getString("position"),
                        rs.getDouble("salary"),
                        rs.getDate("hire_date"),
                        rs.getInt("department_id")
                );
                list.add(employee);
            }
            if(list.isEmpty()){
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return true;
    }
}
