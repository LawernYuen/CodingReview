package CodingDaily.Practices;

public class MyThread2 {
    public static void main(String[] args) {
        Runnable implRunnable = new ImplRunnable();
        for (int i = 0; i < 10; i++)
            new Thread(implRunnable).start();
        System.out.println(Thread.currentThread().getName());
    }
}

class ImplRunnable implements Runnable{
    private volatile int i = 0;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--" + ++i);
    }
}
//2.实现Runnable接口，重写run方法
//        不论创建多少个线程，只需要创建一个实现Runnable接口类的对象
//        启动线程，new Thread（Runnable接口实现类的对象）.start()
//        创建线程调用的是Thread类Runable类型参数的构造器
