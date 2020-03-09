import java.util.Stack;

public class PushAndPop{
    public boolean check(int[] pushOrder, int[] popOrder){
        if (pushOrder == null || popOrder == null
            || pushOrder.length != popOrder.length)
            return false;
        Stack<Integer> stack = new Stack<Integer>();
        int popIndex = 0;
        for (int pushIndex = 0; pushIndex < pushOrder.length; pushIndex++){
            stack.push(pushOrder[pushIndex]);
            while (!stack.empty() && stack.peek() == popOrder[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return stack.empty();
    }
}