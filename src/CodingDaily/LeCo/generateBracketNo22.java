package CodingDaily.LeCo;

import java.util.ArrayList;
import java.util.List;

public class generateBracketNo22 {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int leftCount = n, curCount = 0;
        StringBuilder curStr = new StringBuilder();
        getStr(curCount, leftCount, curStr, n);
        return ans;
    }
    private void getStr(int curCount, int leftCount, StringBuilder curStr, int n){
        if (curCount == 0 && leftCount == 0) {
            ans.add(curStr.toString());
            return;
        }
        if (curCount < 0 || curCount > n || leftCount < 0)
            return;
        getStr(curCount+1, leftCount-1, curStr.append('('), n);
        curStr.deleteCharAt(curStr.length()-1);
        getStr(curCount-1, leftCount, curStr.append(')'), n);
        curStr.deleteCharAt(curStr.length()-1);
    }

    public static void main(String[] args) {
        generateBracketNo22 demo = new generateBracketNo22();
        List<String> list = demo.generateParenthesis(3);
        System.out.println(list);
    }
}
