import java.util.Scanner;
import java.io.File;

public class InsertionSort {

    public static void main(String args[]) {

        int count = 0;
        File f = null;
        try {
            count = Integer.parseInt(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            f = new File(args[1]);
            Scanner fScanner = new Scanner(f);

            String[] lines = new String[count];

            for (int k = 0; k < count; k++) {
                lines[k] = fScanner.next();
            }

            String[] sortedLines = sort(lines);

            for(int x = 0; x<lines.length; x++)
                System.out.println(lines[x]);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static String[] sort(String[] arr){
        for (int j = 1; j < arr.length; j++) {
            String key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i].charAt(0) > key.charAt(0)) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
        return arr;
    }
}