import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;

public class Parser {
    private static int fileLength(String fileName) {
        BufferedReader bf;
        int counter = 0;

        try {
            bf = new BufferedReader(new FileReader(fileName));
            try {
                while(bf.readLine() != null) {
                    ++counter;
                }
            }
            catch (IOException e) {
                System.out.println("IOException occurred");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return counter;
    }

    private String[] readFile(String fileName) {
        int fLength = 0;

        try {
            fLength = fileLength(fileName);
            BufferedReader bf = new BufferedReader(new FileReader(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        String[] res = new String[fLength];

        return res;
    }

    public static void main(String[] args){
        System.out.println("Numero di righe: " + fileLength("prova.txt"));
    }
}
