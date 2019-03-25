//anno\mese\giorno oraInizio:mntInizio-oraFine:mntFine oreEffettiveh minutiEffettivimnt "Materia"\ramo{Persona1, Persona2...}[luogo]
//13 colonne (al momento)
import java.io.*;

public class ParserMateria extends Parser {
    private String[] fileLines;
    //Constructors-----------------------------------------------------------------------------------------------------------------------
    public ParserMateria() {fileLines = null;}

    public ParserMateria(String[] file) {fileLines = file; /*this. e' opzionale*/}
    //get--------------------------------------------------------------------------------------------------------------------------------
    public String[] getFileLines() {return fileLines;}
    //-----------------------------------------------------------------------------------------------------------------------------------
    /* Voglio che:
     * 2019\02\11 16:45-19:55 2h 0mnt "Matematica Discreta"{FrAccra, Cri Milanesio}[casa] (robe)
     * se ci sono campi mancanti sostituire il campo con la stringa "null"
     * (aggiungere controllo che non ci siano gia' "campoNullo" nella stringa)
     */

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

    /*public static String[][] formatStr(String str) throws NotPredictedCaseException {
        //2019\03\17 16:23-17:26 0h 44mnt "Architettura degli elaboratori"/teoria(Floating point - Standard IEEE754){Berru}[casa]
        String[][] formattedStr = new String[14][];
        boolean validStr = true;
        int pos, anno = 0, mese;
        String[] fAnno = new String[1], fMese = new String[1], fGiorno = new String[1];
        String[] oraIS = new String[1], mntIS = new String[1]; //oraIS = ora inizio sessione
        String[] oraFS = new String[1], mntFS = new String[1]; //FS = fine sessione
        //le stringhe contenute negli array sono == null finche' non inizializzate
        String[] oreTimer = new String[1], mntTimer = new String[1];
        String[] nomeMateria = new String[1];
        String[] tipologiaStudio = new String[1];
        String[] approfondimenti = new String[Settings.dimApprofondimenti];
        String[] compagniaStudio = new String[Settings.dimCompagniaStudio];
        String[] luogoStudio = new String[1];

        if(str != null && str != "" && str.length() > 1) { //> 1 perche' il valore a capo conta gia'

            //CONTROLLO ANNO
            pos = str.indexOf((char)92);

            String tmpStr = str.substring(0, pos); //ora contiene l'anno (se e' una stringa valida)
            fAnno[0] = tmpStr;
            int tmpNum = 0;

            if(tmpStr.matches("[0-9]+")) {
                for(int i = 0; tmpStr.length() > 0 && i < tmpStr.length(); ++i) {
                    tmpNum += ((int)tmpStr.charAt(i) - (int)'0') * Math.pow(10, tmpStr.length() - i - 1);
                }

                anno = tmpNum;

                if(tmpNum < Main.annoMinimo) {validStr = false;}
            } else {
                validStr = false;
            }

            str = str.substring(pos + 1, str.length());
            //FINE CONTROLLO ANNO

            //CONTROLLO MESE
            pos = str.indexOf((char)92);
            tmpStr = str.substring(0, pos);
            fMese[0] = tmpStr;
            mese = Integer.parseInt(tmpStr);

            if(tmpStr.matches("[0-9][0-9]")) {
                tmpNum = 0;

                for(int i = 0; i < tmpStr.length(); ++i) {
                    tmpNum += ((int)tmpStr.charAt(i) - (int)'0') * Math.pow(10, tmpStr.length() - 1 - 1);
                }

                if(tmpNum > 12) {validStr = false;}
            } else {
                validStr = false;
            }

            //FINE CONTROLLO MESE

            str = str.substring(pos + 1, str.length());

            //CONTROLLO GIORNO
            pos = str.indexOf(' ');

            if(str.substring(0, pos).matches("[0-9]+") && Integer.parseInt(str.substring(0, pos)) <= nDays(mese, bisestile(anno))) {
                fGiorno[0] = str.substring(0, pos);
            } else {
                validStr = false;
            }
            //FINE CONTROLLO GIORNO
            str = str.substring(pos + 1, str.length());

            //CONTROLLO EVENTUALI ORA INIZIO E FINE E ROBE
            pos = str.indexOf(' ');
            tmpStr = str.substring(0, pos);

            if(tmpStr.matches("[0-9]+:[0-9]+-[0-9]+:[0-9]+")) {
                oraIS[0] = tmpStr.substring(0, tmpStr.indexOf(":"));
                mntIS[0] = tmpStr.substring(tmpStr.indexOf(":") + 1, tmpStr.indexOf("-"));

                tmpStr = tmpStr.substring(tmpStr.indexOf("-") + 1, tmpStr.length());

                oraFS[0] = tmpStr.substring(0, tmpStr.indexOf(":"));
                mntFS[0] = tmpStr.substring(tmpStr.indexOf(":") + 1, tmpStr.length());

                str = str.substring(pos + 1, str.length());
            } //campo non obbligatorio, niente else validStr = false;

            pos = str.indexOf(' ');
            tmpStr = str.substring(0, pos);

            if(tmpStr.matches("[0-9]+h")) {
                oreTimer[0] = tmpStr.substring(0, tmpStr.length() - 1);
            } else {
                validStr = false;
            }
            str = str.substring(pos + 1, str.length());

            pos = str.indexOf(' ');
            tmpStr = str.substring(0, pos);

            if(tmpStr.matches("[0-9]+mnt")) {
                mntTimer[0] = tmpStr.substring(0, tmpStr.length() - 3);
            } else {
                validStr = false;
            }

            str = str.substring(pos + 2, str.length()); //+2 perche' oltre al separatore ci sono le aperte virgolette

            pos = str.indexOf("\""); // sta roba e' utile

            tmpStr = str.substring(0, pos);

            if(tmpStr.length() > 0) {
                nomeMateria[0] = tmpStr;
            } else {
                validStr = false;
            }

            str = str.substring(pos + 2, str.length()); //per via dei 2 caratteri che separano dal campo dopo
            //System.out.println("str:" + str);
            if(str.indexOf("(") != -1 && str.indexOf(")") != -1) {
                String approfondiM = str.substring(str.indexOf("(") + 1, str.indexOf(")")); //[inclusive, exclusive]
                String[] approfondimentiTMP = approfondiM.split(", ");

                for(int i = 0; i < approfondimentiTMP.length; ++i) {
                    approfondimenti[i] = approfondimentiTMP[i];
                }

                if(approfondimentiTMP.length > approfondimenti.length) {throw new NotPredictedCaseException("Excpetion: too many arguments between ()");}

                str = removeStr(str, '(', ')');
            }


            if(str.indexOf("{") != -1 && str.indexOf("}") != -1) {
                String compagniaSt = str.substring(str.indexOf("{") + 1, str.indexOf("}"));
                String[] compagniaStudioTMP = compagniaSt.split(", ");

                for(int i = 0; i < compagniaStudioTMP.length; ++i) {
                    compagniaStudio[i] = compagniaStudioTMP[i];
                }

                if(compagniaStudioTMP.length > compagniaStudio.length) {throw new NotPredictedCaseException("Excpetion: too many arguments between {}");}

            }

            if(str.indexOf("[") != -1 && str.indexOf("]") != -1) {
                luogoStudio[0] = str.substring(str.indexOf("[") + 1, str.indexOf("]"));

                str = removeStr(str, '[', ']');
            }
        }

        if(validStr) {
            tipologiaStudio[0] = str;

            formattedStr[0] = fAnno;
            formattedStr[1] = fMese;
            formattedStr[2] = fGiorno;
            formattedStr[3] = oraIS;
            formattedStr[4] = mntIS;
            formattedStr[5] = oraFS;
            formattedStr[6] = mntFS;
            formattedStr[7] = oreTimer;
            formattedStr[8] = mntTimer;
            formattedStr[9] = nomeMateria;
            formattedStr[10] = tipologiaStudio;
            formattedStr[11] = approfondimenti;
            formattedStr[12] = compagniaStudio;
            formattedStr[13] = luogoStudio;
        } else {
            System.out.println("NOT VALID STRING, FARE QUALCOSA");
        }
        return formattedStr;
    }*/
//2019-03-16-19-03-20-58-1-13-Architettura degli elaboratori-teoria-Rappresentazione in Eccesso, Floating Point-Gabuz, Berru, Gio-casa
    public static String[][] formatStr(String str) { //11 e 12 index
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
    //TRASH------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        String[][][] prova;

        try{
            prova = formatContent(Main.file, 2);
        }
        catch(Exception e) {System.out.println(e.getMessage());}
    }
    //-----------------------------------------------------------------------------------------------------------------------------------
}
