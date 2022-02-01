package Lab_02;
/**
 * Name: Justin Houle
 * Date: 2022/02/01
 * Description: Multiple functions which preform various tasks using arrays.
 */

public class Main{
    /**
     * Function #1 outputs the String name
     *
     * @param name The string to be displayed
     */
    public static void displayName(String name){
        System.out.println("#1: " + name);
    }

    /**
     * Function #2 outputs a 1 dimensional Array
     *
     * @param  a  the array that will be displayed
     */
    public static void displayArray(int[] a) {

        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            if (i < a.length - 1) {
                System.out.print(a[i] + ", ");
            } else {
                if (i == a.length - 1) {
                    System.out.print(a[i]);
                }
            }
        }
        System.out.println("]");
    }

    /**
     * Function #3 displays a 2D Array
     *
     * @param a 2D array to be displayed
     */
    public static void display2DArray(int[][] a) {

        for (int i = 0; i < a.length; i++) {
            displayArray(a[i]);
        }
    }

    /**
     * Function #4 determines if 2 1D arrays are equivalent.
     *
     * @param  a first 1D array
     * @param b second 1D array
     * @return  A boolean true or false, if the arrays are equivalent to each other or not.
     */
    public static boolean arrEqual(int[] a, int[] b) {
        //check if arrays are empty
        if (a == null)
            return (b == null);
        else if (b == null)
            return false;

        // Check if arrays have equal length
        if (a.length != b.length) {
            return false;
        }

        // Check if elements of both arrays are equivalent
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Function #5 determines if 2 2D arrays are equivalent.
     *
     * @param  a first 2D array
     * @param b second 2D array
     * @return  A boolean true or false, depending if the arrays are equivalent to each other or not.
     */
    public static boolean arrEqual2D(int[][] a, int[][] b) {
        //check if arrays are empty
        if (a == null) {
            return (b == null);
        } else if (b == null) {
            return false;
        }
        // Check if arrays have equal length
        if (a.length != b.length) {
            return false;
        }
        // Check if elements of both arrays are equivalent
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Function #6 Finds the sum of the elements in a 1D array.
     *
     * @param  a 1D array
     * @return  The sum of the elements in the array (total).
     */
    public static int ArraySum(int[] a) {
        int total = 0;
        if (a == null) {
            return total;
        }

        for (int i : a) {
            total = total + i;
        }
        return total;
    }

    /**
     * Function #7 Finds the sum of the elements in a 2D array.
     *
     * @param  a 2D array
     * @return  The sum of the elements in the array (total).
     */
    public static int ArraySum2D(int[][] a) {

        int total = 0;
        if (a == null) {
            return total;
        }

        for (int[] ints : a) {
            total = total + ArraySum(ints);
        }
        return total;
    }

    /**
     * Function #8 Conducts an element wise multiplication onto 2 2D arrays.
     *
     * @param  a first 2D array
     * @param b second 2D array
     * @return  The resulting matrix (c), from the element wise multiplication.
     */
    public static int[][] Mult2D(int[][] a, int[][] b) {
        int row = a.length;
        int col = a[0].length;
        int[][] c = new int[row][col];

        if ((row == b.length) && (col == b[0].length)) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    c[i][j] = a[i][j] * b[i][j];
                }
            }
            return c;
        }
        else
            return null;
    }

    /**
     * Various tests used to verify if the methods are functioning properly
     * @param args tests
     */
    public static void main(String[] args) {

        // #1 test
        String Name = "Justin Houle";
        displayName(Name);

        // #2 test
        int[] arrayToDisplay = {2, 3};
        System.out.print("#2: ");
        displayArray(arrayToDisplay);

        // #3 test
        int[][] array2dToDisplay = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("#3: ");
        display2DArray(array2dToDisplay);

        // #4 test
        int[] arr1ToCheckEq = {1, 2, 3, 4};
        int[] arr2ToCheckEq = {1, 2, 3};
        if (arrEqual(arr1ToCheckEq, arr2ToCheckEq)){
            System.out.print("#4: The given arrays are equivalent.");
        }
        else {
            System.out.print("#4: The given arrays are not equivalent.");
        }

        // #5 test
        int[][] arr1ToCheck2DEq = {{1, 2, 3}, {4, 7, 6}, {7, 8, 9}};
        int[][] arr2ToCheck2DEq = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        if (arrEqual2D(arr1ToCheck2DEq, arr2ToCheck2DEq)) {
            System.out.println("#5: Arrays are equivalent");
        }
        else {
            System.out.println("#5: Arrays are not equivalent");
        }

        // #6 test
        int[] arrSum = {1, 2, 3, 4, 5};
        System.out.println("#6: The sum of the array is: " + ArraySum(arrSum));

        // #7 test
        int[][] arrSum2d = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("#7: The sum of the 2D array is: " + ArraySum2D(arrSum2d));

        // #8 test
        int[][] arrMult1 = {{1, 2, 3}, {4, 1, 1}};
        int[][] arrMult2 = {{2, 2,2},{2, 2,2}};
        if (Mult2D(arrMult1, arrMult2) == null) {
            System.out.println("#8: The 2 arrays are not of equivalent sizes");
        }
        else {
             System.out.println("#8: The resulting array is: ");
             display2DArray(Mult2D(arrMult1, arrMult2));
        }

    }
}

