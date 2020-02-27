import java.util.Stack;

public class QueueWithTwoStacks{
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop(){
        if (stack2.empty()) {
            if (stack1.empty())
                throw new RuntimeException("Empty Queue!");
            else
                while (!stack1.empty())
                    stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args){
        QueueWithTwoStacks demo = new QueueWithTwoStacks();
        demo.push(1);
        demo.push(2);
        System.out.println(demo.pop());
        demo.push(3);
        System.out.println(demo.pop());
    }
}