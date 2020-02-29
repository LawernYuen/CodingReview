public class RegularExpressions{
    public boolean match(char[] str, char[] pattern){
        if (str == null || pattern == null)
            return false;
        return matchCore(str, 0, pattern, 0);
    }

    private boolean matchCore(char[] str, int indexOfStr, char[] pattern, int indexOfPattern){
        if (indexOfStr == str.length && indexOfPattern == pattern.length)
            return true;
        if (indexOfStr == str.length && pattern[indexOfPattern+1] != '*')
            return false;
        if (pattern[indexOfPattern+1] == '*')
            if (pattern[indexOfPattern]==str[indexOfStr] || (pattern[indexOfPattern]=='.' && indexOfStr<str.length))
                return matchCore(str, indexOfStr, pattern, indexOfPattern+2)
                || matchCore(str, indexOfStr+1, pattern, indexOfPattern+2)
                || matchCore(str, indexOfStr+1, pattern, indexOfPattern);
            else
                return matchCore(str, indexOfStr, pattern, indexOfPattern+2);
        if (str[indexOfStr]==pattern[indexOfPattern] || (pattern[indexOfPattern]=='.' && indexOfStr<str.length))
            return matchCore(str, indexOfStr+1, pattern, indexOfPattern+1);
        return false;
    }
}