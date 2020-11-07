package data.profile;

import domain.entities.profile.Person;
import domain.gateways.profile.People;

/**
 *
 * @author Administrador
 */
public class InMemoryPeople implements People {

    @Override
    public Person getPersonById(int personId) {
        Person person = new Person();
        person.setName("Leandro Reis");
        return person;
    }

}
