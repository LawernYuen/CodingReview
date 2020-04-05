package CodingDaily.Practices;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread4 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        ThreadPoolDemo demo = new ThreadPoolDemo();
        for (int i = 1; i <= 5; i++)
            pool.submit(demo);
        pool.shutdown();
    }
}

class ThreadPoolDemo implements Runnable{
    private int i = 0;

    @Override
    public void run() {
        while (i <= 20)
            System.out.println(Thread.currentThread().getName() + "--" + ++i);
    }
}