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
