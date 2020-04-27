import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class PatternSplitter {
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

    public static boolean file_exists(String path) {
        File f = new File(path);
        return f.exists() && f.isFile();
    }

    public static String start_matching(String path_in, String path_out, String regexStr) throws Exception {
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

    public static boolean matches(String str, Pattern pattern) {
        return pattern.matcher(str).matches();
    }

    public static void rewrite_file(String file, ArrayList<String> lines) throws Exception {
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
