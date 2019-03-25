import java.util.Scanner;
import java.io.*;

public class Main {
    public static Scanner tastiera = new Scanner(System.in);
    public static ListaMaterie lista = null;
    public static final int lineFromWichFileStarts = 2, annoMinimo = 2019;

    public static String file = "TMP Tempi e materie registrate.txt";
    //-------------------------------------------------------------------------------------------------------------------------------
    public static void printInstructions() {
        System.out.println("Instructions list:");
        System.out.println("    - " + (char)34 + "exit" + (char)34 + " per uscire.");
        System.out.println("    - " + (char)34 + "print" + (char)34 + " per stampare le sessioni per ogni materia");
        System.out.println("    _ " + (char)34 + "ore tot" + (char)34 + "per stampare il numero di ore di studio totali");
    }

    public static void fai(String robaDaFare) {
        if(robaDaFare.matches("print")) {System.out.println("\nlista contiene: "); lista.print();}
        if(robaDaFare.matches("ore tot")) {System.out.println("Numero di ore di studio totali: " + lista.totH());}
    }
    //-------------------------------------------------------------------------------------------------------------------------------
    public static void printFile(String fileName) {
        String[] fileContent = null;

        try{
            fileContent = Parser.readFile(fileName);
        }
        catch(Exception e) {System.out.println("EXCEPTION");}

        for(int i = 0; fileContent != null && i < fileContent.length; ++i) {
            System.out.println(fileContent[i]);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------------
    public static void analyzeFile(String file, int fromLine) throws FileNotFoundException, IOException{ /* - reads from file
                                                   * - if (lista == null) {
                                                   * -   creates new ListaMaterie with file content
                                                   * - } else {
                                                   * -   adds to lista file content
                                                   */
        String[][][] formattedContent = null;

        try                            {formattedContent = ParserMateria.formatContent(file, fromLine);}
        catch(FileNotFoundException e) {throw e;}
        catch(IOException e)           {throw e;}

        if(formattedContent != null) {
            if(lista == null) {
                lista = new ListaMaterie();
            }

            for(int i = 0; lista != null && i < formattedContent.length; ++i) {
                lista.addFormattedData(formattedContent[i]);
                //potrei conteare le operazioni che hanno successo sfruttando il metodo booleano addFormattedData
            }
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------------
    public static void pause() {
        Scanner ts = new Scanner(System.in);

        System.out.println("\n...premere invio per continuare...\n");
        ts.nextLine();
    }

    public static void main(String[] args) {
        String risposta = "";

        printInstructions();

        System.out.println();
        //cancella 1
        System.out.println("Il file contiene:");
        printFile(file);
        System.out.println();
        pause();
        //cancella
        try                           {analyzeFile(file, lineFromWichFileStarts);}
        catch(FileNotFoundException e){System.out.println("Didn't find the file named: " + file);}
        catch(IOException e)          {System.out.println("IOException in reading file: " + file);}

        do{
            System.out.print("Next Instruction: ");
            risposta = tastiera.nextLine();
            fai(risposta);


        } while(!risposta.matches("exit"));

    }
}
