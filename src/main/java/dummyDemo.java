public class dummyDemo {

    public void method1(){
        System.out.println("HIII");
    method2();
    }
    public void method2(){
        try {
            System.out.println(5 / 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        dummyDemo dummyDemo = new dummyDemo();
        dummyDemo.method1();
//        dummyDemo.method2();

    }
}
