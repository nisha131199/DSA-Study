package binarySearch;

import java.util.Arrays;

public class TargetInMatrix {
    public static void main(String[] args) {

        int[][] sortedMatrix = {
                {0,1,2},
                {4,5,6,7,7},
                {7,8,8,9}
        };
        System.out.println(Arrays.toString(doSearchingInSortedMatrix(sortedMatrix, 9)));

//        int row = 3, column = 3;
//        int[][] matrix = {
//                {1,3,6},
//                {3,6,7},
//                {5,8,23}
//        };
     /*   int row = 3, column = 5;
        int[][] matrix = {
                {1,3,5,6},
                {2,5,7},
                {5,8,9,12,23}
        };
        if (row == column) {
            System.out.println(Arrays.toString(matrixProblem(matrix, 5)));
        } else {
            System.out.println(Arrays.toString(matrixProblemWithNRowAndMColumns(matrix, 12, row)));
        }*/
    }

    //todo: sorted row & column wise matrix
    // and the row length = column length
    //     C1  C2  C3
    // R1: [1, 2, 3]
    // R2: [2, 4, 5]
    // R3: [7, 9, 20]
    // matrix [row] [column]
    public static int[] matrixProblem(int[][] matrix, int target) {
        int start = 0;
        int last = matrix.length-1;

        while (start < matrix.length && last >= 0) {
            if (matrix[start][last] == target) {
                return new int[] {start, last};
            } else if (matrix[start][last] > target) {
                last --;
            } else {
                start ++;
            }
        }

        return new int[] {-1, -1};
    }

    //todo: sorted row & column wise matrix
    // and the row length != column length
    public static int[] matrixProblemWithNRowAndMColumns(int[][] matrix, int target, int row) {
        int start = 0;
        int last = matrix[start].length-1;

        while (start < row && last >= 0) {
            if (matrix[start][last] == target) {
                return new int[] {start, last};
            } else if (matrix[start][last] > target) {
                last --;
            } else {
                start ++;
                last = matrix[start].length - 1;
            }
        }

        return new int[] {-1, -1};
    }




    //todo: sorted matrix
    // if row == column
    //     C1  C2  C3
    // R1: [1, 2, 3]
    // R2: [4, 5, 6]
    // R3: [7, 9, 20]
    // matrix [row] [column]
    public static int[] doSearchingInSortedMatrix(int[][] matrix, int target) {
        int rows = matrix.length - 1;
        int midColumn = (matrix[0].length - 1)/2;

        if (rows == 1) { //todo: it is a sorted 1-D array
            return doBinarySearchInRowWithColumnBounds(matrix, target, 0, 0, matrix[0].length - 1);
        }

        int startRow = 0;
        int lastRow = rows;

        //todo: reducing rows until 2 rows left
        while (startRow < lastRow - 1) {
            int mid = startRow + (lastRow - startRow)/2;
            if (matrix[mid][midColumn] == target) {
                return new int[] {mid, midColumn};
            } else if (matrix[mid][midColumn] > target) {
                lastRow = mid;
            } else {
                startRow = mid;
            }
        }

        //todo: two rows left behind if target not found in the loop
        if (matrix[startRow][midColumn] == target) {
            return new int[] {startRow, midColumn};
        }
        if (matrix[startRow + 1][midColumn] == target) {
            return new int[] {startRow + 1, midColumn};
        }

        //todo: now handle four cases in two rows
        if (matrix[startRow][midColumn] > target) {
            return doBinarySearchInRowWithColumnBounds(
                    matrix,
                    target,
                    startRow,
                    0,
                    midColumn - 1);
        }
        if (matrix[startRow][midColumn] < target &&
                matrix[startRow][matrix[startRow].length - 1] >= target) {
            return doBinarySearchInRowWithColumnBounds(
                    matrix,
                    target,
                    startRow,
                    midColumn + 1,
                    matrix[startRow].length - 1
            );
        }

        if (matrix[startRow + 1][midColumn] < target) {
            return doBinarySearchInRowWithColumnBounds(
                    matrix,
                    target,
                    startRow + 1,
                    midColumn + 1,
                    matrix[startRow + 1].length - 1);
        }
        else {
            return doBinarySearchInRowWithColumnBounds(
                    matrix,
                    target,
                    startRow + 1,
                    0,
                    midColumn - 1);
        }
    }

    public static int[] doBinarySearchInRowWithColumnBounds(int[][] matrix, int target, int row, int startColumn, int lastColumn) {
        while (startColumn <= lastColumn) {
            int mid = startColumn + (lastColumn - startColumn)/2;
            if (matrix[row][mid] == target) {
                return new int[] {row, mid};
            } else if (matrix[row][mid] > target) {
                lastColumn = mid - 1;
            } else {
                startColumn = mid + 1;
            }
        }
        return new int[] {-1, -1};
    }
}