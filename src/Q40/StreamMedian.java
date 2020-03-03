import java.util.PriorityQueue;
import java.util.Comparator;

public class StreamMedian{
    // default min heap
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    // max heap
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,
            new Comparator<Integer>(){
        public int compare(Integer i1, Integer i2){
            return i2 - i1;
        }
            });

    public void Insert(Integer num){
        // even size, add to minheap
        if ((minHeap.size()+maxHeap.size() & 1) == 0){
            // when num is smaller than peak of maxheap, add num to
            // maxheap first then get the max of maxheap to minheap
            if (!maxHeap.isEmpty() && num<maxHeap.peek()){
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        }
        // odd size, add to maxheap
        else {
            if (!minHeap.isEmpty() && num>minHeap.peek()){
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public double GetMedian(){
        if (minHeap.size() + maxHeap.size() == 0)
            throw new RuntimeException();
        double median;
        if ((minHeap.size()+maxHeap.size()&1) == 0)
            median = (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            median = minHeap.peek();
        return median;
    }
}