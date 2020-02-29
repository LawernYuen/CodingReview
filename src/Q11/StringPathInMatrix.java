public class StringPathInMatrix{
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if (matrix == null || rows < 1 || cols < 1 || str == null)
            throw new RuntimeException("Wrong Arguments!");
        boolean[] isVisited = new boolean[rows * cols];
        for (boolean v : isVisited)
            v = false;
        int pathLength = 0;
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, isVisited))
                    return true;
        return false;
    }

    public boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] isVisited){
        if (row < 0 || col < 0 || row >= rows || col >= cols || isVisited[row*cols+col] == true || str[pathLength] != matrix[row*cols+col])
            throw new RuntimeException("Wrong Arguments!");
        if (pathLength == str.length - 1)
            return true;
        boolean hasPath = false;
        isVisited[row*cols+col] = true;
        hasPath = hasPathCore(matrix, rows, cols, row-1, col, str, pathLength+1, isVisited)
                || hasPathCore(matrix, rows, cols, row+1, col, str, pathLength+1, isVisited)
                || hasPathCore(matrix, rows, cols, row, col-1, str, pathLength+1, isVisited)
                || hasPathCore(matrix, rows, cols, row, col+1, str, pathLength+1, isVisited);
        if (!hasPath)
            isVisited[row*cols+col] = false;
        return hasPath;
    }
}