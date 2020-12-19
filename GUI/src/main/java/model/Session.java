package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.regex.Pattern;

public class Session implements Comparable<Session> {
    public static final String regexStr = "([0-9]+_){9}([^_]+_){4}.+";
    public static final Pattern pattern = Pattern.compile(regexStr);
    
    private final StringProperty year = new SimpleStringProperty();
    private final StringProperty month = new SimpleStringProperty();
    private final StringProperty day = new SimpleStringProperty();
    private final StringProperty beginHour = new SimpleStringProperty();
    private final StringProperty beginMinute = new SimpleStringProperty();
    private final StringProperty endHour = new SimpleStringProperty();
    private final StringProperty endMinute = new SimpleStringProperty();
    private final StringProperty timerHours = new SimpleStringProperty();
    private final StringProperty timerMinutes = new SimpleStringProperty();
    private final StringProperty subject = new SimpleStringProperty();
    private final StringProperty subjectBranch = new SimpleStringProperty();
    private final StringProperty subjectArgumentsList = new SimpleStringProperty();
    private final StringProperty studyGroup = new SimpleStringProperty();
    private final StringProperty place = new SimpleStringProperty();
    /**
     * Takes a formatted String containing the session information and creates a Session object
     * @param formattedString is expected to be like "2020_10_25_9_05_10_40_1_15_Programmazione_teoria_MVC_n_casa"
     * */
    public Session(String formattedString) throws Exception {
        if(!isValidString(formattedString)) {
            throw new Exception("Exception: given string didn't respect pattern: " + regexStr);
        }
        
        String[] values = formattedString.split("_");
        
        setYear(values[0]);
        setMonth(values[1]);
        setDay(values[2]);
        setBeginHour(values[3]);
        setBeginMinute(values[4]);
        setEndHour(values[5]);
        setEndMinute(values[6]);
        setTimerHours(values[7]);
        setTimerMinutes(values[8]);
        setSubject(values[9]);
        setSubjectBranch(values[10]);
        setSubjectArgumentsList(values[11]);
        setStudyGroup(values[12]);
        setPlace(values[13]);
    }
    
    //Property + set() get() ---------------------------------------------------------------
    public final StringProperty yearProperty() {
        return this.year;
    }
    
    public final String getYear() {
        return this.yearProperty().get();
    }
    
    public final void setYear(final String year) {
        this.yearProperty().set(year);
    }
    
    public final StringProperty monthProperty() {
        return this.month;
    }
    
    public final String getMonth() {
        return this.monthProperty().get();
    }
    
    public final void setMonth(final String month) {
        this.monthProperty().set(month);
    }
    
    public final StringProperty dayProperty() {
        return this.day;
    }
    
    public final String getDay() {
        return this.dayProperty().get();
    }
    
    public final void setDay(final String day) {
        this.dayProperty().set(day);
    }
    
    public final StringProperty beginHourProperty() {
        return this.beginHour;
    }
    
    public final String getBeginHour() {
        return this.beginHourProperty().get();
    }
    
    public final void setBeginHour(final String beginHour) {
        this.beginHourProperty().set(beginHour);
    }
    
    public final StringProperty beginMinuteProperty() {
        return this.beginMinute;
    }
    
    public final String getBeginMinute() {
        return this.beginMinuteProperty().get();
    }
    
    public final void setBeginMinute(final String beginMinute) {
        this.beginMinuteProperty().set(beginMinute);
    }
    
    public final StringProperty endHourProperty() {
        return this.endHour;
    }
    
    public final String getEndHour() {
        return this.endHourProperty().get();
    }
    
    public final void setEndHour(final String endHour) {
        this.endHourProperty().set(endHour);
    }
    
    public final StringProperty endMinuteProperty() {
        return this.endMinute;
    }
    
    public final String getEndMinute() {
        return this.endMinuteProperty().get();
    }
    
    public final void setEndMinute(final String endMinute) {
        this.endMinuteProperty().set(endMinute);
    }
    
    public final StringProperty timerHoursProperty() {
        return this.timerHours;
    }
    
    public final String getTimerHours() {
        return this.timerHoursProperty().get();
    }
    
    public final void setTimerHours(String timerHours) {
        this.timerHoursProperty().set(timerHours);
    }
    
    public final StringProperty timerMinutesProperty() {
        return this.timerMinutes;
    }
    
    public final String getTimerMinutes() {
        return this.timerMinutesProperty().get();
    }
    
    public final void setTimerMinutes(String timerMinutes) {
        this.timerMinutesProperty().set(timerMinutes);
    }
    
    public final StringProperty subjectProperty() {
        return this.subject;
    }
    
    public final String getSubject() {
        return this.subjectProperty().get();
    }
    
    public final void setSubject(String subject) {
        this.subjectProperty().set(subject);
    }
    
    public final StringProperty subjectBranchProperty() {
        return this.subjectBranch;
    }
    
    public final String getSubjectBranch() {
        return this.subjectBranchProperty().get();
    }
    
    public final void setSubjectBranch(String subjectBranch) {
        this.subjectBranchProperty().set(subjectBranch);
    }
    
    public final StringProperty subjectArgumentsListProperty() {
        return this.subjectArgumentsList;
    }
    
    public final String getSubjectArgumentsList() {
        return this.subjectArgumentsListProperty().get();
    }
    
    public final void setSubjectArgumentsList(String subjectArgumentsList) {
        this.subjectArgumentsListProperty().set(subjectArgumentsList);
    }
    
    public final StringProperty studyGroupProperty() {
        return this.studyGroup;
    }
    
    public final String getStudyGroup() {
        return this.studyGroupProperty().get();
    }
    
    public final void setStudyGroup(String studyGroup) {
        this.studyGroupProperty().set(studyGroup);
    }
    
    public final StringProperty placeProperty() {
        return this.place;
    }
    
    public final String getPlace() {
        return this.placeProperty().get();
    }
    
    public final void setPlace(String place) {
        this.placeProperty().set(place);
    }
    
    //END:Property + set() get() ---------------------------------------------------------------
    @Override
    public int compareTo(Session other) {
        int res = -1;
        
        if((other != null) && (other instanceof Session)) {
            if(this.getYear().compareTo(other.getYear()) == 0) {
                if(this.getMonth().compareTo(other.getMonth()) == 0) {
                    if(this.getDay().compareTo(other.getDay()) == 0) {
                        if(this.getBeginHour().compareTo(other.getBeginHour()) == 0) {
                            if(this.getBeginMinute().compareTo(other.getBeginMinute()) == 0) {
                                return 0;
                            } else {
                                res = this.getBeginMinute().compareTo(other.getBeginMinute());
                            }
                        } else {
                            res = this.getBeginHour().compareTo(other.getBeginHour());
                        }
                    } else {
                        res = this.getDay().compareTo(other.getDay());
                    }
                } else {
                    res = this.getMonth().compareTo(other.getMonth());
                }
            } else {
                res = this.getYear().compareTo(other.getYear());
            }
        }
    
    
        return res;
    }
    
    private static boolean isValidString(String formattedString) {
        return pattern.matcher(formattedString).matches();
    }
    
    @Override
    public String toString() {
        return  getYear()         + "/" +
                getMonth()        + "/" +
                getDay()          + " [" +
                getBeginHour()    + ":" +
                getBeginMinute()  + ", " +
                getEndHour()      + ":" +
                getEndMinute()    + "] " +
                "study time = "   +
                getTimerHours()   + "h:" +
                getTimerMinutes() + "mnt" +
                " | subject = " + getSubject() +
                " | branch = " + getSubjectBranch() +
                " | arguments = " + getSubjectArgumentsList() +
                " | study group = " + getStudyGroup() +
                " | place = " + getPlace();
    }
}
