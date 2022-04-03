import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

//Validates date format
public class DateServices {
    public static final String DATE_DELIM = "/";

    public static boolean is_validDate(String date){
        DateValidator d = new DateValidator("yyyy/MM/dd");
        return d.isValid(date);
    }


    private static class DateValidator{
        private String dateFormat;
    
        public DateValidator(String dateFormat) {
            this.dateFormat = dateFormat;
        }
    
        public boolean isValid(String dateStr) {
            DateFormat sdf = new SimpleDateFormat(this.dateFormat);
            sdf.setLenient(false);
            try {
                sdf.parse(dateStr);
            } catch (ParseException e) {
                return false;
            }
            return true;
        }
    }
}