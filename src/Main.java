import java.time.LocalDateTime;
import java.util.Scanner;


public class Main {
    public static void main(String[] args)  {
            TimeAfterBirthday tab = new TimeAfterBirthday();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть дату вашого народження у форматі DD.MM.YYYY");
            String date = scanner.nextLine();
            tab.getDateInfo(date);
            System.out.println("Введіть час вашого народження у форматі HH:MM");
            String time = scanner.nextLine();
            tab.getTimeInfo(time);
            LocalDateTime birthday = LocalDateTime.of(tab.getYear(), tab.getMonth(), tab.getDay(), tab.getHour(), tab.getMinute());
            TimeAfterBirthday.TimeAfterBirth(birthday);
    }
}
