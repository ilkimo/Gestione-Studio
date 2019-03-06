
public class NumberManagement { /* Questa classe si occupa di gestire e controllare vari tipi di numeri,
                               * compresi orari in ore e minuti, conversioni, rimozione zeri a sinistra ecc.ecc.
                               */
    //Rimozione zeri a sinistra--------------------------------------------------------------------------------------------------------
    public static String removeNonSignificativeDigits(String n) {
        String res = "";
        boolean firstDigitFound = false;

        for(int i = 0; i < n.length(); ++i) {
            if(n.charAt(i) != '0') {
                firstDigitFound = true;
            }

            if(firstDigitFound) {res += n.charAt(i);}
        }

        return res;
    }
    //---------------------------------------------------------------------------------------------------------------------------------
    public static boolean validYear(String year) {

    }
    //---------------------------------------------------------------------------------------------------------------------------------

    /*public static void main(String[] args) {

    }*/
}
