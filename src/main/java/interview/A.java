package interview;

public class A {
    private static int y;
    private final int namber;
    private int x;

    public A(int namber) {
        this.namber = namber;
    }

    @Override
    public String toString() {
        return String.valueOf(namber);
    }

    private static void doIt(int i, A a) {
        i = 1;
        a.x = 12;
        a.y = 13;
        a= new A (2);
        a.x = 21;
        a.y = 22;
    }

    public static void main(String[] args) {
        A a = new A (1);
        a.x =1;
        a.y =2;
        int z=3;

        A.doIt(z,a);
        System.out.println(a);
        System.out.println(a.namber);
        System.out.println(a.x);
        System.out.println(a.y);
        System.out.println(z);


    }


}
