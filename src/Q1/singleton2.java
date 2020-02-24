package Q1;

public class singleton2{ //带线程安全的简单模式
    private singleton2(){}
    private static singleton2 instance;
    public static synchronized singleton2 getInstance(){
        if(instance == null){
            instance = new singleton2();
        }
        return instance;
    }
}