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

    // index这个属性是为了从队列中删除元素时判断该元素是否为max里的最大元素
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