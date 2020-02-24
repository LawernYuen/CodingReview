package Q1;

public class singleton4{
    private singleton4(){}
    private static class singletonHolder{
        private static singleton4 instance = new singleton4();
    }//使用静态内部类，不会在单例加载时加载，而且线程安全
    public static singleton4 getInstance(){
        return singletonHolder.instance;
    }
}