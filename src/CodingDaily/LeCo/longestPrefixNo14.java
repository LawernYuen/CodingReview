package CodingDaily.LeCo;

public class longestPrefixNo14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder("");
        if (strs == null || strs.length <= 0)
            return ans.toString();
        String str = strs[0];
        for (int i = 0; i < str.length(); i++){
            char curChar = str.charAt(i);
            for (int j = 1; j < strs.length; j++){
                String curStr = strs[j];
                if (curStr.length() <= i || curStr.charAt(i) != curChar)
                    return ans.toString();
            }
            ans.append(curChar);
        }
        return ans.toString();
    }
}
