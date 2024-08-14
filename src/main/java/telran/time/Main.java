package telran.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

record MonthYear(int month, int year) {

}

public class Main {
    public static void main(String[] args) {
        try {
            MonthYear monthYear = getMonthYear(args);//if no arguments current year and month should be applied
            printCalendar(monthYear);
        } catch (RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    }

    private static void printCalendar(MonthYear monthYear) {
        printTitle(monthYear);
        printWeekDays();
        printDates(monthYear);
         }

    private static void printDates(MonthYear monthYear) {
        LocalDate firstDayOfMonth = LocalDate.of(monthYear.year(), monthYear.month(), 1);
        DayOfWeek dayOfWeek = firstDayOfMonth.getDayOfWeek();
        Main main = new Main();
        int offset = main.getOffset(dayOfWeek.getValue());
        int lastDay = main.getLastDayOfMonth(monthYear);

        for (int i = 0; i < offset; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= lastDay; day++) {
            System.out.printf("%4d", day);
            if ((day + offset) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void printWeekDays() {
        System.out.println(" Mon Tue Wed Thu Fri Sat Sun");
    }

    private static void printTitle(MonthYear monthYear) {
        System.out.println("\n     " + monthYear.year() + "," + " " + (getMonthName(monthYear.month())));
        System.out.println("-----------------------------");
    }

    private static MonthYear getMonthYear(String[] args) {
        MonthYear monthYear = new MonthYear(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        MonthYear monthYear_now = new MonthYear(LocalDate.now().getMonthValue(), LocalDate.now().getYear());
        return args.length == 2 ? monthYear : monthYear_now;
    }

    private int getOffset(int firstWeekDay){
        return (firstWeekDay - 1 + 7) % 7;
    }

    private int getLastDayOfMonth(MonthYear monthYear){
        YearMonth yearMonth = YearMonth.of(monthYear.year(), monthYear.month());
        return yearMonth.lengthOfMonth();
    }
    
    private static String getMonthName(int month) {
        return switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "Invalid month";
        };
    }
}
