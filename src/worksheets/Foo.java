package worksheets;

public class Foo {
    private int part1;
    private int part2;

    public Foo(int part1, int part2) {
        this.part1 = part1;
        this.part2 = part2;
    }

    public Foo bar(Foo f) {
        return new Foo(part1 * f.part1, part2 * f.part2);
    }
}

//class Fooer{
//    private int count;
//    private String name;
//    public boolean running;
//    public Fooer(int count, String name){
//        this.count = count;
//        this.name = name;
//    }
//    public String getName();
//    protected void bar();
//    private char myHelper(int arg);
//}

//class Person{
//    private String name;
//    public Person(String name){
//        this.name = name;
//    }
//}
//
//class Employee extends Person{
//    private int id;
//    public Employee(String name){
//        super(name);
//    }
//}

class Person{
    private String name;
    private Address address;
    public Person(String name, String street, String city){
        this.name = name;
        this.address = new Address(street,city);
    }
}

class Address{
    private String street;
    private String city;
    public Address(String street, String city){
        this.street = street;
        this.city = city;
    }
}

//class MotherBoard{
//    private String model;
//    private CPU cpu;
//    public MotherBoard(String model, double speed){
//        this.model = model;
//        this.cpu = new CPU(this, speed);
//    }
//}
//class CPU{
//    private double speed;
//    private MotherBoard mb;
//    public CPU(MotherBoard mb, double speed){
//        this.speed = speed;
//        this.mb = mb;
//    }
//}
