package utils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTime {
        public static String getCurrentDate() {
            DateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy");
            Date date = new Date();
            String date1= dateFormat.format(date);
            return date1;
        }
}
