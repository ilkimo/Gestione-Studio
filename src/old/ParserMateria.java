//anno/mese/giorno oraInizio:mntInizio-oraFine:mntFine oreEffettiveh minutiEffettivimnt "Materia"\ramo(approfondimento1, approfondimento2){Persona1, Persona2...}[luogo]
//14 colonne (al momento)
import java.io.*;

public class ParserMateria extends Parser {
    private String[] fileLines;
    //Constructors-----------------------------------------------------------------------------------------------------------------------
    public ParserMateria() {fileLines = null;}

    public ParserMateria(String[] file) {fileLines = file; /*this. e' opzionale*/}
    //get--------------------------------------------------------------------------------------------------------------------------------
    public String[] getFileLines() {return fileLines;}
    //-----------------------------------------------------------------------------------------------------------------------------------
    public void initializeSubject(Materia subject, String inputStr) throws FileLinesException {
        if(fileLines != null) {
            //contollo sulla stringa e aggiunta dei campi

        } else {
            throw new FileLinesException("Exception, trying to initialize calendar from fileLines == null");
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------------------
    public static boolean requisitiMinimi(String str) {
        //REQUISITI MINIMI:  ANNO\MESE\GIORNO hTimer mntTimer "Materia"
        boolean res = true;

        //controllo se prima del primo \ ci sono solo caratteri numerici
        int pos = str.indexOf((char)92);
        str = str.substring(0, pos);

        if(str.matches("[0-9]+")) {

        } else {

        }

        return res;
    }

    public static boolean bisestile(int year) {
        boolean res = false;

        if(year % 4 == 0) {
            if(year % 100 == 0) {
                if(year % 400 == 0) {res = true;}
            } else {
                res = true;
            }
        }

        return res;
    }

    public static int nDays(int month, boolean bisestile) {
        int res = 0;

        switch(month) {
            case 1:
                res = 31;

                break;
            case 2:
                if(bisestile) {
                    res = 29;
                } else {
                    res = 28;
                }
                break;
            case 3:
                res = 31;

                break;
            case 4:
                res = 30;

                break;
            case 5:
                res = 31;

                break;
            case 6:
                res = 30;

                break;
            case 7:
                res = 31;

                break;
            case 8:
                res = 31;

                break;
            case 9:
                res = 30;

                break;
            case 10:
                res = 31;

                break;
            case 11:
                res = 30;

                break;
            case 12:
                res = 31;
                break;
        }

        return res;
    }

    public static String removeStr(String str, char bi, char ei) { //bi = begin index, ei = end index of what you have to remove
        String tmp = "";

        for(int i = 0; i < str.length(); ++i) {
            if(i < str.indexOf(bi) || i > str.indexOf(ei)) {
                tmp += str.charAt(i);
            }
        }

        return tmp;
    }

    public static String[][] formatStr(String str) {
        String[][] res = new String[14][];
        String[] splittedStr = str.split("_");

        String[] approfondimenti = splittedStr[11].split(", "), compagniaStudio = splittedStr[12].split(", ");

        if(splittedStr[0].equals("null")) {res[0] = null;} else {res[0] = new String[]{splittedStr[0]};}
        if(splittedStr[1].equals("null")) {res[1] = null;} else {res[1] = new String[]{splittedStr[1]};}
        if(splittedStr[2].equals("null")) {res[2] = null;} else {res[2] = new String[]{splittedStr[2]};}
        if(splittedStr[3].equals("null")) {res[3] = null;} else {res[3] = new String[]{splittedStr[3]};}
        if(splittedStr[4].equals("null")) {res[4] = null;} else {res[4] = new String[]{splittedStr[4]};}
        if(splittedStr[5].equals("null")) {res[5] = null;} else {res[5] = new String[]{splittedStr[5]};}
        if(splittedStr[6].equals("null")) {res[6] = null;} else {res[6] = new String[]{splittedStr[6]};}
        if(splittedStr[7].equals("null")) {res[7] = null;} else {res[7] = new String[]{splittedStr[7]};}
        if(splittedStr[8].equals("null")) {res[8] = null;} else {res[8] = new String[]{splittedStr[8]};}
        if(splittedStr[9].equals("null")) {res[9] = null;} else {res[9] = new String[]{splittedStr[9]};}
        if(splittedStr[10].equals("null")) {res[10] = null;} else {res[10] = new String[]{splittedStr[10]};}
        if(approfondimenti[0] == null) {res[11] = null;} else {res[11] = approfondimenti;}
        if(compagniaStudio[0] == null) {res[12] = null;} else {res[12] = compagniaStudio;}
        if(splittedStr[13].equals("null")) {res[13] = null;} else {res[13] = new String[]{splittedStr[13]};}


        return res;
    }

    public static String[][][] formatContent(String fileName, int fromLine) throws FileNotFoundException, IOException {
        String[] fileContent = null;
        String[][][] formattedContent = null;

        try {fileContent = readFile(fileName);}
        catch(FileNotFoundException e) {throw e;}
        catch(IOException e) {throw e;}

        if(fileContent != null) {
            formattedContent = new String[fileContent.length - fromLine][][];

            for(int i = fromLine; fileContent != null && i < fileContent.length; ++i) {
                try {
                    formattedContent[i - fromLine] = formatStr(fileContent[i]);
                }
                catch(Exception e) {System.out.println(e.getMessage());}
            }
        }

        return formattedContent;
    }
}
