public class ContinuousPokers{
    public boolean isContinuous(int[] numbers){
        if (numbers == null || numbers.length <= 0)
            return false;
        Array.sort(numbers);
        int numberOf0 = 0;
        int numberOfGap = 0;
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] == 0)
                numberOf0++;
        int p1 = numberOf0;
        int p2 = p1 + 1;
        while (p2 < numbers.length){
            if (numbers[p1] == numbers[p2])
                return false;
            numberOfGap += numbers[p2++] - numbers[p1++] - 1;
        }
        if (numberOf0 >= numberOfGap)
            return true;
        return false;
    }
}