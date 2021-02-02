import java.util.Scanner;
import java.io.*;

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
    public boolean validString(String[][] str) {
        return true;
    }

    public void addSessionFromTerminal() throws IOException, ProjectException {
        // usare addFormattedData
        String[][] str = null;
        String s = "";

        do {
            Scanner t = new Scanner(System.in);

            System.out.println("Inserire 'n' per saltare un campo.");

            System.out.print("Inserire anno: ");
            String[] anno = new String[]{t.nextLine()};

            System.out.print("Inserire mese: ");
            String[] mese = new String[]{t.nextLine()};

            System.out.print("Inserire giorno: ");
            String[] giorno = new String[]{t.nextLine()};

            System.out.print("Inserire ora inizio: ");
            String[] oraInizio = new String[]{t.nextLine()};

            System.out.print("Inserire minuto inizio: ");
            String[] mntInizio = new String[]{t.nextLine()};

            System.out.print("Inserire ora fine: ");
            String[] oraFine = new String[]{t.nextLine()};

            System.out.print("Inserire minuto fine: ");
            String[] mntFine = new String[]{t.nextLine()};

            System.out.print("Inserire ore timer: ");
            String[] hTimer = new String[]{t.nextLine()};

            System.out.print("Inserire minuti timer: ");
            String[] mntTimer = new String[]{t.nextLine()};

            System.out.println("-------------------------------\nMaterie esistenti: ");
            printNomiMaterie();
            System.out.println("-------------------------------");

            System.out.print("Inserire nome materia: ");
            String[] nomeMateria = new String[]{t.nextLine()};

            while(hasSubject(nomeMateria[0]) == -1) {
                System.out.println("\n" + nomeMateria[0] + " non risulta fra le materie memorizzate fin'ora, scegliere:\n - 1 per confermare nuova materia \n - 2 per correggere");
                String scelta = t.nextLine();

                if(scelta.equals("1")) {add(new Materia(nomeMateria[0]));}
                if(scelta.equals("2")) {
                    System.out.print("Inserire nome materia: ");
                    nomeMateria[0] = t.nextLine();
                }
            }

            System.out.print("Inserire inserire tipologia di studio: ");
            String[] ramo = new String[]{t.nextLine()};

            System.out.print("Inserire argomenti studiati: ");
            String[] approfondimenti = t.nextLine().split(", ");

            System.out.print("Inserire elenco persone con cui si ha studiato: ");
            String[] compagnia = t.nextLine().split(", ");

            System.out.print("Inserire luogo dello studio: ");
            String[] luogo = new String[]{t.nextLine()};

            str = new String[14][];

            if(anno[0].equals("n")) {str[0] = null;} else {str[0] = anno;}
            if(mese[0].equals("n")) {str[1] = null;} else {str[1] = mese;}
            if(giorno[0].equals("n")) {str[2] = null;} else {str[2] = giorno;}
            if(oraInizio[0].equals("n")) {str[3] = null;} else {str[3] = oraInizio;}
            if(mntInizio[0].equals("n")) {str[4] = null;} else {str[4] = mntInizio;}
            if(oraFine[0].equals("n")) {str[5] = null;} else {str[5] = oraFine;}
            if(mntFine[0].equals("n")) {str[6] = null;} else {str[6] = mntFine;}
            if(hTimer[0].equals("n")) {str[7] = null;} else {str[7] = hTimer;}
            if(mntTimer[0].equals("n")) {str[8] = null;} else {str[8] = mntTimer;}
            if(nomeMateria[0].equals("n")) {str[9] = null;} else {str[9] = nomeMateria;}
            if(ramo[0].equals("n")) {str[10] = null;} else {str[10] = ramo;}
            if(approfondimenti[0].equals("n")) {str[11] = null;} else {str[11] = approfondimenti;}
            if(compagnia[0].equals("n")) {str[12] = null;} else {str[12] = compagnia;}
            if(luogo[0].equals("n")) {str[13] = null;} else {str[13] = luogo;}

            //System.out.println(); valutare se mettere una conferma prima di immettere la sessione
            System.out.print("Sessione aggiunta: ");
            if(anno != null) {System.out.print(anno[0] + (char)92);}
            if(mese != null) {System.out.print(mese[0] + (char)92);}
            if(giorno != null) {System.out.print(giorno[0] + " ");}
            if(oraInizio != null) {System.out.print(oraInizio[0] + ":");}
            if(mntInizio != null) {System.out.print(mntInizio[0] + (char)92);}
            if(oraFine != null) {System.out.print(oraFine[0] + ":");}
            if(mntFine != null) {System.out.print(mntFine[0] + " ");}
            if(hTimer != null) {System.out.print(hTimer[0] + "h ");}
            if(mntTimer != null) {System.out.print(mntTimer[0] + "mnt ");}
            if(nomeMateria != null) {System.out.print((char)34 + nomeMateria[0] + (char)34);}
            if(ramo != null) {System.out.print((char)92 + ramo[0] + "(");}

            for(int i = 0; approfondimenti != null && i < approfondimenti.length; ++i) {
                if(i > 0) {System.out.print(" ");}
                System.out.print(approfondimenti[i]);
            }
            System.out.print("){");

            for(int i = 0; compagnia != null && i < compagnia.length; ++i) {
                if(i > 0) {System.out.print(" ");}
                System.out.print(compagnia[i]);
            }
            System.out.print("}[ ");

            if(luogo != null) {System.out.print(luogo[0] + "]");}

            s = "";

            if(anno[0].equals("n")) {s += "null_";} else {s += anno[0] + "_";}
            if(mese[0].equals("n")) {s += "null_";} else {s += mese[0] + "_";}
            if(giorno[0].equals("n")) {s += "null_";} else {s += giorno[0] + "_";}
            if(oraInizio[0].equals("n")) {s += "null_";} else {s += oraInizio[0] + "_";}
            if(mntInizio[0].equals("n")) {s += "null_";} else {s += mntInizio[0] + "_";}
            if(oraFine[0].equals("n")) {s += "null_";} else {s += oraFine[0] + "_";}
            if(mntFine[0].equals("n")) {s += "null_";} else {s += mntFine[0] + "_";}
            if(hTimer[0].equals("n")) {s += "null_";} else {s += hTimer[0] + "_";}
            if(mntTimer[0].equals("n")) {s += "null_";} else {s += mntTimer[0] + "_";}
            if(nomeMateria[0].equals("n")) {s += "null_";} else {s += nomeMateria[0] + "_";}
            if(ramo[0].equals("n")) {s += "null_";} else {s += ramo[0] + "_";}

            for(int i = 0; approfondimenti != null && !approfondimenti[0].equals("n") && i < approfondimenti.length; ++i) {
                if(i != 0) {s += ", ";}
                s += approfondimenti[i];
            }

            if(approfondimenti != null && approfondimenti[0].equals("n")) {
                s += "null";
            } else {
                if(approfondimenti == null) throw new ProjectException("ListaMaterie.addSessionFromTerminal(): approfondimenti == null");
            }

            s += "_";

            for(int i = 0; compagnia != null && !compagnia[0].equals("n") && i < compagnia.length; ++i) {
                if(i != 0) {s += ", ";}
                s += compagnia[i];
            }

            if(compagnia != null && compagnia[0].equals("n")) {
                s += "null";
            } else {
                if(compagnia == null) throw new ProjectException("ListaMaterie.addSessionFromTerminal(): compagnia == null");
            }

            s += "_";

            if(luogo[0].equals("n")) {s += "null";} else {s += luogo[0];}
        } while (!validString(str));

        addFormattedData(str);
        try{
            Parser.writeFile(s, Main.file);
        }
        catch(IOException e) {throw e;}
    }

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

        if(index == -1) { //if given subject name doesn't exisDovreits
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
    //---------------------------------------------------------------------------------------------------------------
    public void printNomiMaterie() {
        for(int i = 0; i < numMaterieOrdineCrono; ++i) {
            System.out.println(subjectList[i].getNomeMateria());
        }
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
