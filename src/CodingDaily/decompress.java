package CodingDaily;

import java.util.Scanner;

public class decompress {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '['){
                int count = 1;
                int start = i;
                while (count != 0){
                    i++;
                    if (str.charAt(i) == '[')
                        count++;
                    if (str.charAt(i) == ']')
                        count--;
                }
                int end = i;
                ans.append(decode(str.substring(start+1, end)));
            }
            else
                ans.append(str.charAt(i));
        }
        System.out.println(ans.toString());
    }
    private static StringBuilder decode(String s){
        int times = s.charAt(0) - '0';
        int index = 1;
        while (s.charAt(index) != '|') {
            times = times * 10 + s.charAt(index) - '0';
            index++;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = index+1; i < s.length(); i++){
            if (s.charAt(i) == '['){
                int count = 1;
                int start = i;
                while (count != 0){
                    i++;
                    if (s.charAt(i) == '[')
                        count++;
                    if (s.charAt(i) == ']')
                        count--;
                }
                int end = i;
                ans.append(decode(s.substring(start+1, end)));
            }
            else
                ans.append(s.charAt(i));
        }
        StringBuilder temp = new StringBuilder(ans);
        for (int i = 1; i < times; i++)
            ans.append(temp);
        return ans;
    }
}
