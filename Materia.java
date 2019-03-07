//anno\mese\giorno oraInizio:mntInizio-oraFine:mntFine oreEffettiveh minutiEffettivimnt "Materia"\ramo{Persona1, Persona2...}[luogo]
//13 colonne (al momento)
public class Materia {
    private int oreTot, oreTeor, orePrat;
    private String nomeMateria; //indeciso se mettere final (pero' in caso in cui uno scrive un nome sbagliato poi bisogna cambiare)
    private String[][][] calendario;
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
    private void setOreTot(int n) {oreTot = n; /*this. e' opzionale*/}

    private void setOreTeor(int n) {oreTeor = n; /*this. e' opzionale*/}

    private void setOrePrat(int n) {orePrat = n; /*this. e' opzionale*/}

    private void setNomeMateria(String str) {nomeMateria = str; /*this. e' opzionale*/}

    private void setCalendario(String[][][] cal) {calendario = cal;}

    public int getOreTot() {return oreTot; /*this. e' opzionale*/}

    public int getOreTeor() {return oreTeor; /*this. e' opzionale*/}

    public int getOrePrat() {return orePrat; /*this. e' opzionale*/}

    public String getNomeMateria() {return nomeMateria; /*this. e' opzionale*/}

    public String[][][] getCalendario() {return calendario; /*this e' opzionale*/}
    //---------------------------------------------------------------------------------------------------------------------------------
}
