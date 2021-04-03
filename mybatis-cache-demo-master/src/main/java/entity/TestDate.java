package entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @createTime:2021/03/25 16:26
 * @author:luofeng30850
 */
public class TestDate {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);

        System.out.println(format);
    }
}
