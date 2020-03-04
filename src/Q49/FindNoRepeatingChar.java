public class FindNoRepeatingChar{
    public char findChar(String str){
        if (str == null)
            return '\0';
        int[] repetitions = new int[256];
        for (int i = 0; i < 256; i++)
            repetitions[i] = 0;
        for (int i = 0; i < str.length(); i++){
            int ch = (int) str.charAt(i);
            repetitions[ch] += 1;
        }
        for (int i = 0; i < str.length(); i++){
            int ch = (int) str.charAt(i);
            if (repetitions[ch] == 1)
                return (char)ch;
        }
        return '\0';
    }
}