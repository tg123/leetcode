public class Solution {

    boolean searchMatrix(int[][] matrix, int stX, int stY, int edX, int edY, int target) {

        if (stX >= edX || stY >= edY) return false;

        int max = matrix[edX - 1][edY - 1];
        int min = matrix[stX][stY];

        // min <= target <= max
        if (min <= target && target <= max){

            int mdX = (stX + edX) / 2;
            int mdY = (stY + edY) / 2;

            if(matrix[mdX][mdY] == target){
                return true;
            }

            return searchMatrix(matrix, stX, stY, mdX, mdY, target) ||
                   searchMatrix(matrix, stX, mdY, mdX, edY, target) ||
                   searchMatrix(matrix, mdX, stY, edX, mdY, target) ||
                   searchMatrix(matrix, mdX, mdY, edX, edY, target);
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix, 0, 0, matrix.length, matrix[0].length, target);
    }
}
