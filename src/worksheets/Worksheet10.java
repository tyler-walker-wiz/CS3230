package worksheets;

public class Worksheet10 {
}

class TestThread1 extends Thread {
    public void run() {
        System.out.println("Running");
    }

    public static void main(String[] args) {
        TestThread tt = new TestThread();
        tt.run();
    }
}

class TestThread extends Thread {
    private int count = 0;

    public void run() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        TestThread tt = new TestThread();
        tt.start();
        System.out.println(tt.getCount());
    }
}
