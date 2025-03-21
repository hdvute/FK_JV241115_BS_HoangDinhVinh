package ra.presentation;

import ra.bussiness.config.InputMethods;

public class StoredProcedure {
    public static void main(String[] args) {
        showMainMenu();
    }
    public static void showMainMenu(){
        while(true){
            System.out.println("******************** HR-MANAGEMENT ********************");
            System.out.println("1. Quản lý phòng ban");
            System.out.println("2. Quản lý nhân viên");
            System.out.println("3. Thoát");
            System.out.println("******************************************************");

            System.out.println("Nhập lựa chọn của bạn: ");

            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    DepartmentManager.showDepartmentMenu();
                    break;
                case 2:
                    EmployeeManager.showEmployeeMenu();
                    break;
                case 3:
                    // thoat
                    System.out.println("Bạn đã thoát khỏi chương trình");
                    return;
                default:
                    System.out.println("Nhập không đúng. Vui lòng nhập lại");
            }
        }
    }
}
