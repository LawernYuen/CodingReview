package CodingDaily.LeCo;

import java.util.HashMap;

public class PerturStrNo87 {
//    public boolean isScramble(String s1, String s2) {
//        HashMap<Integer, Character> map = new HashMap<>();
//        for (int i = 0; i < s2.length(); i++){
//            char flag = s2.charAt(i);
//            int cutPoint = i;
//            while (true){
//                char check = s1.charAt(cutPoint);
//                if (check == flag)
//                    break;
//                map.put(cutPoint, check);
//                cutPoint++;
//                if (cutPoint >= s1.length())
//                    return false;
//            }
//            for (int j = i+1; j <= cutPoint; j++)
//                if (!map.containsValue(s2.charAt(j)))
//                    return false;
//            i = cutPoint;
//        }
//        return true;
//    }
    public boolean isScramble(String s1, String s2) {
        int i = 0;
        for (; i < s2.length(); i++){
            if (s1.charAt(0) == s2.charAt(i))
                break;
        }
        int length = s2.length() - i;
        boolean test1 = isScrambleCore(s1, s2);
        boolean test2 = isScrambleCore(s2, s1);
        boolean test3 = isScrambleCore(s1.substring(0, length), s2.substring(i));
        boolean test4 = isScrambleCore(s1.substring(length), s2.substring(0, i));
        return isScrambleCore(s1, s2) || isScrambleCore(s2, s1)
                || (isScrambleCore(s1.substring(0, length), s2.substring(i)) &&
                isScrambleCore(s1.substring(length), s2.substring(0, i)));
    }
    public boolean isScrambleCore(String s1, String s2) {
        HashMap<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < s2.length(); i++){
            char flag = s2.charAt(i);
            int cutPoint = i;
            while (true){
                boolean shouldBreak = false;
                char check = s1.charAt(cutPoint);
                if (check == flag) {
                    if (cutPoint == i)
                        break;
                    for (int j = i+1; j <= cutPoint; j++) {
                        if (!map.containsValue(s2.charAt(j)))
                            break;
                        if (j == cutPoint)
                            shouldBreak = true;
                    }
                }
                map.put(cutPoint, check);
                if (shouldBreak)
                    break;
                cutPoint++;
                if (cutPoint >= s1.length())
                    return false;
            }
            i = cutPoint;
            map.clear();
        }
        return true;
    }

    public static void main(String[] args) {
        PerturStrNo87 demo = new PerturStrNo87();
        String s1 = "abcdd";
        String s2 = "dbdac";
        boolean ans = demo.isScramble(s1, s2);
        System.out.println(ans);
    }
}
