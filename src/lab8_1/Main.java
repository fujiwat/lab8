package lab8_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<MyDate> dates = new ArrayList<>();
        Random rand = new Random();
        while (dates.size() < 10) {
            int year = 2021;
            int month = rand.nextInt(12)+1;
            int day = rand.nextInt(28)+1;
            if (DateUtil.isValidDate(year, month, day)) {
                dates.add(new MyDate(year, month, day));
            }
        }
        System.out.println(dates);
        Collections.sort(dates);
        System.out.println(dates);
    }
}
