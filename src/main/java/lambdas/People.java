package lambdas;

import java.util.ArrayList;
import java.util.List;

public class People {
    List<Person> people;

    public People(){
        people = new ArrayList<>();
    }

    public void addPeople(Person p){
        people.add(p);
    }

    public Person getPerson(Person p){
       return people.get(people.indexOf(p));
    }

    public List<Person> getPeople(){
        return people;
    }

    public static void printPersonsOlderThan(List<Person> people, int age) {
        for (Person p : people) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(
            List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }


    public static void printPersonsPassTester(List<Person> roster){
        class Tester implements CheckPerson{

            @Override
            public boolean test(Person p) {
                return p.getAge() > 40;
            }
        }

        Tester tester = new Tester();
        for(Person p: roster){
            if(tester.test(p)){
                p.printPerson();
            }
        }
    }

}
