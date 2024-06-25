package ru.sysoev.SecureApp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.sysoev.SecureApp.models.Person;
import ru.sysoev.SecureApp.services.PeopleService;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {
        private final PeopleService peopleService;
    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        Optional<Person> people = peopleService.findUserByPerson(person);
        if (people.isPresent()) {
            errors.rejectValue("username", "", "Человек с таким именем уже существует");
        }
    }
}
