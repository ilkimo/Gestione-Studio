//anno\mese\giorno oraInizio:mntInizio-oraFine:mntFine oreEffettiveh minutiEffettivimnt "Materia"\ramo{Persona1, Persona2...}[luogo]
//13 colonne (al momento)
public class Materia {
    private int oreTot, oreTeor, orePrat;
    private String nomeMateria; //indeciso se mettere final (pero' in caso in cui uno scrive un nome sbagliato poi bisogna cambiare)
    private Calendario cal;
    private int size; //dimensione stack[][][] calendario, ci sono elementi fino alla riga size - 1
    //costruttori----------------------------------------------------------------------------------------------------------------------
    public Materia() {
        setOreTot(0);
        setOrePrat(0);
        setOreTeor(0);
        setNomeMateria("");
    }

    public Materia(String name) {
        setOreTot(0);
        setOrePrat(0);
        setOreTeor(0);
        setNomeMateria(name);
    }
    //set e get------------------------------------------------------------------------------------------------------------------------
private void setOreTot(int n) {this.oreTot = n; /*this. e' opzionale*/}

    private void setOreTeor(int n) {this.oreTeor = n; /*this. e' opzionale*/}

    private void setOrePrat(int n) {this.orePrat = n; /*this. e' opzionale*/}

    private void setNomeMateria(String str) {this.nomeMateria = str; /*this. e' opzionale*/}

    public int getOreTot() {return this.oreTot; /*this. e' opzionale*/}

    public int getOreTeor() {return this.oreTeor; /*this. e' opzionale*/}

    public int getOrePrat() {return this.orePrat; /*this. e' opzionale*/}

    public String getNomeMateria() {return this.nomeMateria; /*this. e' opzionale*/}

    //---------------------------------------------------------------------------------------------------------------------------------
    public void addToCalendar(String str, char regex) { //str has to be a String containing all the values to add separated by a regex
        //01RIPRENDI DA Calendario.java, poi QUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII

        //modifica size
    }
    //---------------------------------------------------------------------------------------------------------------------------------
}//sono un robo da cancellare
