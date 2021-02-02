//anno\mese\giorno oraInizio:mntInizio-oraFine:mntFine oreEffettiveh minutiEffettivimnt "Materia"\ramo(approondimento1, approfondimento2){Persona1, Persona2...}[luogo]
//13 colonne (al momento)
public class Materia {
    private int oreTot, mntTot, oreTeor, orePrat;
    private String nomeMateria; //indeciso se mettere final (pero' in caso in cui uno scrive un nome sbagliato poi bisogna cambiare)
    private Calendario cal;
    private int size; //dimensione stack[][][] calendario, ci sono elementi fino alla riga size - 1
    //costruttori----------------------------------------------------------------------------------------------------------------------
    public Materia() {
        setOreTot(0);
        setMntTot(0);
        setOrePrat(0);
        setOreTeor(0);
        cal = new Calendario();
        setNomeMateria("");
    }

    public Materia(String name) {
        setOreTot(0);
        setMntTot(0);
        setOrePrat(0);
        setOreTeor(0);
        cal = new Calendario();
        setNomeMateria(name);
    }
    //set e get------------------------------------------------------------------------------------------------------------------------
    private void setOreTot(int n) {this.oreTot = n; /*this. e' opzionale*/}

    private void setMntTot(int n) {this.mntTot = n;}

    private void setOreTeor(int n) {this.oreTeor = n; /*this. e' opzionale*/}

    private void setOrePrat(int n) {this.orePrat = n; /*this. e' opzionale*/}

    private void setNomeMateria(String str) {this.nomeMateria = str; /*this. e' opzionale*/}

    public int getMntTot() {return this.mntTot;}

    public int getOreTot() {return this.oreTot; /*this. e' opzionale*/}

    public int getOreTeor() {return this.oreTeor; /*this. e' opzionale*/}

    public int getOrePrat() {return this.orePrat; /*this. e' opzionale*/}

    public String getNomeMateria() {return this.nomeMateria; /*this. e' opzionale*/}

    //---------------------------------------------------------------------------------------------------------------------------------
    public boolean equalsIgnoreCase(String str) {
        return this.getNomeMateria().equalsIgnoreCase(str);
    }

    public boolean equalsIgnoreCase(Materia other) {
        return this.getNomeMateria().equalsIgnoreCase(other.getNomeMateria());
    }
    //---------------------------------------------------------------------------------------------------------------------------------
    public boolean addSession(String[][] str) {
        boolean res = false;
        try{
            res = cal.addSession(str);
            mntTot += Integer.parseInt(str[8][0]);

            while(mntTot >= 60) {
                setMntTot(mntTot - 60);
                setOreTot(oreTot + 1);
            }

            oreTot += Integer.parseInt(str[7][0]);
        }
        catch(StringException e) {System.out.println(e.getMessage());}

        return res;
    }

    public void print() {
        System.out.println(getNomeMateria() + ":");
        cal.print();
    }
    //---------------------------------------------------------------------------------------------------------------------------------
}
