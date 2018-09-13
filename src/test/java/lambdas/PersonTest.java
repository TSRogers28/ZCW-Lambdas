package lambdas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class PersonTest {
    Person person;

    @Before
    public void setup(){
        LocalDate birthDate = LocalDate.of(1957, 4, 29);

        person = new Person("Daniel Day-Lewis", birthDate, Person.Sex.MALE, "DDL@yahoo.com");
    }

    @Test
    public void getAge() {
        int actual = person.getAge();

        Assert.assertEquals(61, actual);
    }

    @Test
    public void printPerson() {
        String expected = "Name: Daniel Day-Lewis Age: 61 Gender: MALE Email: DDL@yahoo.com";

        Assert.assertEquals(expected, person.printPerson());
    }
}