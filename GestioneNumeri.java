
public class GestioneNumeri { /* Questa classe si occupa di gestire i vari tipi di numeri,
                               * compresi orari in ore e minuti, conversioni, rimozione zeri a sinistra ecc.ecc.
                               */
    //Rimozione zeri a sinistra--------------------------------------------------------------------------------------------------------
    public static String togliCifreNonSignificative(String n) { //tested
        String res = "";
        boolean trovataPrimaCifra = false;

        for(int i = 0; i < n.length(); ++i) {
            if(n.charAt(i) != '0') {
                trovataPrimaCifra = true;
            }

            if(trovataPrimaCifra) {res += n.charAt(i);}
        }

        return res;
    }
    //---------------------------------------------------------------------------------------------------------------------------------

    /*public static void main(String[] args) {
        String num = "000123", num2 = "123", num3 = "0123", num4 = "01203", num5 = "100023", num6 = "0102030";

        System.out.println("num vale: " + togliCifreNonSignificative(num));
        System.out.println("num2 vale: " + togliCifreNonSignificative(num2));
        System.out.println("num3 vale: " + togliCifreNonSignificative(num3));
        System.out.println("num4 vale: " + togliCifreNonSignificative(num4));
        System.out.println("num5 vale: " + togliCifreNonSignificative(num5));
        System.out.println("num6 vale: " + togliCifreNonSignificative(num6));
    }*/
}
