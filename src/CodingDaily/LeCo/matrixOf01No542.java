package CodingDaily.LeCo;

public class matrixOf01No542 {
    public int[][] updateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0 && matrix[i][j] != 0)
                    matrix[i][j] = matrix.length + matrix[0].length - 2;
                else if (i == 0 && matrix[i][j] != 0)
                    matrix[i][j] = matrix[i][j-1] + 1;
                else if (j == 0 && matrix[i][j] != 0)
                    matrix[i][j] = matrix[i-1][j] + 1;
                else if (matrix[i][j] != 0)
                    matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-1]) + 1;
            }
        }
        for (int i = matrix.length-1; i >= 0; i--){
            for (int j = matrix[0].length-1; j >= 0; j--){
                if (i == matrix.length-1 && j == matrix[0].length-1 && matrix[i][j] != 0)
                    matrix[i][j] = Math.min(matrix.length+matrix[0].length-2, matrix[i][j]);
                else if (i == matrix.length-1 && matrix[i][j] != 0)
                    matrix[i][j] = Math.min(matrix[i][j+1]+1, matrix[i][j]);
                else if (j == matrix[0].length-1 && matrix[i][j] != 0)
                    matrix[i][j] = Math.min(matrix[i+1][j]+1, matrix[i][j]);
                else if (matrix[i][j] != 0)
                    matrix[i][j] = Math.min(Math.min(matrix[i+1][j], matrix[i][j+1])+1, matrix[i][j]);
            }
        }
        return  matrix;
    }
}
