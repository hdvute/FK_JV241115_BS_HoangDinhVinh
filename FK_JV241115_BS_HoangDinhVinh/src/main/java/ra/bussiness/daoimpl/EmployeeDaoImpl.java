package ra.bussiness.daoimpl;

import ra.bussiness.config.ConnectionDB;
import ra.bussiness.dao.IEmployeeDao;
import ra.bussiness.entity.Department;
import ra.bussiness.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

public class EmployeeDaoImpl implements IEmployeeDao {
    @Override
    public List<Employee> findAll() {
        Connection conn = ConnectionDB.openConnection();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from employee");
            ResultSet rs = ps.executeQuery();
            List<Employee> list = new ArrayList<>();
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
            return list;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return List.of();
    }

    @Override
    public Employee findById(Integer id) {
        Connection conn = ConnectionDB.openConnection();
        try{
            PreparedStatement pre = conn.prepareStatement("select * from  employee where employee_id=?");
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                Employee employee = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("employee_name"),
                        rs.getString("position"),
                        rs.getDouble("salary"),
                        rs.getDate("hire_date"),
                        rs.getInt("department_id")
                );
                return employee;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return null;
    }

    @Override
    public void save(Employee entity) {
        Connection conn = ConnectionDB.openConnection();
        PreparedStatement pre = null;
        try{
            // Kiem tra co ton tai Id khong
            if(findById(entity.getEmployeeId())==null){
                // add
                pre = conn.prepareStatement("INSERT INTO Employee (employee_name, position, salary, hire_date, department_id)" +
                        "VALUES (?, ?, ?, ?, ?)");
                pre.setString(1, entity.getEmployeeName());
                pre.setString(2, entity.getPosition());
                pre.setDouble(3, entity.getSalary());
                pre.setDate(4,new Date(entity.getHireDate().getTime()));
                pre.setInt(5, entity.getDepartmentId());
            }else{
                // update (edit)
                pre = conn.prepareStatement("update Employee set employee_name = ?, position = ?, salary = ?, hire_date = ?, department_id = ? where employee_id = ?");
                pre.setString(1, entity.getEmployeeName());
                pre.setString(2, entity.getPosition());
                pre.setDouble(3, entity.getSalary());
                pre.setDate(4,new Date(entity.getHireDate().getTime()));
                pre.setInt(5, entity.getDepartmentId());
                pre.setInt(6, entity.getEmployeeId());
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
            PreparedStatement pre = conn.prepareStatement("delete from Employee where employee_id=?");
            pre.setInt(1, id);
            pre.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public List<Employee> filterByEmployeeName(String name) {
        Connection conn = ConnectionDB.openConnection();
        try{
            PreparedStatement pre = conn.prepareStatement("select * from Employee where employee_name like ?");
            pre.setString(1,"%"+name+"%");
            ResultSet rs = pre.executeQuery();
            List<Employee> employees = new ArrayList<>();
            while(rs.next()){
                Employee employee = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("employee_name"),
                        rs.getString("position"),
                        rs.getDouble("salary"),
                        rs.getDate("hire_date"),
                        rs.getInt("department_id")
                );
                employees.add(employee);
            }
            return employees;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return List.of();
    }

    @Override
    public List<Employee> filterBestSalary() {
        Connection conn = ConnectionDB.openConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(
                    "select * from Employee ORDER BY salary DESC LIMIT 5");
            ResultSet rs = pre.executeQuery();
            List<Employee> employees = new ArrayList<>();
            while(rs.next()){
                Employee employee = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("employee_name"),
                        rs.getString("position"),
                        rs.getDouble("salary"),
                        rs.getDate("hire_date"),
                        rs.getInt("department_id")
                );
                employees.add(employee);
            }
            return employees;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return List.of();
    }

    @Override
    public List<Employee> filterByDepartment(Integer id) {
        Connection conn = ConnectionDB.openConnection();
        try{
            PreparedStatement pre = conn.prepareStatement(
                    "select * from Employee where department_id=?");
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            List<Employee> employees = new ArrayList<>();
            while(rs.next()){
                Employee employee = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("employee_name"),
                        rs.getString("position"),
                        rs.getDouble("salary"),
                        rs.getDate("hire_date"),
                        rs.getInt("department_id")
                );
                employees.add(employee);
            }
            return employees;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return List.of();
    }
}
