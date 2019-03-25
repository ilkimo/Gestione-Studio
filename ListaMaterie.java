
public class ListaMaterie {
    private Materia[] subjectList;
    private int numMaterieOrdineCrono;

    //constructor----------------------------------------------------------------------------------------------------
    public ListaMaterie() {
        subjectList = new Materia[1];
        numMaterieOrdineCrono = 0;
    }
    //set e get------------------------------------------------------------------------------------------------------

    //important methods----------------------------------------------------------------------------------------------
    public void add(Materia m) {
        if(full()) {
            Materia[] tmp = new Materia[subjectList.length * 2];

            for(int i = 0; i < numMaterieOrdineCrono; ++i) {
                tmp[i] = subjectList[i];
            }
            subjectList = tmp;
        }

        subjectList[numMaterieOrdineCrono] = m;
        ++numMaterieOrdineCrono;
    }

    public boolean full() {
        return numMaterieOrdineCrono == subjectList.length;
    }
    //---------------------------------------------------------------------------------------------------------------
    public int hasSubject(String str) { //return value>0 if the given string matches a subject name in Materia[] subjectList, else returns -1
        boolean trovato = false;
        int res = -1;

        for(int i = 0; !trovato && i < numMaterieOrdineCrono; ++i) {
            if(subjectList[i].equalsIgnoreCase(str)) {
                res = i;
                trovato = true;
            }
        }

        return res;
    }

    public void addFormattedData(String[][] str) {
        int index = hasSubject(str[9][0]);

        if(index == -1) { //if given subject name doesn't exists
            add(new Materia(str[9][0]));
            index = numMaterieOrdineCrono - 1;
        }

        subjectList[index].addSession(str);
    }
    //---------------------------------------------------------------------------------------------------------------
    public int totH() {
        int ore = 0, mnt = 0;;

        for(int i = 0; i < numMaterieOrdineCrono; ++i) {
            ore += subjectList[i].getOreTot();
            mnt += subjectList[i].getMntTot();
        }

        while(mnt >= 60) {
            mnt -= 60;
            ++ore;
        }

        return ore;
    }
    //---------------------------------------------------------------------------------------------------------------
    public void print() {
        if(numMaterieOrdineCrono == 0) {
            System.out.println("Non ci sono materie salvate nella lista al momento");
        } else {
            System.out.println("___________________________________________________________________________________________________________________");
            for(int i = 0; i < numMaterieOrdineCrono; ++i) {
                if(i != 0) {System.out.println("-------------------------------------------------------------------------------------------------------------------");}
                subjectList[i].print();
            }
            System.out.println("_____________________________________FIN___________________________________________________________________________");
        }
    }
}
