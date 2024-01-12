import java.time.LocalDate;
import java.time.Period;

public class Male extends Person {
    public Male(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    @Override
    public int calculateRetirementYears() {
        return 65 - Period.between(birthDate, LocalDate.now()).getYears();
    }
}
