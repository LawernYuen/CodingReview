import java.util.ArrayDeque;

public class QueueWithMax{
    private ArrayDeque<Data> data = new ArrayDeque<Data>();
    private ArrayDeque<Data> max = new ArrayDeque<Data>();
    private class Data{
        int val;
        int index;
        Data(int val, int index){
            this.val = val;
            this.index = index;
        }
    }
    private int currentIndex;

    public void push_back(int number){
        Data currentData = new Data(number, currentIndex);
        data.addLast(currentData);

        while (!max.isEmpty() && max.getLast().val < number)
            max.removeLast();
        max.addLast(currentData);
        currentIndex++;
    }

    // index���������Ϊ�˴Ӷ�����ɾ��Ԫ��ʱ�жϸ�Ԫ���Ƿ�Ϊmax������Ԫ��
    public void pop_front(){
        if (data.isEmpty())
            return;
        Data currentData = data.removeFirst();
        if (currentData.index == max.getFirst().index)
            max.removeFirst();
    }

    public int max(){
        if (max == null)
            return 0;
        return max.getFirst().val;
    }
}