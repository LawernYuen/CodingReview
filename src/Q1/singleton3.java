package Q1;

public class singleton3{
    private singleton3(){}
    private static singleton3 instance = new singleton3();
    //直接在运行这个类的时候进行一次loading，相比静态类多了内存常驻，但是没有lazy loading
    public static singleton3 getInstance(){
        return instance;
    }
}