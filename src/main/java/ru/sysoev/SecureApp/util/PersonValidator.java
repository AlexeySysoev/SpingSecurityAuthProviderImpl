package ru.sysoev.SecureApp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.sysoev.SecureApp.models.Person;
import ru.sysoev.SecureApp.services.PeopleService;
import ru.sysoev.SecureApp.services.PersonDetailsService;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {
    //    private final PeopleService peopleService;
//    @Autowired
//    public PersonValidator(PeopleService peopleService) {
//        this.peopleService = peopleService;
//    }

    private final PersonDetailsService personDetailsService;
    @Autowired
    public PersonValidator(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }
    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        try {
            personDetailsService.loadUserByUsername(person.getUsername());

        } catch (UsernameNotFoundException ignored) {
            return;
        }
        errors.rejectValue("username","","man allready exists");
    }

//    @Override
//    public void validate(Object o, Errors errors) {
//        Person person = (Person) o;
//        Optional<Person> people = peopleService.findUserByPerson(person);
//        if (people.isPresent()) {
//            errors.rejectValue("username", "", "Человек с таким именем уже существует");
//        }
//
//    }
}
