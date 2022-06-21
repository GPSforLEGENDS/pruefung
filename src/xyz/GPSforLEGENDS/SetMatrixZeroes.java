package xyz.GPSforLEGENDS;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] rows = new boolean[m];
        boolean[] columns = new boolean[n];

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                int val = matrix[r][c];

                if(val == 0){
                    rows[r] = true;
                    columns[c] = true;
                }
            }
        }

        for(int r = 0; r < m; r++){
            if(rows[r]){
                for(int c = 0; c < n; c++){
                    matrix[r][c] = 0;
                }
            }
        }

        for(int c = 0; c < n; c++){
            if(columns[c]){
                for(int r = 0; r < m; r++){
                    matrix[r][c] = 0;
                }
            }
        }
    }
}
