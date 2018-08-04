package cloud.gateway.core.util;

import java.util.Date;


public class DateUtil {
    public static Date getCurrentDate(){
        return new Date(System.currentTimeMillis());
    }
}
