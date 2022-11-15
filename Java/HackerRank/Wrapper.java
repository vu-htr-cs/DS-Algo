public class Wrapper {
    public static void run(){
        int a=123;
        Object o=a;
        Integer b=Integer.valueOf(123);// lop nay do trinh bien dich autoboxing sang object Wrapper cua framework
        System.out.println(b);// Object cua lop Wrapper se tra ve gia tri nguyen thuy cua lop do
    }
}
