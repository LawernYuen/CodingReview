package Q1;

enum singleton5{
    INSTANCE;
    public void othermethods(){}
}
//1.自由序列化 序列化是指保存在内存中的各种对象的状态（也就是实例变量，
//  不是方法），并且可以把保存的对象状态再读出来
//2.保证只有一个实例
//3.线程安全

/* 调用
public class hello{
    public static void main(String[] args){
        singleton5.INSTANCE.othermethods();
    }
}
*/
