import java.time.LocalDate;
import java.time.Period;

public class Female extends Person {
    public Female(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    @Override
    public int calculateRetirementYears() {
        return 60 - Period.between(birthDate, LocalDate.now()).getYears();
    }
}
