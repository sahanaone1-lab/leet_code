class Solution {
    public void rotate(int[][] matrix) {
        int r = matrix.length;
        for (int i = 0; i < r; i++) {
            for (int j = i + 1; j < r; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int k=0;k<r;k++){
        int i = 0;
        int j =r-1;
        while(i<j){
            int temp = matrix[k][i];
            matrix[k][i] = matrix[k][j];
            matrix[k][j]= temp;
            i++;
            j--;
        }
        }  
    }
}