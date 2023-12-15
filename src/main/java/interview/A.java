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
        i = 1;    // 1
        a.x = 12;    //x= 12
        a.y = 13;    // y=  13
        a= new A (2);
        a.x = 21;      // не возвращается
        a.y = 22;    //y = 22
    }

    public static void main(String[] args) {
        A a = new A (1);     // number = 1
        a.x =1;        //1
        a.y =2;         //2
        int z=3;        //3

        A.doIt(z,a);   // Z=3      А = {y = 2 , number = 1 , x= 1}
        System.out.println(a);             // a="1"
        System.out.println(a.namber);       //a=1
        System.out.println(a.x);           // x= 12
        System.out.println(a.y);           //y = 22
        System.out.println(z);             //z = 3


    }


}
