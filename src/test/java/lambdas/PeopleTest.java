package lambdas;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class PeopleTest {
    People people;
    Person person1;
    Person person2;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setup(){
        people = new People();
        person1 = new Person("Daniel Day-Lewis", LocalDate.of(1957, 4, 29), Person.Sex.MALE, "DDL@yahoo.com");
        person2 = new Person("Keira Knightley", LocalDate.of(1985, 3, 26), Person.Sex.FEMALE, "Keira@yahoo.com");
        people.addPeople(person1);
        people.addPeople(person2);
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void printPersonsOlderThan() {
        People.printPersonsOlderThan(people.getPeople(), 60);
        Assert.assertEquals(outContent.toString(), "Name: Daniel Day-Lewis Age: 61 Gender: MALE Email: DDL@yahoo.com" +"\n" );
    }

    @Test
    public void printPersonsWithinAgeRange() {
        People.printPersonsWithinAgeRange(people.getPeople(), 30, 65);
        Assert.assertEquals(outContent.toString(), "Name: Daniel Day-Lewis Age: 61 Gender: MALE Email: DDL@yahoo.com"
                +"\n" + "Name: Keira Knightley Age: 33 Gender: FEMALE Email: Keira@yahoo.com" +"\n");
    }

    @Test
    public void printPersonsPassTester() {
    People.printPersonsPassTester(people.getPeople());
    Assert.assertEquals(outContent.toString(), "Name: Daniel Day-Lewis Age: 61 Gender: MALE Email: DDL@yahoo.com" +"\n" );
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}