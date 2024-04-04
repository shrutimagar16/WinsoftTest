/*Q1: Merge two arrays by satisfying given constraints
Given two sorted arrays X[] and Y[] of size m and n each where m >= n and X[] has exactly n vacant cells,
 merge elements of Y[] in their correct position in array X[], i.e., merge (X, Y) by keeping the sorted order.

For example,

Input: X[] = { 0, 2, 0, 3, 0, 5, 6, 0, 0 }
Y[] = { 1, 8, 9, 10, 15 } The vacant cells in X[] is represented.*/


public class MergeArrays {
    
    public static void mergeArrays(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;
        
        // Initialize pointers for X and Y
        int i = 0;  // Pointer for merged X
        int j = 0;  // Pointer for Y
        
        // Move all non-zero elements of X to the end
        for (int k = m - 1; k >= 0; k--) {
            if (X[k] != 0) {
                X[--i] = X[k];
            }
        }
        
        // Merge X and Y
        i = 0;  // Reset pointer for merged X
        while (i < m && j < n) {
            if (X[i] <= Y[j]) {
                i++;
            } else {
                X[i++] = Y[j++];
            }
        }
        
        // If elements in Y are still remaining, append them to X
        while (j < n) {
            X[i++] = Y[j++];
        }
    }
    
    public static void main(String[] args) {
        int[] X = {0, 2, 0, 3, 0, 5, 6, 0, 0};
        int[] Y = {1, 8, 9, 10, 15};
        
        mergeArrays(X, Y);
        
        // Print the merged array X
        for (int num : X) {
            System.out.print(num + " ");
        }
        // Output: 1 2 3 5 6 8 9 10 15
    }
}

