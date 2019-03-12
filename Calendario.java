
public class Calendario {
    private int[] anno, mese, giorno, oraInizioSessione, mntInizioSessione, oraFineSessione, mntFineSessione, oreTimer, mntTimer;
    private String[] ramo, compagniaStudio, luogoStudio;
    private int stack;
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
        this.stack = 0;
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
    }
    //--------------------------------------------------------------------------------------------------------------------------------------
    //FINIREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
}
