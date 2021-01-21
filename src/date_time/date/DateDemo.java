package date_time.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args){
        testOldDateAPI();
    }

    private static void testOldDateAPI(){
        Date d = new Date();

        Integer year =  d.getYear() + 1900;
        Integer month = d.getMonth() + 1;
        Integer day = d.getDate();
        // System.out.printf("%s-%s-%s", year, month, day);

        DateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(sdf1.format(d));
        System.out.println(sdf2.format(d));
    }

}
