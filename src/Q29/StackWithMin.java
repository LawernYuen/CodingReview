import java.util.Stack;

public class StackWithMin{
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> stack_aux = new Stack<Integer>();

    public void push(int node){
        stack.push(node);
        if(stack_aux.empty() || stack_aux.peek() > node)
            stack_aux.push(node);
        else
            stack_aux.push(stack_aux.peek());
    }

    public void pop(){
        if (!stack.empty()){
            stack.pop();
            stack_aux.pop();
        }
    }

    public int min(){
        return stack_aux.peek();
    }
}