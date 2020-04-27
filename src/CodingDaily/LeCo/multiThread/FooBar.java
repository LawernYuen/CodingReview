package CodingDaily.LeCo.multiThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class FooBar {
    private int n;
    private boolean turn = true;
    private Object lock = new Object();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (!turn) lock.wait();
            turn = false;
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            lock.notifyAll();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (turn) lock.wait();
            turn = true;
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            lock.notifyAll();
        }
    }
}
