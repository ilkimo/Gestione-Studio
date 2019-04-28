import java.util.Scanner;
import java.io.*;

/* AREA DEBUG:
 * (causa problemi di __) 1700_1_2_12_12_13_13_40_5_nomeMateria_esercizi_arg1, arg2, floating point, mantissa__null_aula studio
 */

public class Main {
    public static Scanner tastiera = new Scanner(System.in);
    public static ListaMaterie lista = null;
    public static final int lineFromWichFileStarts = 2, annoMinimo = 2019;

    public static String file = "TMP Tempi e materie registrate.txt";
    //-------------------------------------------------------------------------------------------------------------------------------
    public static void printInstructions() {
        System.out.println(Utility.ANSI_YELLOW + "Instructions list:" + Utility.ANSI_RESET);
        System.out.println("    - " + (char)34 + Utility.ANSI_RED + "e" + Utility.ANSI_RESET + (char)34 + " per uscire.");
        System.out.println("    - " + (char)34 + Utility.ANSI_RED + "p" + Utility.ANSI_RESET + (char)34 + " per stampare le sessioni per ogni materia");
        System.out.println("    - " + (char)34 + Utility.ANSI_RED + "toth" + Utility.ANSI_RESET + (char)34 + "per stampare il numero di ore di studio totali");
        System.out.println("    - " + (char)34 + Utility.ANSI_RED + "h nomeMateria" + Utility.ANSI_RESET + (char)34 +  " per stampare il numero di ore di studio di quella mateira, se esiste");
        System.out.println("    - " + (char)34 + Utility.ANSI_RED + "h ord cresc" + Utility.ANSI_RESET + (char)34 + "per stampare n.ore delle materie ordinate in modo crescente");
        System.out.println("    - " + (char)34 + Utility.ANSI_RED + "add S" + Utility.ANSI_RESET + (char)34 + " to add a new Session");

        System.out.println();
    }

    public static void fai(String robaDaFare) throws ProjectException {
        if(robaDaFare.equalsIgnoreCase("p")) {System.out.println("\nlista contiene: "); lista.print();}
        if(robaDaFare.equalsIgnoreCase("toth")) {System.out.println("\nTempo totale di studio: " + lista.totH() + " ore e " + lista.totMnt() + " minuti");}
        if(robaDaFare.matches("h [ a-zA-Z0-9]+") && lista.hasSubject(robaDaFare.substring(2, robaDaFare.length())) != -1) {
            int index = lista.hasSubject(robaDaFare.substring(2, robaDaFare.length()));

            System.out.print("\nDi " + robaDaFare.substring(2, robaDaFare.length()) + " hai studiato: " + lista.subjectList[index].getOreTot() + " ore");
            System.out.println(" e " + lista.subjectList[index].getMntTot() + " minuti");
        }
        if(robaDaFare.equalsIgnoreCase("h ord cresc")) {lista.printOre("ord cresc");}
        if(robaDaFare.equalsIgnoreCase("add S")) {
            try{
                lista.addSessionFromTerminal();
            }
            catch(IOException e) {System.out.println("Eccezione, correggi");}
            catch(ProjectException e) {throw e;}
        }
        if(robaDaFare.equalsIgnoreCase("mediatot")) System.out.println("Tempo totale di studio: "+ averageHours());

        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------");
        printInstructions();
        System.out.println("----------------------------------------------------------------------------------------------");
    }
    //-------------------------------------------------------------------------------------------------------------------------------
    public static String averageHours() {
        String res = "";

        /* Robe da fare:
         *   1) creare metodo che ordina il file per data e lancia errore in caso di overlapping sessions
         *   2) costruire questo metodo basandosi sul fatto che sul file si abbiano dati ordinati
         *       - utilizzare metodi (che dovrebbero gia' esistere) per ricavare totH e totMnt
         *       - prendere la data della prima sessione (ordinata) e dell'ultima, calcolare DELTA tempo
         *       - calcolare la media convertendo le ore in minuti e sommandoci i minuti, ritornare come String
         */

        return res;
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

        try                           {analyzeFile(file, lineFromWichFileStarts);}
        catch(FileNotFoundException e){System.out.println("Didn't find the file named: " + file);}
        catch(IOException e)          {System.out.println("IOException in reading file: " + file);}

        try{
            do{
                System.out.print("Next Instruction: ");
                risposta = tastiera.nextLine();
                if(!risposta.equalsIgnoreCase("e")) {fai(risposta);}
            } while(!risposta.equalsIgnoreCase("e"));
        }
        catch(ProjectException e) {System.out.println(e.getMessage());}
    }
}
