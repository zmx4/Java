import java.util.*;
import java.text.*;

public class DateTimeService
{
    public String getDateTime()
    {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }

    public static void main(String[] arg)
    {
        DateTimeService ds = new DateTimeService();
        System.out.println("current time:" + ds.getDateTime());
    }
}