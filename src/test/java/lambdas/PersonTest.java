package lambdas;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class PersonTest {
    Person person;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setup(){
        person = new Person("Daniel Day-Lewis", LocalDate.of(1957, 4, 29), Person.Sex.MALE, "DDL@yahoo.com");
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void getAge() {
        int actual = person.getAge();

        Assert.assertEquals(61, actual);
    }

    @Test
    public void printPerson() {

        person.printPerson();

        Assert.assertEquals(outContent.toString(), "Name: Daniel Day-Lewis Age: 61 Gender: MALE Email: DDL@yahoo.com" +"\n" );
    }


    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}