package lab8_1;

public class MyDate implements Comparable<MyDate> {
    private int year = 1;
    private int month = 1;
    private int day = 1;

    public MyDate(int year, int month, int day) {
        if( DateUtil.isValidDate(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + String.format("%4s", year) +
                ", month=" + String.format("%2s", month) +
                ", day=" + String.format("%2s",day) +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        if (this.year != o.year) {
            return this.year - o.year;
        }
        if (this.month != o.month) {
            return this.month - o.month;
        }
        return this.day - o.day;
    }
}
