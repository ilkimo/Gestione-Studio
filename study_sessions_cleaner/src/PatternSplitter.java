import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileOutputStream;

/**
 * Makes moving lines (that match a regular expression) of a file
 * into another file as easy as a function call
 */
public class PatternSplitter {
    /**
     * Reads all the lines contained in the file pointed by path_in,
     * appending the ones that match with the given regular expression to the file
     * pointed by path_out
     * @param path_in path to the input file
     * @param path_out path to the output file
     * @param regexStr a regular expression usable by Pattern.compile(String regex)
     * @throws Error if at least one of the given files does not exist
     * @throws Exception if some file isn't found after the first check which throws an Error
     */
    public static String split(String path_in, String path_out,
                            String regexStr) throws Exception {
        String splitted_and_total_lines = "null";

        if(!file_exists(path_in)) {
            throw new Error("Error: file does not exist: " + path_in);
        } else if(!file_exists(path_out)) {
            throw new Error("Error: file does not exist: " + path_out);
        } else {
            try {
                splitted_and_total_lines = start_matching(path_in, path_out, regexStr);
            } catch(Exception e) {throw e;}
        }

        return splitted_and_total_lines;
    }

    private static boolean file_exists(String path) {
        File f = new File(path);
        return f.exists() && f.isFile();
    }

    private static String start_matching(String path_in, String path_out, String regexStr) throws Exception {
        int matches = 0, total_lines = 0;
        Scanner stream_in = null;
        String file_line = "";
        ArrayList<String> not_matching_lines = new ArrayList<String>();
        Pattern pattern = Pattern.compile(regexStr);
        PrintWriter stream_out = null;

        try {
            stream_in = new Scanner(new File(path_in));
            stream_out = new PrintWriter(new FileOutputStream(path_out, true));
        } catch(Exception e) {throw e;}

        while(stream_in.hasNextLine()) {
            file_line = stream_in.nextLine();
            total_lines++;

            if(matches(file_line, pattern)) {
                matches++;

                stream_out.println(file_line);
            } else {
                not_matching_lines.add(file_line);
            }
        }

        stream_in.close();
        stream_out.close();

        try {
            rewrite_file(path_in, not_matching_lines);
        } catch(Exception e) {throw e;}

        return "" + matches + "/" + total_lines;
    }

    private static boolean matches(String str, Pattern pattern) {
        return pattern.matcher(str).matches();
    }

    private static void rewrite_file(String file, ArrayList<String> lines) throws Exception {
        PrintWriter stream_out = null;

        try {
            stream_out = new PrintWriter(file);
        } catch(Exception e) {throw e;}

        for(String str: lines) {
            stream_out.println(str);
        }

        stream_out.close();
    }
}
