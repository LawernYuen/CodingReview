package Q1;

public class singleton6{
    private singleton6(){}
    private volatile static singleton6 instance;
    //一旦一个共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义：
    //1）保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
    //2）禁止进行指令重排序。
    public static singleton6 getInstance(){
        if(instance == null){
            synchronized (singleton6.class){
                if(instance == null){
                    instance = new singleton6();
                }
            }
        }
        return instance;
    }
}