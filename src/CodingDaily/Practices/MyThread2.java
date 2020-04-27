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
//2.ʵ��Runnable�ӿڣ���дrun����
//        ���۴������ٸ��̣߳�ֻ��Ҫ����һ��ʵ��Runnable�ӿ���Ķ���
//        �����̣߳�new Thread��Runnable�ӿ�ʵ����Ķ���.start()
//        �����̵߳��õ���Thread��Runable���Ͳ����Ĺ�����
