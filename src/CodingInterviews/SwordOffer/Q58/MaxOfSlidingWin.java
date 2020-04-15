import java.util.ArrayList;
import java.util.Deque;

public class MaxOfSlidingWin{
    public ArrayList<Integer> maxOfSlide(int[] array, int size){
        ArrayList<Integer> max = new ArrayList<Integer>();
        if (array == null || array.length <= 0 || size <= 0 || size > array.length)
            return max;
        ArrayDeque<Integer> indexDeque = new ArrayDeque<Integer>();

        // process the first size numbers
        for (int i = 0; i < size-1; i++){
            while (!indexDeque.isEmpty() && array[i] > array[indexDeque.getLast()])
                indexDeque.removeLast();
            indexDeque.addLast(i);
        }
         // process the rest numbers
        for (int i = size-1; i < array.length; i++){
            while (!indexDeque.isEmpty() && array[i] > array[indexDeque.getLast()])
                indexDeque.removeLast();
            if (!indexDeque.isEmpty() && (i-indexDeque.getFirst()) >= size)
                indexDeque.removeFirst();
            indexDeque.addLast(i);
            max.add(array[indexDeque.getFirst()]);
        }
        return max;
    }
}