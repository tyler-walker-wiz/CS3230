package worksheets;

public class Worksheet3 {
    public static void main(String[] args) {
        char c = 'k';
        System.out.println(Character.getNumericValue(c));
        Disk d = new SidedDisk(2);
        Disk cd = new SidedDisk(2);
        if(d.canPlay(d))
            System.out.println("Can Play");
        else
            System.out.println("Can not Play");

//        Beta myBeta = new Gamma();
//        Stuff more = new MoreStuff();
//        more.firstMethod();
//        more.secondMethod();
//        more.thirdMethod();
//        more.lastMethod();
    }
}

class Disk {
    public boolean canPlay(Disk d) {
        return d != null && d.getClass().equals(this.getClass()) && !this.equals(d);
    }
}

class SpottedDisk extends Disk {
    private int spots;
    public SpottedDisk(int spots){
        this.spots = spots;
    }
    public boolean canPlay(Disk d) {
        return super.canPlay(d) && spots == ((SpottedDisk) d).spots;
    }
}

class FancyDisk extends Disk {
}

class SidedDisk extends FancyDisk {
    private int sides;
    public SidedDisk(int sides){
        this.sides = sides;
    }
    public boolean canPlay(Disk d) {
        return super.canPlay(d) && sides == ((SidedDisk) d).sides;
    }
}

class ColoredDisk extends FancyDisk {
    private String color;
    public ColoredDisk(String color){
        this.color = color;
    }
    public boolean canPlay(Disk d) {
        return super.canPlay(d) && color.equals(((ColoredDisk) d).color);
    }
}

class Alpha {
    public int counter;
}
class Beta extends Alpha{
    public int total;
}
class Gamma extends Beta{
    public int max;
}

abstract class Stuff{
    abstract public void firstMethod();
    public void secondMethod(){}
    public void thirdMethod(){}
}

class MoreStuff extends Stuff{
    public void firstMethod(){}
    public void secondMethod(){}
    public void lastMethod(){}
}