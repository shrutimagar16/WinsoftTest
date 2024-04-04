/*Find maximum sum path involving elements of given arrays
Given two sorted arrays of integers, find a maximum sum path involving elements of both arrays whose sum is maximum. 
We can start from either array, but we can switch between arrays only through its common elements.*/

class MaximumSumPath {
    // Function to find the maximum sum path
    public static int maxSumPath(int[] X, int[] Y) {
        int i = 0, j = 0;
        int result = 0, sumX = 0, sumY = 0;

        while (i < X.length && j < Y.length) {
            // Add elements of X[] and Y[] to their respective sums
            if (X[i] < Y[j]) {
                sumX += X[i++];
            } else if (X[i] > Y[j]) {
                sumY += Y[j++];
            } else {
                // Common element found, pick the maximum sum path so far
                result += Math.max(sumX, sumY) + X[i];
                
                // Move both pointers and reset sums
                i++;
                j++;
                sumX = 0;
                sumY = 0;
            }
        }

        // Add remaining elements of X[]
        while (i < X.length) {
            sumX += X[i++];
        }

        // Add remaining elements of Y[]
        while (j < Y.length) {
            sumY += Y[j++];
        }

        // Add the maximum of remaining sums to result
        result += Math.max(sumX, sumY);

        return result;
    }

    public static void main(String[] args) {
        int[] X = {3, 6, 7, 8, 10, 12, 15, 18, 100};
        int[] Y = {1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50};
        
        System.out.println("The maximum sum path is: " + maxSumPath(X, Y));
    }
}
