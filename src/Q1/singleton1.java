package Q1;

public class singleton1{ //simple
    private singleton1(){} //通过私有化构造方法保证单例
    private static singleton1 instance; //提供私有静态对象保证实例的唯一性
    public static singleton1 getInstance(){
        if(instance==null){
            instance = new singleton1();
        }
        return instance;
    }
}