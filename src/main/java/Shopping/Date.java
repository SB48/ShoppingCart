package Shopping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date  {
    public String getDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatter.format(date);
    }
}