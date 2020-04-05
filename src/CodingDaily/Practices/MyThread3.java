package CodingDaily.Practices;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyThread3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 10; i++){
            Callable<Integer> implCallable = new ImplCallable();
            FutureTask<Integer> futureTask = new FutureTask<>(implCallable);
            new Thread(futureTask).start();
            System.out.println(Thread.currentThread().getName() + "--" + futureTask.get());
        }
        System.out.println(Thread.currentThread().getName());
    }
}

class ImplCallable implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 0; i < 10; i++)
            result += i;
        System.out.println(Thread.currentThread().getName());
        return result;
    }
}