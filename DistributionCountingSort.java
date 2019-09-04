import java.util.Scanner;
import java.io.File;

// Java implementation of Counting Sort
class DistributionCountingSort
{
    void sort(int arr[])
    {
        int n = arr.length;

        // The output character array that will have sorted arr
        int output[] = new int[n];

        // Create a count array to store count of inidividul
        // characters and initialize count array as 0
        int count[] = new int[256];
        for (int i=0; i<256; ++i)
            count[i] = 0;

        // store count of each character
        for (int i=0; i<n; ++i)
            ++count[arr[i]];

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i=1; i<=255; ++i)
            count[i] += count[i-1];

        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (int i = n-1; i>=0; i--)
        {
            output[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i<n; ++i)
            arr[i] = output[i];
    }

    // Driver method
    public static void main(String args[]) throws Exception
    {
        DistributionCountingSort countingSort = new DistributionCountingSort();

        int size = Integer.parseInt(args[0]);
        File f = new File(args[1]);
        int min = Integer.parseInt(args[2]);
        int max = Integer.parseInt(args[3]);
        Scanner fscanner = new Scanner(f);


        int arr[] = new int[size];
        for(int k= 0; k<arr.length;k++)
            arr[k]=fscanner.nextInt();


        countingSort.sort(arr);

        for (int i=0; i<arr.length; ++i)
            System.out.println(arr[i]);
    }
}