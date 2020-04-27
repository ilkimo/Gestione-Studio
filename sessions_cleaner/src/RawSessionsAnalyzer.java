import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class RawSessionsAnalyzer {
    public static final String regexStr = "([0-9]+_){9}([^_]+_){4}.+";

    public static void ask_and_clean(String path) {
        Scanner t = new Scanner(System.in);
        System.out.println("Do you want to clean " + path + " before the execution (y/n)?");

        if(t.nextLine().equalsIgnoreCase("y")) {
            System.out.println("cleaning " + path + " in 5 seconds, stop execution if not wanted (ctrl-c)");

            try {
                Thread.sleep(5 * 1000);
            } catch(Exception e) {}

            clean_file(path);

            System.out.println("file " + path + " cleaned");
        }
    }

    public static void clean_file(String path) {
        try {
            new PrintWriter(path).close();
        } catch(Exception e) {
            throw new Error("File " + path + " not found");
        }
    }

    public static int n_lines(String file_path) throws Exception {
        Scanner input_stream = null;
        int counter = 0;

        try {
            input_stream = new Scanner(new File(file_path));
        } catch(Exception e) {throw e;}

        while(input_stream.hasNextLine()) {
            input_stream.nextLine();
            counter++;
        }

        input_stream.close();

        return counter;
    }

    public static void main(String[] args) throws Exception {
        if(args.length != 2) {
            throw new Exception("Exception: <inputh> <output> files are needed as arguments");
        } else {
            String matches = "null";

            ask_and_clean(args[1]);

            System.out.println("matching regex: " + regexStr);

            try {
                matches = PatternSplitter.split(args[0], args[1], regexStr);
            } catch(Exception e) {throw e;}

            System.out.println("matches: " + matches);
        }
    }
}
