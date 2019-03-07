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
    public void initializeSubject(Materia subject, String inputStr) throws FileLinesException {
        if(fileLines != null) {
            
        } else {
            throw new FileLinesException("Exception, trying to initialize calendar from fileLines == null");
        }
    }
    //TRASH------------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

    }
    //-----------------------------------------------------------------------------------------------------------------------------------
}
