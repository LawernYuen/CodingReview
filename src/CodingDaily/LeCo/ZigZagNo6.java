package CodingDaily.LeCo;

import java.util.ArrayList;

public class ZigZagNo6 {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1)
            return s;
        int gap = 2*numRows - 2;
        ArrayList<StringBuilder> list = new ArrayList<>();
        StringBuilder ans = new StringBuilder("");
        for (int i = 0; i < numRows; i++){
            boolean flag = true;
            list.add(new StringBuilder(""));
            StringBuilder temp = list.get(i);
            if (i == 0 || i == numRows-1)
                for (int j = 0; i+j*gap < s.length(); j++)
                    temp.append(s.charAt(i + j*gap));
            else{
                int j = i;
                while (j < s.length()){
                    temp.append(s.charAt(j));
                    if (flag)
                        j += (gap - i*2);
                    else
                        j += 2*i;
                    flag = !flag;
                }
            }
        }
        for (StringBuilder stringBuilder : list) ans.append(stringBuilder);
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        ZigZagNo6 demo = new ZigZagNo6();
        String ans = demo.convert(s, 4);
        System.out.println(ans);
    }
}
