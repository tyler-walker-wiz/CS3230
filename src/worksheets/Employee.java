package worksheets;

public class Employee{
    private String name;
    public Employee(String name){
        this.name = name;
    }
    public String toString(){
        return name;
    }
    public static void change(Employee temp){
        temp = new Employee("Wally");
//        temp.name = "Wally";
    }
}
