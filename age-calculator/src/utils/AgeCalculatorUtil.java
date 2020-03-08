package utils;

import java.time.LocalDate;
import java.time.Period;

/** @author monstervivi */
public class AgeCalculatorUtil {

  public static class Age {

    private int years;

    private int month;

    private int days;

    public Age() {
      this(0, 0, 0);
    }

    public Age(int years, int month, int days) {
      this.years = years;
      this.month = month;
      this.days = days;
    }

    public int getYears() {
      return years;
    }

    public void setYear(int years) {
      this.years = years;
    }

    public int getMonth() {
      return month;
    }

    public void setMonth(int month) {
      this.month = month;
    }

    public int getDays() {
      return days;
    }

    public void setDay(int days) {
      this.days = days;
    }
  }

  public static Age calculateAge(LocalDate birthDate, LocalDate currentDate) {
    if (birthDate == null && currentDate == null) {
      return new Age();
    }

    Period period = Period.between(birthDate, currentDate);

    return new Age(period.getYears(), period.getMonths(), period.getDays());
  }
}
