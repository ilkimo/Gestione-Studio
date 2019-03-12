
public class Calendario {
    private int[] anno, mese, giorno, oraInizioSessione, mntInizioSessione, oraFineSessione, mntFineSessione, oreTimer, mntTimer;
    private String[] ramo, compagniaStudio, luogoStudio;
    private int size; //ci sono elementi fino a size - 1
        //constructors--------------------------------------------------------------------------------------------------------------------------
    Calendario() {
        this.anno = new int[]{-1};
        this.mese = new int[]{-1};
        this.giorno = new int[]{-1};
        this.oraInizioSessione = new int[]{-1};
        this.mntInizioSessione = new int[]{-1};
        this.oraFineSessione = new int[]{-1};
        this.mntFineSessione = new int[]{-1};
        this.oreTimer = new int[]{-1};
        this.mntTimer = new int[]{-1};
        this.ramo = new String[]{"null"};
        this.compagniaStudio = new String[]{"null"};
        this.luogoStudio = new String[]{"null"};
        this.size = 0;
    }

    Calendario(int anno, int mese, int giorno, int oraInizioSessione, int mntInizioSessione, int oraFineSessione, int mntFineSessione, int oreTimer, int mntTimer, String ramo, String compagniaStudio, String luogoStudio) {
        this.anno = new int[]{anno};
        this.mese = new int[]{mese};
        this.giorno = new int[]{giorno};
        this.oraInizioSessione = new int[]{oraInizioSessione};
        this.mntInizioSessione = new int[]{mntInizioSessione};
        this.oraFineSessione = new int[]{oraFineSessione};
        this.mntFineSessione = new int[]{mntFineSessione};
        this.oreTimer = new int[]{oreTimer};
        this.mntTimer = new int[]{mntTimer};
        this.ramo = new String[]{ramo};
        this.compagniaStudio = new String[]{compagniaStudio};
        this.luogoStudio = new String[]{luogoStudio};
        this.size = 1;
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

    public String getRamo(int index) throws NullArrayException, IndexOutOfBoundssException {
        if(this.ramo == null) {
            throw new NullArrayException("String[] ramo == null");
        } else if(index < 0 || index >= this.ramo.length) {
            throw new IndexOutOfBoundssException(index + " is not a valid Index for String[] ramo, wich has length = " + this.ramo.length);
        }

        return this.ramo[index];
    }

    public String getCompagniaStudio(int index) throws NullArrayException, IndexOutOfBoundssException {
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
    private void addSize() {
        this.size++;
    }

    private void subtractSize() throws notValidSizeException {
        if(size == 0) throw new notValidSizeException("Can't do this.size--, size is already " + this.size);

        this.size--;
    }

    public void addSession(int anno, int mese, int giorno, int oraInizioSessione, int mntInizioSessione, int oraFineSessione, int mntFineSessione, int oreTimer, int mntTimer, String ramo, String compagniaStudio, String luogoStudio) {
        //RIPRENDI DA QUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
        
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
}
