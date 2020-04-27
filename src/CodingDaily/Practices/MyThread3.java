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
//�Զ�����ʵ��Callable�ӿ�ʱ������ָ�����ͣ��÷��ͼ�����ֵ������
//        ÿ�δ���һ���µ��̣߳���Ҫ����һ���µ�Callable�ӿڵ�ʵ���ࡢ
//        ��������̣߳�
//        ��1������һ��Callable�ӿڵ�ʵ����Ķ���
//        ��2������һ��FutureTask���󣬴���Callable���͵Ĳ���
//public FutureTask(Callable<V> callable){����}
//        ��3������Thread�����صĲ���ΪRunnable�Ĺ���������Thread����
//        ��FutureTask��Ϊ��������
//public class FutureTask<V> implements RunnableFuture<V>
//public interface RunnableFuture<V> extends Runnable, Future<V>
//��λ�ȡ����ֵ��
//        ����FutureTask���get()����
