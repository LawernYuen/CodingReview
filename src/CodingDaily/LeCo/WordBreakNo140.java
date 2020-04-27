package CodingDaily.LeCo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreakNo140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
//        HashSet<String> set = new HashSet<>(wordDict);
//        List<List<String>> dp = new ArrayList<>();
//        List<String> temp = new ArrayList<>();
//
//        temp.add("");
//        dp.add(temp);
//        for (int i = 1; i <= s.length(); i++){
//            temp = new ArrayList<>();
//            for (int j = 0; j < i; j++){
//                if (set.contains(s.substring(j,i))){
//                    for (int k = 0; k < dp.get(j).size(); k++){
//                        String t = dp.get(j).get(k);
//                        if (t.equals(""))
//                            temp.add(s.substring(j,i));
//                        else
//                            temp.add(t + " " + s.substring(j,i));
//                    }
//                }
//            }
//            dp.add(temp);
//        }
//        return dp.get(s.length());
        HashSet<String> set = new HashSet<>(wordDict);
        return wordBreakHelper(s, set, new HashMap<String, List<String>>());
    }
    private List<String> wordBreakHelper(String s, HashSet<String> set, HashMap<String, List<String>> map){
        if (s.length() == 0)
            return new ArrayList<>();
        if (map.containsKey(s))
            return map.get(s);
        List<String> res = new ArrayList<>();
        for (int j = 0; j < s.length(); j++){
            if (set.contains(s.substring(j))){
                if (j == 0)
                    res.add(s.substring(j));
                else {
                    List<String> temp = wordBreakHelper(s.substring(0,j), set, map);
                    for (String t : temp)
                        res.add(t + " " + s.substring(j));
                }
            }
        }
        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        WordBreakNo140 demo = new WordBreakNo140();
        demo.wordBreak(s, wordDict);
    }
}
