import java.io.*;

public class Parser {
    //-----------------------------------------------------------------------------------------------------------
    private static int fileLength(String fileName)throws FileNotFoundException, IOException {
        BufferedReader bf;
        int counter = 0;

        try {
            bf = new BufferedReader(new FileReader(fileName));
            try {
                while(bf.readLine() != null) {
                    ++counter;
                }
            }
            catch (IOException e) {throw e;}
        }
        catch (FileNotFoundException e) {throw e;}

        return counter;
    }

    public static String[] readFile(String fileName)throws FileNotFoundException, IOException {
        int fLength = fileLength(fileName);
        String[] res = new String[fLength];

        try {
            BufferedReader bf = new BufferedReader(new FileReader(fileName));

            for(int i = 0; i < fLength; ++i){
                res[i] = bf.readLine();
            }
        }
        catch (FileNotFoundException e) {throw e;}
        catch (IOException e) {throw e;}

        return res;
    }
    //-----------------------------------------------------------------------------------------------------------
    public static void writeFile(String str, String file) throws IOException {
        PrintStream out = new PrintStream(new FileOutputStream(file, true));
        out.append(str + "\n");
    }
}
