import java.io.*;

class FCopy {
    public static void main(String args[]) {
        FileInputStream fin;
        FileOutputStream fout;
        int ch, count = 0;

        // Check command line arguments
        if (args.length != 2) {
            System.out.println("Usage: java FCopy <source_file> <destination_file>");
            return;
        }

        try {
            fin = new FileInputStream(args[0]);
            fout = new FileOutputStream(args[1]);

            while ((ch = fin.read()) != -1) {
                fout.write(ch);
                count++; // byte count
            }

            fin.close();
            fout.close();

            System.out.println("File copied successfully");
            System.out.println("File size copied: " + count + " bytes");
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
