//anno\mese\giorno oraInizio:mntInizio-oraFine:mntFine oreEffettiveh minutiEffettivimnt "Materia"\ramo{Persona1, Persona2...}[luogo]
//13 colonne (al momento)

public class ParserMateria extends Parser {
    private String[] fileLines;
    //Constructors-----------------------------------------------------------------------------------------------------------------------
    public ParserMateria() {fileLines = null;}

    public ParserMateria(String[] file) {fileLines = file; /*this. e' opzionale*/}
    //get--------------------------------------------------------------------------------------------------------------------------------
    public String[] getFileLines() {return fileLines;}
    //-----------------------------------------------------------------------------------------------------------------------------------
    /* Voglio che:
     * 2019\02\11 16:45-19:55 2h 0mnt "Matematica Discreta"{FrAccra, Cri Milanesio}[casa]
     * diventi:
     * 2019$2$11$16$45$19$55$2$0$Matematic Discreta$FrAccra, Cri Milanesio$casa
     * se ci sono campi mancanti sostituire il campo con la stringa "null"
     * (aggiungere controllo che non ci siano gia' "campoNullo" nella stringa)
     */
    public String recorsiveFunction() {return "";/*MODIFICAMI*/}

    public void initializeSubject(Materia subject, String inputStr) throws FileLinesException {
        if(fileLines != null) {
            subject.addToCalendar(recorsiveFunction(/*FARE COSE*/)/*Recorsive function doing checks and returning the string we want in the calendar*/, '$');

        } else {
            throw new FileLinesException("Exception, trying to initialize calendar from fileLines == null");
        }
    }
    //TRASH------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

    }
    //-----------------------------------------------------------------------------------------------------------------------------------
}
