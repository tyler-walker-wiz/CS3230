package worksheets;

public class Junk{
    private   static    int    x;
    private   static    int    y;
    private   static    int    z;
    static{
        x  = 100;
        y = 10;
        z = x / y;
    }
    public Junk(){
        System.out.println(z);
    }
    public Junk(int x){
        this();
        System.out.println(x);
    }
    static{
        x = z;
        y = 2 * z;
        z *= 5;
    }
    public static void main(String[] args){
        new Junk(5);
    }
    static{
        x *= 2;
        y++;
        z = x * y;
    }
}
