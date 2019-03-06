import java.lang.Integer;

public class NumberManagement { /* This class manages the numbers from dates of the year to time settings in hours
                                 * and minutes, and other stuff...
                                 */
    //Removing zeros from the left side of the number----------------------------------------------------------------------------------
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
    //Valid year check-----------------------------------------------------------------------------------------------------------------
    public static boolean validYear(String year) throws YearException { /* One year is considered valid when it's an integer > 2018*/
        int y = Integer.parseInt(removeNonSignificativeDigits(year));

        if(y < 2018) {
            throw new YearException("Year cannot be under 2018");
        }

        return true;
    }
    //---------------------------------------------------------------------------------------------------------------------------------
    public static boolean validMonth(String month) throws MonthException {
        int m = Integer.parseInt(removeNonSignificativeDigits(month));

        if(m < 1 || m > 12) {
            throw new MonthException("Month cannot be " + m);
        }

        return true;
    }
    //---------------------------------------------------------------------------------------------------------------------------------

    /*public static void main(String[] args) {

    }*/
}
