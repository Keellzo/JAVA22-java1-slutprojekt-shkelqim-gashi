import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * DateAndDay klassen innehåller två funktioner som ger veckodag och datum med i som start på 1 och slut på 7
 */
class DateAndDay {
    static LocalDate calculateDate(int i) {
        return (LocalDate.now().minusDays(LocalDate.now().getDayOfWeek().getValue() - (i)));
    }

    static DayOfWeek calculateDayOfWeek(int i) {
        return LocalDate.now().getDayOfWeek().minus(LocalDate.now().getDayOfWeek().getValue()).plus(i);
    }
}
