package ra.presentation;

import ra.bussiness.config.InputMethods;
import ra.bussiness.design.IEmployeeDesign;
import ra.bussiness.designimpl.EmployeeDesignImpl;
import ra.bussiness.entity.Employee;

import java.util.List;

public class EmployeeManager {
    private static final IEmployeeDesign employeeDesign = new EmployeeDesignImpl();
    public static void showEmployeeMenu(){
        while(true){
            System.out.println("******************** Employee Menu ********************");
            System.out.println("1. Danh sách nhân viên");
            System.out.println("2. Thêm mới nhân viên");
            System.out.println("3. Cập nhật thông tin nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Hiển thị danh sách nhân viên theo phòng ban");
            System.out.println("6. Tìm kiếm nhân viên theo tên");
            System.out.println("7. Hiển thị top 5 nhân viên có lương cao nhất");
            System.out.println("8. Quay lại");
            System.out.println("*******************************************************");

            System.out.println("Nhập lựa chọn của bạn: ");

            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    List<Employee> employees = employeeDesign.findAll();
                    if(employees.isEmpty()){
                        System.out.println("Danh sách trống");
                    }else{
                        System.out.printf("+%s+%s+%s+%s+%s+%s+\n",
                                "-".repeat(5),"-".repeat(20),"-".repeat(20),
                                "-".repeat(12),"-".repeat(12),"-".repeat(5));
                        System.out.printf("|%-5s|%-20s|%-20s|%12s|%-12s|%-5s|\n",
                                "E_ID","Name","Position","salary","Hire_date","D_ID");
                        System.out.printf("+%s+%s+%s+%s+%s+%s+\n",
                                "-".repeat(5),"-".repeat(20),"-".repeat(20),
                                "-".repeat(12),"-".repeat(12),"-".repeat(5));
                        employees.forEach(Employee::displayData);
                    }
                    break;
                case 2:
                    String YN = "A";
                    do{
                        YN = "A";
                        Employee employee = new Employee();
                        // inputData
                        employee.inputData();
                        // save data
                        employeeDesign.save(employee);
                        System.out.println("Lưu thành công !");
                        while (!YN.equals("Y")&&!YN.equals("N")&&!YN.equals("y")&&!YN.equals("n")) {
                            System.out.println("Bạn có muốn tiếp tục thêm phòng ban mới không (Y: có / N: không) :");
                            YN = InputMethods.getString();
                        }
                    }while(YN.equals("Y")||YN.equals("y"));
                    break;
                case 3:
                    System.out.println("Nhập ID nhân viên cần cập nhập");
                    int idEdit = InputMethods.getInteger();
                    Employee employeeEdit = employeeDesign.findById(idEdit);
                    if(employeeEdit==null){
                        System.err.println("Không tìm thấy Id");
                    }else{
                        System.out.println("Thông tin cũ");
                        System.out.printf("+%s+%s+%s+%s+%s+%s+\n",
                                "-".repeat(5),"-".repeat(20),"-".repeat(20),
                                "-".repeat(12),"-".repeat(12),"-".repeat(5));
                        System.out.printf("|%-5s|%-20s|%-20s|%12s|%-12s|%-5s|\n",
                                "E_ID","Name","Position","salary","Hire_date","D_ID");
                        System.out.printf("+%s+%s+%s+%s+%s+%s+\n",
                                "-".repeat(5),"-".repeat(20),"-".repeat(20),
                                "-".repeat(12),"-".repeat(12),"-".repeat(5));
                        employeeEdit.displayData();
                        System.out.println("Nhập thông tin mới");
                        employeeEdit.inputData();
                        employeeDesign.save(employeeEdit);
                        System.out.println("Cập nhập thông tin thành công");
                    }

                    break;
                case 4:
                    System.out.println("Nhập ID nhân viên cần xóa");
                    int idDelete = InputMethods.getInteger();
                    Employee employeeDelete = employeeDesign.findById(idDelete);
                    if(employeeDelete==null){
                        System.err.println("Không tìm thấy Id");
                    }else{
                        employeeDesign.deleteById(idDelete);
                        System.out.println("Xóa thành công");
                    }
                    break;
                case 5:
//                    5. Hiển thị danh sách nhân viên theo phòng ban
                    System.out.println("Nhập ID phòng ban ");
                    int id = InputMethods.getInteger();
                    List<Employee> listEmployeeByDepartment = employeeDesign.filterByDepartment(id);
                    if(listEmployeeByDepartment.isEmpty()){
                        System.err.println("Danh sách trống");
                    }else{
                        System.out.println("Danh sách nhân viên trong phòng ban này :");
                        System.out.printf("+%s+%s+%s+%s+%s+%s+\n",
                                "-".repeat(5),"-".repeat(20),"-".repeat(20),
                                "-".repeat(12),"-".repeat(12),"-".repeat(5));
                        System.out.printf("|%-5s|%-20s|%-20s|%12s|%-12s|%-5s|\n",
                                "E_ID","Name","Position","salary","Hire_date","D_ID");
                        System.out.printf("+%s+%s+%s+%s+%s+%s+\n",
                                "-".repeat(5),"-".repeat(20),"-".repeat(20),
                                "-".repeat(12),"-".repeat(12),"-".repeat(5));
                        listEmployeeByDepartment.forEach(employee -> employee.displayData());

                    }
                    break;
                case 6:
                    // tìm theo tên
                    System.out.println("Nhập tên nhân viên muốn tìm kiếm");
                    String nameSearch = InputMethods.getString();
                    List<Employee> listSearch = employeeDesign.filterByEmployeeName(nameSearch);
                    if(listSearch.isEmpty()){
                        System.err.println("Không tìm thấy kết quả phù hợp ");
                    }else{
                        System.out.println("Kết quả tìm kiếm được");
                        System.out.printf("+%s+%s+%s+%s+%s+%s+\n",
                                "-".repeat(5),"-".repeat(20),"-".repeat(20),
                                "-".repeat(12),"-".repeat(12),"-".repeat(5));
                        System.out.printf("|%-5s|%-20s|%-20s|%12s|%-12s|%-5s|\n",
                                "E_ID","Name","Position","salary","Hire_date","D_ID");
                        System.out.printf("+%s+%s+%s+%s+%s+%s+\n",
                                "-".repeat(5),"-".repeat(20),"-".repeat(20),
                                "-".repeat(12),"-".repeat(12),"-".repeat(5));
                        listSearch.forEach(Employee::displayData);
                    }
                    break;
                case 7:
                    //Hiển thị top 5 nhân viên có lương cao nhất
                    List<Employee> listBestSalary = employeeDesign.filterBestSalary();
                    System.out.println("Danh sách 5 nhân viên có lương cao nhất");
                    System.out.printf("+%s+%s+%s+%s+%s+%s+\n",
                            "-".repeat(5),"-".repeat(20),"-".repeat(20),
                            "-".repeat(12),"-".repeat(12),"-".repeat(5));
                    System.out.printf("|%-5s|%-20s|%-20s|%12s|%-12s|%-5s|\n",
                            "E_ID","Name","Position","salary","Hire_date","D_ID");
                    System.out.printf("+%s+%s+%s+%s+%s+%s+\n",
                            "-".repeat(5),"-".repeat(20),"-".repeat(20),
                            "-".repeat(12),"-".repeat(12),"-".repeat(5));
                    listBestSalary.forEach(Employee::displayData);
                    break;
                case 8:
                    // Thoát
                    return;
                default:
                    System.out.println("Nhập không đúng. Vui lòng nhập lại");
            }
        }
    }

}
