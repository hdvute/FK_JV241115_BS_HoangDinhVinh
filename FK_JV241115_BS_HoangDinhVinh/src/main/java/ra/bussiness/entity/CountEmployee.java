package ra.bussiness.entity;

public class CountEmployee {
    private int departmentId;
    private String departmentName;
    int count;

    public CountEmployee() {
    }

    public CountEmployee(int departmentId, String departmentName, int count) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.count = count;
    }

    public void displayData(){
        System.out.printf("|%-5d|%-20s|%-10d|\n",this.departmentId,subStringName(this.departmentName,20), this.count);
        System.out.printf("+%s+%s+%s+\n", "-".repeat(5),"-".repeat(20),"-".repeat(10));
    }
    private String subStringName(String str, int max){
        return str.length()>max? (str.substring(0,max-3)+"...") : str;
    }


}
