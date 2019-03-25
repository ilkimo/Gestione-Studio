
public class Calendario {
    private int[] anno, mese, giorno, oraInizioSessione, mntInizioSessione, oraFineSessione, mntFineSessione, oreTimer, mntTimer;
    private String[] tipologiaStudio, luogoStudio;
    private String[][] approfondimenti, compagniaStudio;
    private int size; //ci sono elementi fino a size - 1
        //constructors--------------------------------------------------------------------------------------------------------------------------
    public Calendario() {
        this.anno = new int[Settings.initialArrDim];
        this.mese = new int[Settings.initialArrDim];
        this.giorno = new int[Settings.initialArrDim];
        this.oraInizioSessione = new int[Settings.initialArrDim];
        this.mntInizioSessione = new int[Settings.initialArrDim];
        this.oraFineSessione = new int[Settings.initialArrDim];
        this.mntFineSessione = new int[Settings.initialArrDim];
        this.oreTimer = new int[Settings.initialArrDim];
        this.mntTimer = new int [Settings.initialArrDim];
        this.tipologiaStudio = new String[Settings.initialArrDim];
        this.approfondimenti = new String[Settings.initialArrDim][Settings.dimApprofondimenti];
        this.compagniaStudio = new String[Settings.initialArrDim][Settings.dimCompagniaStudio];
        this.luogoStudio = new String[Settings.initialArrDim];
        this.size = 0;
    }
    //set e get-----------------------------------------------------------------------------------------------------------------------------
    public int getSize() {return this.size;}

    public int getAnno(int index) throws NullArrayException, IndexOutOfBoundssException {
        if(this.anno == null) {
            throw new NullArrayException("array int[] anno == null");
        } else if(index < 0 || index >= this.anno.length) {
            throw new IndexOutOfBoundssException(index + " is not a valid Index for int[] anno, wich has length = " + this.anno.length);
        }

        return this.anno[index];
    }

    public int getMese(int index) throws NullArrayException, IndexOutOfBoundssException {
        //if(this.mese != null && index < this.mese.length) return this.mese[index];
        if(this.mese == null) {
            throw new NullArrayException("array int[] mese == null");
        } else if(index < 0 || index >= this.mese.length) {
            throw new IndexOutOfBoundssException(index + " is not a valid Index for int[] mese, wich has length = " + this.mese.length);
        }

        return this.mese[index];
    }

    public int getGiorno(int index) throws NullArrayException, IndexOutOfBoundssException {
        //if(this.giorno != null && index < this.giorno.length && index >= 0) return this.giorno[index];
        if(this.giorno == null) {
            throw new NullArrayException("array int[] giorno == null");
        } else if(index < 0 || index >= this.giorno.length) {
            throw new IndexOutOfBoundssException(index + " is not a valid Index for int[] giorno, wich has length = " + this.giorno.length);
        }

        return this.giorno[index];
    }

    public int getOraInizioSessione(int index) throws NullArrayException, IndexOutOfBoundssException {
        //if(this.oraInizioSessione != null && index < this.oraInizioSessione.length && index >= 0) return this.oraInizioSessione[index];
        if(this.oraInizioSessione == null) {
            throw new NullArrayException("array int[] oraInizioSessione == null");
        } else if(index < 0 || index >= this.oraInizioSessione.length) {
            throw new IndexOutOfBoundssException(index + " is not a valid Index for int[] oraInizioSessione, wich has length = " + this.oraInizioSessione.length);
        }

        return this.oraInizioSessione[index];
    }

    public int getMntInizioSessione(int index) throws NullArrayException, IndexOutOfBoundssException {
        //if(this.mntInizioSessione != null && index < this.mntInizioSessione.length && index >= 0) return this.mntInizioSessione[index];
        if(this.mntInizioSessione == null) {
            throw new NullArrayException("array int[] mntInizioSessione == null");
        } else if(index < 0 || index >= this.mntInizioSessione.length) {
            throw new IndexOutOfBoundssException(index + " is not a valid Index for int[] mntInizioSessione, wich has length = " + this.mntInizioSessione.length);
        }

        return this.mntInizioSessione[index];
    }

    public int getOraFineSessione(int index) throws NullArrayException, IndexOutOfBoundssException {
        ///if(this.oraFineSessione != null && index < this.oraFineSessione.length && index >= 0) return this.oraFineSessione[index];
        if(this.oraFineSessione == null) {
            throw new NullArrayException("array int[] oraFineSessione == null");
        } else if(index < 0 || index >= this.oraFineSessione.length) {
            throw new IndexOutOfBoundssException(index + " is not a valid Index for int[] oraFineSessione, wich has length = " + this.oraFineSessione.length);
        }

        return this.oraFineSessione[index];
    }

    public int getMntFineSessione(int index) throws NullArrayException, IndexOutOfBoundssException {
        //if(this.mntFineSessione != null && index < this.mntFineSessione.length && index >= 0) return this.mntFineSessione[index];
        if(this.mntFineSessione == null) {
            throw new NullArrayException("array int[] mntFineSessione == null");
        } else if(index < 0 || index >= this.mntFineSessione.length) {
            throw new IndexOutOfBoundssException(index + " is not a valid Index for int[] mntFineSessione, wich has length = " + this.mntFineSessione.length);
        }

        return this.mntFineSessione[index];
    }

    public int getOreTimer(int index) throws NullArrayException, IndexOutOfBoundssException {
        //if(this. != null && index < this..length  && index >= 0) return this.[index];
        if(this.oreTimer == null) {
            throw new NullArrayException("array int[] oreTimer == null");
        } else if(index < 0 || index >= this.oreTimer.length) {
            throw new IndexOutOfBoundssException(index + " is not a valid Index for int[] oreTimer, wich has length = " + this.oreTimer.length);
        }

        return this.oreTimer[index];
    }

    public int getMntTimer(int index) throws NullArrayException, IndexOutOfBoundssException {
        //if(this.mntTimer != null && index < this.mntTimer.length && index >= 0) return this.mntTimer[index];
        if(this.mntTimer == null) {
            throw new NullArrayException("array int[] mntTimer == null");
        } else if(index < 0 || index >= this.mntTimer.length) {
            throw new IndexOutOfBoundssException(index + " is not a valid Index for int[] mntTimer, wich has length = " + this.mntTimer.length);
        }

        return this.mntTimer[index];
    }

    public String[] getapprofondimenti(int index) throws NullArrayException, IndexOutOfBoundssException {
        if(this.approfondimenti == null) {
            throw new NullArrayException("String[] approfondimenti == null");
        } else if(index < 0 || index >= this.approfondimenti.length) {
            throw new IndexOutOfBoundssException(index + " is not a valid Index for String[] approfondimenti, wich has length = " + this.approfondimenti.length);
        }

        return this.approfondimenti[index];
    }

    public String[] getCompagniaStudio(int index) throws NullArrayException, IndexOutOfBoundssException {
        if(this.compagniaStudio == null) {
            throw new NullArrayException("String[] compagniaStudio == null");
        } else if(index < 0 || index >= this.compagniaStudio.length) {
            throw new IndexOutOfBoundssException(index + " is not a valid Index for String[] compagniaStudio, wich has length = " + this.compagniaStudio.length);
        }

        return this.compagniaStudio[index];
    }

    public String getLuogoStudio(int index) throws NullArrayException, IndexOutOfBoundssException {
        if(this.luogoStudio == null) {
            throw new NullArrayException("String[] luogoStudio == null");
        } else if(index < 0 || index >= this.luogoStudio.length) {
            throw new IndexOutOfBoundssException(index + " is not a valid Index for String[] luogoStudio, wich has length = " + this.luogoStudio.length);
        }

        return this.luogoStudio[index];
    }
    //robe utili----------------------------------------------------------------------------------------------------------------------------
    public boolean full() {return size == anno.length;}

    public void extendIntArr() {
        int tmpDim = anno.length;
        int[] tmp = new int[tmpDim * 2];

        for(int i = 0; i < tmpDim; ++i){
            tmp[i] = anno[i];
        }
        anno = tmp;
        tmp = new int[tmpDim * 2];

        for(int i = 0; i < tmpDim; ++i){
            tmp[i] = mese[i];
        }
        mese = tmp;
        tmp = new int[tmpDim * 2];

        for(int i = 0; i < tmpDim; ++i){
            tmp[i] = giorno[i];
        }
        giorno = tmp;
        tmp = new int[tmpDim * 2];

        for(int i = 0; i < tmpDim; ++i){
            tmp[i] = oraInizioSessione[i];
        }
        oraInizioSessione = tmp;
        tmp = new int[tmpDim * 2];

        for(int i = 0; i < tmpDim; ++i){
            tmp[i] = mntInizioSessione[i];
        }
        mntInizioSessione = tmp;
        tmp = new int[tmpDim * 2];

        for(int i = 0; i < tmpDim; ++i){
            tmp[i] = oraFineSessione[i];
        }
        oraFineSessione = tmp;
        tmp = new int[tmpDim * 2];

        for(int i = 0; i < tmpDim; ++i){
            tmp[i] = mntFineSessione[i];
        }
        mntFineSessione = tmp;
        tmp = new int[tmpDim * 2];

        for(int i = 0; i < tmpDim; ++i){
            tmp[i] = oreTimer[i];
        }
        oreTimer = tmp;
        tmp = new int[tmpDim * 2];

        for(int i = 0; i < tmpDim; ++i){
            tmp[i] = mntTimer[i];
        }
        mntTimer = tmp;
    }

    public void extendStringArr() {
        int tmpDim = tipologiaStudio.length;
        String[] tmp = new String[tmpDim * 2];

        for(int i = 0; i < tmpDim; ++i) {
            tmp[i] = tipologiaStudio[i];
        }
        tipologiaStudio = tmp;
        tmp = new String[tmpDim * 2];

        for(int i = 0; i < tmpDim; ++i) {
            tmp[i] = luogoStudio[i];
        }
        luogoStudio = tmp;
    }

    public void extend2DStringArr() {
        int tmpDim = approfondimenti.length;
        String[][] tmp = new String[tmpDim * 2][Settings.dimApprofondimenti];

        for(int i = 0; approfondimenti != null && i < tmpDim; ++i) {
            for(int j = 0; approfondimenti[i] != null && j < approfondimenti[i].length; ++j) {
                tmp[i][j] = approfondimenti[i][j];
            }
        }
        approfondimenti = tmp;
        tmp = new String[tmpDim * 2][Settings.dimApprofondimenti];

        tmpDim = compagniaStudio.length; //sta roba non credo proprio faccia alcuna differenza, anzi la facesse sarebbe un male haha

        for(int i = 0; compagniaStudio != null && i < tmpDim; ++i) {
            for(int j = 0; compagniaStudio[i] != null && j < compagniaStudio[i].length; ++j) {
                tmp[i][j] = compagniaStudio[i][j];
            }
        }
        compagniaStudio = tmp;
    }

    public void extend() {
        extendIntArr();
        extendStringArr();
        extend2DStringArr();
    }

    private int convertToInt(String data) throws StringException {
        int res = 0;
        if(data != null){
            if(!data.matches("[0-9]+")) throw new StringException("Exception: String doesn't contain only numbers! - Calendario.convertToIntArr");

            res = Integer.parseInt(data);
        }
        return res;
    }

    public boolean addSession(String[][] session) throws StringException {
        if(full()) {extend();}

        try{
            anno[size] = convertToInt(session[0][0]);
            mese[size] = convertToInt(session[1][0]);
            giorno[size] = convertToInt(session[2][0]);

            if(session[3] != null) {oraInizioSessione[size] = convertToInt(session[3][0]);} else {oraInizioSessione[size] = -1;}
            if(session[4] != null) {mntInizioSessione[size] = convertToInt(session[4][0]);} else {mntInizioSessione[size] = -1;}
            if(session[5] != null) {oraFineSessione[size] = convertToInt(session[5][0]);} else {oraFineSessione[size] = -1;}
            if(session[6] != null) {mntFineSessione[size] = convertToInt(session[6][0]);} else {mntFineSessione[size] = -1;}
            if(session[7] != null) {oreTimer[size] = convertToInt(session[7][0]);} else {oreTimer[size] = -1;}
            if(session[8] != null) {mntTimer[size] = convertToInt(session[8][0]);} else {mntTimer[size] = -1;}

            if(session[10] != null) {tipologiaStudio[size] = session[10][0];} else {tipologiaStudio[size] = "null";}
            if(session[11] != null) {approfondimenti[size] = session[11];} else {approfondimenti[size][0] = "null";}
            if(session[12] != null) {compagniaStudio[size] = session[12];} else {compagniaStudio[size][0] = "null";}
            if(session[13] != null) {luogoStudio[size] = session[13][0];} else {luogoStudio[size] = "null";}
        }
        catch(StringException e) {throw e;}

        addSize();
        //ordina();
        //aggiorna();

        return true;
    }

    private void addSize() {
        ++size;
    }

    private void subtractSize() throws notValidSizeException {
        if(size == 0) throw new notValidSizeException("Can't do this.size--, size is already " + this.size);

        this.size--;
    }

    public static int[] addIntData(int[] arr, int data) throws NullArrayException {
        if(arr != null) {
            arr = newSize(arr, 1);
            arr[arr.length - 1] = data;
        } else {
            throw new NullArrayException("Exception: addIntData was given a null array");
        }

        return arr;
    }

    public String[] addStringData(String[] arr, String data) throws NullArrayException {
        if(arr != null) {
            arr = newSize(arr, 1);
            arr[arr.length - 1] = data;
        } else {
            throw new NullArrayException("Exception: addIntData was given a null array");
        }

        return arr;
    }

    public static int[] newSize(int[] arr, int newCells) throws NullArrayException {
        int[] newArr;

        if(arr != null){
            newArr = new int[arr.length + newCells];

            for(int i = 0; i < arr.length; ++i) {
                newArr[i] = arr[i];
            }
            //CAPIRE SE NELLE CELLE NUOVE BISOGNA METTERCI UN QUALCHE VALORE TIPO -1 O COSA
        } else {
            throw new NullArrayException("Exception: Calendario.newSize was given a null array");
        }

        return newArr;
    }

    public static String[] newSize(String[] arr, int newCells) throws NullArrayException {
        String[] newArr;

        if(arr != null){
            newArr = new String[arr.length + newCells];

            for(int i = 0; i < arr.length; ++i) {
                newArr[i] = arr[i];
            }
            //CAPIRE SE NELLE CELLE NUOVE BISOGNA METTERCI UN QUALCHE VALORE TIPO -1 O COSA
        } else {
            throw new NullArrayException("Exception: Calendario.newSize was given a null array");
        }

        return newArr;
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void print() {
        for(int i = 0; i < size; ++i) {
            print(i);
        }
    }

    public void print(int i) {
        System.out.print(anno[i]+ "/");
        System.out.print(mese[i]+ "/");
        System.out.print(giorno[i]+ " ");
        System.out.print(oraInizioSessione[i]+ ":");
        System.out.print(mntInizioSessione[i]+ "-");
        System.out.print(oraFineSessione[i]+ ":");
        System.out.print(mntFineSessione[i]+ " ");
        System.out.print(oreTimer[i]+ "h ");
        System.out.print(mntTimer[i]+ "mnt ");
        System.out.print(tipologiaStudio[i]);

    //2019\02\28 14:36-15:50 1h 8mnt "Architettura degli Elaboratori"\introduzione{Vale, compagnoUni}[aula studio Informatica]
    //2019\03\16 19:03-20:58 1h 13mnt "Architettura degli elaboratori"/teoria(Rappresentazione in Eccesso, Floating Point){Gabuz, Berru, Gio}[casa]
    //2019\01\28 1h 10mnt "Logica Matematica"\teoria
        System.out.print("(");
        for(int j = 0; j < approfondimenti[i].length && approfondimenti[i][j] != null; ++j) {
            if(j != 0) {System.out.print(", ");}
            System.out.print(approfondimenti[i][j]);
        }
        System.out.print(")");

        System.out.print("{");
        for(int j = 0; j < compagniaStudio[i].length && compagniaStudio[i][j] != null; ++j) {
            if(j != 0) {System.out.print(", ");}
            System.out.print(compagniaStudio[i][j]);
        }
        System.out.print("}");

        System.out.println("[" + luogoStudio[i]+ "]");
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
}
