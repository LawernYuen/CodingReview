public class StringToInt{
    public static boolean isValid = false;
    public int StrToInt(STring str){
        if (str == null || str.length() <= 0)
            return 0;
        char[] array = str.toCharArray();
        long num = 0; // to restore
        boolean minus = false;
        for (int i = 0; i < array.length; i++){
            if (i == 0 && array[i] == '-')
                minus = true;
            else if (i == 0 && array[i] == '+')
                minus = false;
            else {
                int a = (int)(array[i] - '0');
                if (a < 0 || a > 9){
                    isValid = false;
                    return 0;
                }
                num = (minus==false) ? num*10+a : num*10-a;
                isValid = true;
            }
            if ((!minus && num > 0x7FFFFFFF) || (minus && num < 0x80000000)){
                isValid = false;
                return 0;
            }
        }
    }
}