package ra.presentation;

import ra.bussiness.config.InputMethods;
import ra.bussiness.design.IDepartmentDesign;
import ra.bussiness.designimpl.DepartmentDesignImpl;
import ra.bussiness.entity.CountEmployee;
import ra.bussiness.entity.Department;

import java.util.List;

public class DepartmentManager {
    private static final IDepartmentDesign departmentDesign = new DepartmentDesignImpl();
    public static void showDepartmentMenu(){
        while(true){
            System.out.println("******************** Department Menu ********************");
            System.out.println("1. Danh sách phòng ban");
            System.out.println("2. Thêm mới phòng ban");
            System.out.println("3. Cập nhật thông tin phòng ban");
            System.out.println("4. Xóa phòng ban");
            System.out.println("5. Hiển thị phòng ban có nhiều nhân viên nhất");
            System.out.println("6. Quay lại");
            System.out.println("*******************************************************");

            System.out.println("Nhập lựa chọn của bạn: ");

            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    List<Department> departments = departmentDesign.findAll();
                    if(departments.isEmpty()){
                        System.out.println("Danh sách trống");
                    }else{
                        System.out.printf("+%s+%s+%s+\n", "-".repeat(5),"-".repeat(20),"-".repeat(20));
                        System.out.printf("|%-5s|%-20s|%-20s|\n","ID","Name","Status");
                        System.out.printf("+%s+%s+%s+\n", "-".repeat(5),"-".repeat(20),"-".repeat(20));
                        departments.forEach(Department::displayData);
                    }
                    break;
                case 2:
                    String YN = "A";
                    do{
                        YN = "A";
                        Department department = new Department();
                        // inputData
                        department.inputData();
                        // save data
                        departmentDesign.save(department);
                        System.out.println("Lưu thành công !");
                        while (!YN.equals("Y")&&!YN.equals("N")&&!YN.equals("y")&&!YN.equals("n")) {
                            System.out.println("Bạn có muốn tiếp tục thêm phòng ban mới không (Y: có / N: không) :");
                            YN = InputMethods.getString();
                        }
                    }while(YN.equals("Y")||YN.equals("y"));
                    break;
                case 3:
                    // cập nhập thông tin
                    System.out.println("Nhập Id phòng ban muốn cập nhập");
                    int idEdit = InputMethods.getInteger();
                    Department departmentEdit = departmentDesign.findById(idEdit);
                    if(departmentEdit==null){
                        System.out.println("Không tìm thấy id");
                    }else{
                        // thông tin cũ
                        System.out.printf("+%s+%s+%s+\n", "-".repeat(5),"-".repeat(20),"-".repeat(20));
                        System.out.printf("|%-5s|%-20s|%-20s|\n","ID","Name","Status");
                        System.out.printf("+%s+%s+%s+\n", "-".repeat(5),"-".repeat(20),"-".repeat(20));
                        departmentEdit.displayData();
                        System.out.println("Nhập thông tin mới: ");
                        departmentEdit.inputData();
                        departmentDesign.save(departmentEdit);
                        String YN2 = "A";
                        while (!YN2.equals("Y")&&!YN2.equals("N")&&!YN2.equals("y")&&!YN2.equals("n")) {
                            System.out.println("Bạn có muốn thay đổi trạng thái phòng ban không (Y: có / N: không) :");
                            YN2 = InputMethods.getString();
                        }
                        if(YN2.equals("Y")||YN2.equals("y")){
                            departmentDesign.toggleStatus(idEdit);
                        }
                        System.out.println("Cập nhập thông tin thành công");
                    }

                    break;
                case 4:
                    System.out.println("Nhập ID phòng ban muốn xóa");
                    int idDelete = InputMethods.getInteger();
                    Department departmentDelete = departmentDesign.findById(idDelete);
                    if(departmentDelete==null){
                        System.err.println("Không tìm thấy ID");
                    }else{
                        departmentDesign.deleteById(idDelete);
                        System.out.println("Xóa thành công");
                    }


                    break;
                case 5:
                    // 5. Hiển thị phòng ban có nhiều nhân viên nhất
                    CountEmployee countEmployee = departmentDesign.employeeWithMostDepartments();
                    if(countEmployee==null){
                        System.err.println("Danh sách trống");
                    }else{
                        System.out.println(" Phòng ban có nhiều nhân viên nhất ");
                        System.out.printf("+%s+%s+%s+\n", "-".repeat(5),"-".repeat(20),"-".repeat(10));
                        System.out.printf("|%-5s|%-20s|%-20s|\n","ID","Name","Quantity");
                        System.out.printf("+%s+%s+%s+\n", "-".repeat(5),"-".repeat(20),"-".repeat(10));
                        countEmployee.displayData();
                    }
                    break;
                case 6:
                    // Thoát
                    return;
                default:
                    System.out.println("Nhập không đúng. Vui lòng nhập lại");
            }
        }
    }
}
