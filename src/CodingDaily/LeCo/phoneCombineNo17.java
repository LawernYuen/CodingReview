package CodingDaily.LeCo;

import java.util.ArrayList;
import java.util.List;

public class phoneCombineNo17 {
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() <= 0)
            return ans;
        char[][] letters = {{}, {}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'},
                {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'},
                {'t','u','v'}, {'w','x','y','z'}};
        int idx = 0;
        StringBuilder str = new StringBuilder("");
        getStr(digits, idx, letters, str);
        return ans;
    }
    private void getStr(String digits, int idx, char[][] letters, StringBuilder str){
        if (idx == digits.length()) {
            ans.add(str.toString());
            return;
        }
        int num = digits.charAt(idx) - '0';
        for (int i = 0; i < letters[num].length; i++){
            str.append(letters[num][i]);
            getStr(digits, idx+1, letters, str);
            str.deleteCharAt(str.length()-1);
        }
    }
}