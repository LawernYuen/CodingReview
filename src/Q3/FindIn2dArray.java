package Q3;

public class FindIn2dArray{
    public boolean Find(int target, int[][] array){
        int rows = array.length, cols = array[0].length;
        if (array == null || rows <= 0 || cols <= 0)
            throw new IllegalArgumentException("Wrong Arguments!");
        int row = 0, col = col - 1;
        while (row < rows && col >= 0){
            if (array[row][col] == target)
                return true;
            else if (array[row][col] > target)
                --col;
            else
                ++row;
        }
        return false;
    }
}