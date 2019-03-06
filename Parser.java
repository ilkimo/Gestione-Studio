import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;

public class Parser {
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

    private static String[] readFile(String fileName)throws FileNotFoundException, IOException {
        int fLength = fileLength(fileName);
        String[] res = new String[fLength];

        try {
            BufferedReader bf = new BufferedReader(new FileReader(fileName));

            for(int i = 0; i < fLength; ++i){
                res[i] = bf.readLine();
            }
        }
        catch (FileNotFoundException e) {throw e;}
        catch (IOException e){throw e;}

        return res;
    }

    public static void main(String[] args){ //main di prova, cancellami poi
        String nFile = "prova.txt";
        String[] strFile;
        try{
            strFile = readFile(nFile);
            System.out.println("Numero di righe: " + fileLength(nFile));

            System.out.println("Ed il contenuto del file e': ");

            for(int i = 0; i < fileLength(nFile); ++i){
                System.out.println("    " + strFile[i]);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch(IOException e) {
            System.out.println("IOException");
        }
    }
}
