//anno\mese\giorno oraInizio:mntInizio-oraFine:mntFine oreEffettiveh minutiEffettivimnt "Materia"\ramo{Persona1, Persona2...}[luogo]
//13 colonne (al momento)
public class Materia {
    private int oreTot, oreTeor, orePrat;
    private String nomeMateria; //indeciso se mettere final (pero' in caso in cui uno scrive un nome sbagliato poi bisogna cambiare)
    private String[][][] calendario;
    private int size; //dimensione stack[][][] calendario, ci sono elementi fino alla riga size - 1
    public final int campi = 13, maxCompagniaStudio = 10; //posso segnare al massimo 10 persone per sessione
    //costruttori----------------------------------------------------------------------------------------------------------------------
    public Materia() {
        setOreTot(0);
        setOrePrat(0);
        setOreTeor(0);
        setNomeMateria("");
        setSize(0);
        setCalendario(getStandardSessionEmptyArr(), 1/*new String[1][this.campi][]*/);
    }

    public Materia(String name) {
        setOreTot(0);
        setOrePrat(0);
        setOreTeor(0);
        setNomeMateria(name);
        setSize(0);
        //add setCalendario
    }
    //set e get------------------------------------------------------------------------------------------------------------------------
private void setOreTot(int n) {this.oreTot = n; /*this. e' opzionale*/}

    private void setOreTeor(int n) {this.oreTeor = n; /*this. e' opzionale*/}

    private void setOrePrat(int n) {this.orePrat = n; /*this. e' opzionale*/}

    private void setNomeMateria(String str) {this.nomeMateria = str; /*this. e' opzionale*/}

    private void setCalendario(String[][][] cal, int newSize) {this.calendario = cal; setSize(newSize);}

    private void setSize(int n) {this.size = n; /*this. e' opzionale*/}

    public int getOreTot() {return this.oreTot; /*this. e' opzionale*/}

    public int getOreTeor() {return this.oreTeor; /*this. e' opzionale*/}

    public int getOrePrat() {return this.orePrat; /*this. e' opzionale*/}

    public String getNomeMateria() {return this.nomeMateria; /*this. e' opzionale*/}

    public String[][][] getCalendario() {return this.calendario; /*this e' opzionale*/}

    public int getSize() {return this.size; /*this. e' opzionale*/}

    public String[][][] getStandardSessionEmptyArr() {
        String[][][] arr = new String[1][this.campi][];

        for(int i = 0; arr != null && i < arr[1].length /*01CONTINUA DA QUIIIIIIIIIIIII*/ && i < 9; ++i) {
            arr[1]
        }

        return arr;
    }
    //---------------------------------------------------------------------------------------------------------------------------------
    public void addToCalendar(String str, char regex) { //str has to be a String containing all the values to add separated by a regex
        //02RIPRENDI DA QUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
        String[] splittedStr = str.split(regex + "");

        for(int i = 0; i < 9; ++i) {
            //this.calendario[]
        }
        //dopo aver aggiunto al calendario, modifico size
        setSize(getSize() + 1);
    }
    //---------------------------------------------------------------------------------------------------------------------------------
}
