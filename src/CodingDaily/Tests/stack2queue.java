package CodingDaily.Tests;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class stack2queue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < num; i++){
            String str = in.next();
            String opt = str.substring(0, 3);
//            if (opt.equals("add")){
//                int temp = in.nextInt();
//                stack1.addLast(temp);
//            }
//            else if (opt.equals("pee")){
//                int size = stack1.size();
//                for (int j = 0; j < size; j++)
//                    stack2.addLast(stack1.pollLast());
//                System.out.println(stack2.getLast());
//                for (int j = 0; j < size; j++)
//                    stack1.addLast(stack2.pollLast());
//            }
//            else if (opt.equals("pol")){
//                int size = stack1.size();
//                for (int j = 0; j < size; j++)
//                    stack2.addLast(stack1.pollLast());
//                stack2.pollLast();
//                for (int j = 0; j < size-1; j++)
//                    stack1.addLast(stack2.pollLast());
//            }
            if (opt.equals("add")){
                int temp = in.nextInt();
                list.add(temp);
            }
            else if (opt.equals("pee")){
                System.out.println(list.get(0));
            }
            else if (opt.equals("pol")){
                list.remove(0);
            }

        }
    }
}
