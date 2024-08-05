import java.util.Arrays;

public class Rotate_Image {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        Rotate_Image rotateImage = new Rotate_Image();
        rotateImage.rotate(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    public void rotate(int[][] matrix) {
        transposeMatrix(matrix);

        for(int[] arr : matrix){
            reverseArr(arr);
        }
    }

    private void reverseArr(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j){
            int temp = arr[i];
            arr[i] =  arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    private void transposeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
