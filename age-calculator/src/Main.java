import java.time.LocalDate;
import utils.AgeCalculatorUtil;
import utils.AgeCalculatorUtil.Age;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    LocalDate birthDate = LocalDate.of(2020, 01, 01);
    LocalDate currentDate = LocalDate.of(2020, 03, 02);

    Age age = AgeCalculatorUtil.calculateAge(birthDate, currentDate);
    System.out.println(
        "age is years : "
            + age.getYears()
            + ", month: "
            + age.getMonth()
            + ", days : "
            + age.getDays());
  }
}
