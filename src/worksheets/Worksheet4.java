package worksheets;

import java.util.*;

public class Worksheet4 implements Comparable<Worksheet4> {
    public static void main(String[] args) {
        Part p = new Part(2, 12.96);
        Part p1 = new Part(2,45.12);
        Part p2 = new Part(2,87.00);
        Part p3 = new Part(2,100.38);
        Part p4 = new Part(2,253.93);
        Part p6 = new Part(10, 34.12);
        Part p7 = new Part(10,34.98);
        Part p8 = new Part(10,294.23);
        Part p9 = new Part(10,3467.89);
        Part p10 = new Part(10,123.32);

        Part[] plist = new Part[]{p,p1,p8,p3,p10,p6,p7,p2,p9,p4};
        for(int i = 0; i < plist.length; i++){
            System.out.println(plist[i].category + ", " + plist[i].cost);
        }
        System.out.println("\nSorted: ");
        Arrays.sort(plist);
        for(int i = 0; i < plist.length; i++){
            System.out.println(plist[i].category + ", " + plist[i].cost);
        }
    }

    @Override
    public int compareTo(Worksheet4 o) {
        return 0;
    }
}


interface Fee {
    public void method();
}

class Bar implements Fee {
    public void method() {
    }

    public void someStuff() {

    }
}

class Part implements Comparable<Part> {
    public int category;
    public double cost;
    public Part(int category, double cost){
        this.category = category;
        this.cost = cost;
    }
    public int compareTo(Part p){
        int result = Integer.compare(this.category, p.category);
        if(result == 0)
            result = Double.compare(this.cost, p.cost);
        return result;
    }
}