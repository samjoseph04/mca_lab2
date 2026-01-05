import java.io.*;
import java.util.*;

class FWC {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String fn;
        FileInputStream fin;
        int ch, count = 0, words = 0;
        boolean inWord = false;

        System.out.println("Enter the filename");
        fn = s.nextLine();

        try {
            fin = new FileInputStream(fn);

            while ((ch = fin.read()) != -1) {
                count++; // byte count
                System.out.print((char) ch);

                // word count logic
                if (ch == ' ' || ch == '\n' || ch == '\t') {
                    inWord = false;
                } else if (!inWord) {
                    inWord = true;
                    words++;
                }
            }

            fin.close();

            System.out.println("\nFile size : " + count + " bytes");
            System.out.println("Word count : " + words);
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
