
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
        this.ramo = new String[]{"null"};
        this.compagniaStudio = new String[]{"null"};
        this.luogoStudio = new String[]{"null"};
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
    //FINIRE LE FUNZIONI GETTTTTttttttttttttt

    //--------------------------------------------------------------------------------------------------------------------------------------
    public void addSize() {
        this.size++;
    }

    public void addSession(int anno, int mese, int giorno, int oraInizioSessione, int mntInizioSessione, int oraFineSessione, int mntFineSessione, int oreTimer, int mntTimer, String ramo, String compagniaStudio, String luogoStudio) {

    }
    //FINIREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
}
