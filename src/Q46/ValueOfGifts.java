public class ValueOfGifts{
    public int maxValue(int[][] values){
        if (values == null || values.length <= 0 || values[0].length <= 0)
            return 0;
        int rows = values.length;
        int cols = values[0].length;
        int[] maxValue = new int[cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                int left = 0, up = 0;
                if (i > 0)
                    up = maxValue[j];
                if (j > 0)
                    left = maxValue[j-1];
                maxValue[j] = Math.max(up, left) + values[i][j];
            }
        }
        return maxValue[cols-1];
    }
}