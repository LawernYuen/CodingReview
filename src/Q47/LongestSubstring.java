public class LongestSubstring{
    public int maxLength(String str){
        if (str == null || str.length() <= 0)
            return 0;
        int curLength = 0;
        int maxlength = 0;
        int[] pos = new int[26]; // positions letters appeared
        for (int i = 0; i < pos.length; i++)
            pos[i] = -1;
        for (int i = 0; i < str.length(); i++){
            // index of every letter in the array
            int prevIndex = str.charAt(i) - 'a';
            if (pos[prevIndex] < 0 || i-pos[prevIndex] > curLength)
                curLength++;
            else
                curLength = i - pos[prevIndex];
            pos[prevIndex] = i;
            if (curLength > maxlength)
                maxlength = curLength;
        }
        return maxlength;
    }

    public static void main(String[] args){
        LongestSubstring demo = new LongestSubstring();
        int num = demo.maxLength("arabcacfr");
        System.out.print(num);
    }
}