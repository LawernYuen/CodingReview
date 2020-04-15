package CodingDaily.Tests;

import java.util.Scanner;
import java.util.Stack;

public class BracketMatching {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int coup = 0;
        int left = 0;
        int right = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '(')
                stack.push('(');
            else if (str.charAt(i) == ')'){
                if (!stack.empty()){
                    stack.pop();
                    coup++;
                }
                else
                    right++;
            }
        }
        left = stack.size();
        System.out.println(coup + " " + left + " " + right);
    }
}
