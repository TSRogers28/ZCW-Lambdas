package lambdas;

import java.time.LocalDate;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthDate;
    Sex gender;
    String emailAddress;

    public Person(String name, LocalDate birthDate, Sex gender, String emailAddress) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }


    public LocalDate getBirthDate(){
        return birthDate;
    }

    public int getAge(LocalDate currentDate) {
        return AgeCalculator.calculateAge(getBirthDate(), currentDate);
    }

    public void printPerson() {
        // ...
    }
}
