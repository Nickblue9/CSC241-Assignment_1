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

    public static String[] sort(String[] array) {
        for (int j = 1; j < array.length; j++) {
            String key = array[j];
            int i = j - 1;
            while (i >= 0 && array[i].compareTo(key)>0) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
        return array;
    }
}