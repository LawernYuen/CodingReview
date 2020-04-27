package CodingDaily.LeCo.multiThread;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private Object lock = new Object();
    private int index = 1;
    boolean print0 = true;
    boolean print1 = false;
    boolean print2 = false;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock){
            for (int i = 0; i < n; i++) {
                if (!print0)
                    lock.wait();
                printNumber.accept(0);
                print0 = false;
                if ((index & 1) == 1)
                    print1 = true;
                else
                    print2 = true;
                lock.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock){
            for (int i = 0; i < n/2; i++){
                if (!print2)
                    lock.wait();
                if (!print2)
                    lock.wait();
                if (!print2)
                    lock.wait();
                printNumber.accept(index);
                print2 = false;
                print0 = true;
                index++;
                lock.notifyAll();
            }
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock){
            for (int i = 0; i < ((n&1)==1 ? n/2+1:n/2); i++){
                if (!print1)
                    lock.wait();
                if (!print1)
                    lock.wait();
                if (!print1)
                    lock.wait();
                printNumber.accept(index);
                print1 = false;
                print0 = true;
                index++;
                lock.notifyAll();
            }
        }
    }
}
