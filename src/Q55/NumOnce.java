public class NumOnce{
    // use two arrays as paramters so they can be returned
    public void findNumOnce(int[] array, int[] n1, int[] n2){
        if (array == null || array.length < 2)
            return;
        int resultExclusiveOR = 0;
        for (int i = 0; i < array.length; j++)
            resultExclusiveOR ^= array[i];

        int idxOf1 = 0;
        // find the first digit which is 1 from right
        // idxOf1 <= 8*sizeof(int)
        while ((resultExclusiveOR&1) == 0 && idxOf1 <= 4*8){
            resultExclusiveOR = resultExclusiveOR >> 1;
            idxOf1++;
        }

        n1[0] = 0;
        n2[0] = 0;
        for (int i = 0; i < array.length; i++){
            if (isBit1(array[i], idxOf1))
                n1[0] ^= array[i];
            else
                n2[0] ^= array[i];
        }
    }

    private boolean isBit1(int num, int idx){
        num = num >> idx;
        return (num & 1);
    }
}