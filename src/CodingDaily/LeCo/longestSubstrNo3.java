package CodingDaily.LeCo;

import java.util.HashMap;

public class longestSubstrNo3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0, currentLen = 0, start = 0;
        for (int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if (!map.containsKey(temp)) {
                map.put(temp, i);
                currentLen++;
            }
            else {
                start = map.get(temp);
                map.clear();
                for (int j = start+1; j <= i; j++)
                    map.put(s.charAt(j), j);
                currentLen = i - start;
                map.put(temp, i);
            }
            ans = Math.max(ans, currentLen);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        longestSubstrNo3 demo = new longestSubstrNo3();
        int ans = demo.lengthOfLongestSubstring(s);
        System.out.println(ans);
    }
}
