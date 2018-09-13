package lambdas;

import java.time.LocalDate;
import java.time.Period;

public class Person{

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

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public Sex getGender(){return this.gender;}



    public void printPerson() {
        System.out.println("Name: " + name + " Age: " + getAge() + " Gender: " + gender + " Email: "+ emailAddress);
    }


}
