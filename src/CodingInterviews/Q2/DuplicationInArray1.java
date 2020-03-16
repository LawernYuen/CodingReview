package Q2;

//  如果不用布尔型的可以一直循环下去找到所有重复的，但是要注意下标i上的数字只能和
//  比i大的下标上的数字交换，否则复杂度就不止O(n)了
public class DuplicationInArray1{
    private int duplicatedNumber;
    public boolean findDuplicatedNumber(int[] array, int length){
        if (array == null || length <= 0)
            throw new IllegalArgumentException("Wrong Arguments!");
        for (int i = 0; i < length; i++)
            if (array[i] < 0 || array[i] > length-1)
                throw new IllegalArgumentException("Wrong Numbers in Array!");
        for (int i = 0; i < length; i++){
            while (array[i] != i){
                if (array[i] == array[array[i]]){
                    duplicatedNumber = array[i];
                    return true;
                }
                // swap
                int temp = array[i];
                array[i] = array[temp];
                array[temp] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args){
        DuplicationInArray1 duplicationInArray = new DuplicationInArray1();
        int[] array = {2,3,1,0,2,5,3};
        if (duplicationInArray.findDuplicatedNumber(array,array.length))
            System.out.println("find duplicated number: " + duplicationInArray.duplicatedNumber);
    }
}