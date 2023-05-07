package university_mocks;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class PersonVerificationUtils {
    public static final Faker faker = new Faker(new Locale("pl"));
    public static final List<Person> finalListOfRandomPersons = buildListOfRandomPersons();

    static List<Person> buildListOfRandomPersons() {
        List<Person> listOfPersons = new ArrayList<>();
        Person myPerson = new Person();
        myPerson.setFirstName("Janusz");
        myPerson.setLastName("Nowak");
        myPerson.setAddress("Gdańsk");
        listOfPersons.add(myPerson);
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setFirstName(faker.name().firstName());
            person.setLastName(faker.name().lastName());
            person.setAddress(faker.address().city());
            listOfPersons.add(person);
        }
        return listOfPersons;
    }
}
