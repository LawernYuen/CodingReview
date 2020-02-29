public class NumericStrings{
    private static int index = 0;
    public boolean isNumeric(char[] str){
        if (str == null || str.length == 0)
            return false;
        boolean isNumeric = isInteger(str, index);
        if (index < str.length && str[index] == '.'){
            index++;
            isNumeric = isUnsignedInteger(str, index) || isNumeric;
        }
        if (index < str.length && (str[index[0]] == 'e' || str[index[0]] == 'E')){
            index++;
            isNumeric = isInteger(str, index) && isNumeric;
        }
        if (isNumeric && index == str.length)
            return true;
        else
            return false;
    }

    private boolean isInteger(char[] str, int index){
        if (index < str.length && (str[index] == '+' || str[index] == '-'))
            index++;
        return isUnsignedInteger(str, index);
    }
    private boolean isUnsignedInteger(char[] str, int index){
        int start = index;
        while (index < str.length && (str[index[0]] - '0' <= 9 && str[index[0]] - '0' >= 0))
            index++;
        if (index > start)
            return true;
        else
            return false;
    }
}