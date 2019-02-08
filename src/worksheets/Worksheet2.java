package worksheets;

public class Worksheet2 {
    public static void main(String[] args) {
//        Foo f1 = new Foo(2, 3);
//        Foo f2 = new Foo(3, 4);
//        f1.bar(f2);
        Employee e = new Employee("Dilbert");
        Employee.change(e);
        System.out.println(e);

        System.out.println("Ran fine.");
    }
}