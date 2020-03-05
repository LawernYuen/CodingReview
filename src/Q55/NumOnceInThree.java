public class NumOnceInThree{
    public int findNumOnce(int[] array){
        if (array == null || array.length <= 0)
            return -1;
        int[] bitSum = new int[32];
        for (int i = 0; i < 32; i++)
            bitSum[i] = 0;
        for (int i = 0; i < array.length; i++){
            int bitMask = 1;
            for (int j = 31; j >= 0; j--){
                if ((array[i] & bitMask) != 0)
                    bitSum[j] += 1;
                bitMask = bitMask << 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++){
            result = result << 1;
            result += (bitSum[i]%3);
        }
        return result;
    }
}