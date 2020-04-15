public class PrintMatrix{
    public void printMatrix(int[][] matrix){
        if (matrix== null || matrix.length <= 0)
            return;
        printMatrixInCircle(matrix, 0);
    }

    private void printMatrixInCircle(int[][] matrix, int start){
        int row = matrix.length;
        int col = matrix[0].length;
        int endX = col - 1 - start;
        int endY = row - 1 - start;
        if (endX < start || endY < start) // termination condition
            return;
        // one row
        if (endY == start) {
            for (int i = start; i <= endX; i++)
                System.out.print(matrix[start][i] + " ");
            return;
        }
        // one column
        if (endX == start) {
            for (int i = start; i <= endY; i++)
                System.out.print(matrix[i][start] + " ");
            return;
        }
        // boundary
        for (int i = start; i <= endX; i++)
            System.out.print(matrix[start][i] + " ");
        for (int i = start+1; i <= endY; i++)
            System.out.print(matrix[i][endX] + " ");
        for (int i = endX-1; i >= start; i--)
            System.out.print(matrix[endY][i] + " ");
        for (int i = endY-1; i > start; i--)
            System.out.print(matrix[i][start] + " ");

        printMatrixInCircle(matrix, start+1);
    }

    public static void main(String[] args){
        PrintMatrix demo = new PrintMatrix();
        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        demo.printMatrix(a);
    }
}