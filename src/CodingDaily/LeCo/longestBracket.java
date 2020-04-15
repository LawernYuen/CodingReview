package CodingDaily.LeCo;

import java.util.Stack;

public class longestBracket {
    public int longestValidParentheses(String str) {
        int maxLen = 0;
        Stack<Integer> valid = new Stack<>();
        valid.push(-1);
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '(')
                valid.push(i);
            else {
                valid.pop();
                if (valid.empty())
                    valid.push(i);
                else
                    maxLen = Math.max(maxLen, i-valid.peek());
            }
        }
        return maxLen;
    }
}
