
public class ListaMaterie {
    public Materia[] subjectList;
    private int numMaterieOrdineCrono;

    //constructor----------------------------------------------------------------------------------------------------
    public ListaMaterie() {
        subjectList = new Materia[1];
        numMaterieOrdineCrono = 0;
    }
    //set e get------------------------------------------------------------------------------------------------------
    public int getNumMaterieOrdineCrono() {
        return numMaterieOrdineCrono;
    }
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
        int ore = 0, mnt = 0;

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

    public int totMnt() {
        int ore = 0, mnt = 0;

        for(int i = 0; i < numMaterieOrdineCrono; ++i) {
            ore += subjectList[i].getOreTot();
            mnt += subjectList[i].getMntTot();
        }

        while(mnt >= 60) {
            mnt -= 60;
            ++ore;
        }

        return mnt;
    }
    //---------------------------------------------------------------------------------------------------------------
    public boolean containsIndex(int[] a, int index) {
        for(int i = 0; a != null && i < a.length; ++i) {
            if(a[i] == index) {return true;}
        }
        return false;
    }

    public void printOrdineCresc() {
        int[] indiciOrdinati = new int[numMaterieOrdineCrono];
        for(int i = 0; i < numMaterieOrdineCrono; ++i) {indiciOrdinati[i] = -1;}

        for(int i = 0; i < numMaterieOrdineCrono; ++i) {
            for(int y = 0; y < numMaterieOrdineCrono; ++y) {
                if(!containsIndex(indiciOrdinati, y)) {
                    if(indiciOrdinati[i] >= 0) {
                        if(subjectList[y].getOreTot() >= subjectList[indiciOrdinati[i]].getOreTot()) {
                            if(subjectList[y].getOreTot() == subjectList[indiciOrdinati[i]].getOreTot()) {
                                if(subjectList[y].getMntTot() > subjectList[indiciOrdinati[i]].getMntTot()) {
                                    indiciOrdinati[i] = y;
                                }
                            } else {
                                indiciOrdinati[i] = y;
                            }
                        }
                    } else {
                        indiciOrdinati[i] = y;
                    }
                }
            }
        }

        for(int i = 0; i < numMaterieOrdineCrono; ++i) {
            System.out.println(subjectList[indiciOrdinati[i]].getNomeMateria() + ": " + subjectList[indiciOrdinati[i]].getOreTot()  + " ore e " + subjectList[indiciOrdinati[i]].getMntTot()  + " minuti");
        }
    }

    public void printOre(String caso) { //wrapper
        if(numMaterieOrdineCrono == 0) {
            System.out.println("Non ci sono materie salvate nella lista al momento");
        } else {
            System.out.println("___________________________________________________________________________________________________________________");

            if(caso.equals("ord cresc")) {printOrdineCresc();}

            System.out.println("___________________________________________________________________________________________________________________");
        }
    }

    public void print() {
        if(numMaterieOrdineCrono == 0) {
            System.out.println("Non ci sono materie salvate nella lista al momento");
        } else {
            System.out.println("___________________________________________________________________________________________________________________");
            for(int i = 0; i < numMaterieOrdineCrono; ++i) {
                if(i != 0) {System.out.println("-------------------------------------------------------------------------------------------------------------------");}
                subjectList[i].print();
            }
            System.out.println("___________________________________________________________________________________________________________________");
        }
    }
}
