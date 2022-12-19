import java.util.Arrays;

public class Radix {
    public static void main(String[] args) {
        int[] a = {85, 3, 19, 43, 20, 55, 42, 21, 91, 85, 73, 29};

        //Print unsorted array.
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        double start = System.nanoTime();
        //Sort the array.
        a = radixSort(a);
        double elapsed = (System.nanoTime() - start) / 1000000000;

        //Print sorted array.
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }   //End Main

    /**
     * radixSort is an implementation of radix sort
     *
     * @param a the array to be sorted
     * @return a sorted array
     */
    public static int[] radixSort(int[] a) {
        int[] array = a.clone();
        int length = array.length;
        int d = 0;
        for (int value : array) {
            // find the maximum number of digits in a
            d = Math.max((int) Math.floor(Math.log10(Math.abs(value))) + 1, d);
        }

        // save the result for each sorting loop
        int[][] bucket = new int[20][length + 1];
        for (int i = 0; i < d; i++) {
            // calculate the base for the current loop
            int base = (int) Math.pow(10, i);
            // set all the elements of the bucket to be 0 in order to save the new sorting result
            for (int j = 0; j < 20; j++) {
                Arrays.fill(bucket[j], 0);
            }
            // in each bucket, the first element is used to save how many numbers are saved in this bucket
            for (int j = 0; j < length; j++) {
                // add 10 to handle the negative number.
                // -ab % 10 = -b, so mapping [-9, -1] to [1, 9] and [0, 9] to [10, 19]
                int digit = array[j] / base % 10 + 10;
                bucket[digit][++bucket[digit][0]] = array[j];
            }
            int count = 0;
            for (int j = 0; j < 20; j++) {
                // save the current sort result to the array
                // the order is FIFO
                for (int k = 1; k <= bucket[j][0]; k++) {
                    array[count++] = bucket[j][k];
                }
            }
        }
        return array;
    }   //End radixSort
}   //End Class