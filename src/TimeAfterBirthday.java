import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeAfterBirthday {

    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public static void TimeAfterBirth(LocalDateTime birthday) {
        LocalDateTime current = LocalDateTime.now();
        int amountYear = 0;
        int amountMonth = 0;
        int amountDay = 0;
        int amountHour = 0;
        int amountMinute = 0;
        int amountSecond = current.getSecond();

        amountMinute += current.getMinute() - birthday.getMinute();
        if (amountMinute < 0) {
            amountMinute += 60;
            amountHour--;
        }
        amountHour += current.getHour() - birthday.getHour();
        if (amountHour < 0) {
            amountHour += 60;
            amountDay--;
        }
        amountDay += current.getDayOfMonth() - birthday.getDayOfMonth();
        if (amountDay < 0) {
            switch (current.getMonthValue() - birthday.getMonthValue()) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10: {
                    amountDay += 31;
                    break;
                }
                case 4:
                case 6:
                case 9:
                case 11: {
                    amountDay += 30;
                    break;
                }
                case 2: {
                    if ((current.getYear() - birthday.getYear()) % 4 == 0) {
                        amountDay += 29;
                    } else {
                        amountDay += 28;
                    }
                    break;
                }

            }
            amountMonth--;
        }
        amountMonth += current.getMonthValue() - birthday.getMonthValue();
        if (amountMonth < 0) {
            amountMonth += 12;
            amountYear--;
        }
        amountYear += current.getYear() - birthday.getYear();

        System.out.printf("Вам виповнилося %d років, %d місяців, %d днів, %d годин, %d хвилин та %d секунд", amountYear, amountMonth, amountDay, amountHour, amountMinute, amountSecond);
    }

    public void getDateInfo(String date) {
        Pattern p = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.([12][90]\\d\\d)");
        Matcher m = p.matcher(date);
        m.find();
        day = Integer.parseInt(m.group(1));
        month = Integer.parseInt(m.group(2));
        year = Integer.parseInt(m.group(3));
    }

    public void getTimeInfo(String time) {
        Pattern p = Pattern.compile("([012][0-9]):([0-5][0-9])");
        Matcher m = p.matcher(time);
        m.find();
        hour = Integer.parseInt(m.group(1));
        minute = Integer.parseInt(m.group(2));
    }
}
