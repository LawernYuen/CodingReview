package CodingDaily.Practices;

public class MyThread1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            new ExtendedThread().start();
        System.out.println(Thread.currentThread().getName());
    }
}

class ExtendedThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
//1.�̳�Thread�࣬��дrun����
//        ÿ�δ���һ���µ��̣߳���Ҫ�½�һ��Thread����Ķ���
//        �����̣߳�new Thread���ࣨ��.start����
//        �����߳�ʵ�ʵ��õ��Ǹ���Thread�ղεĹ�����
