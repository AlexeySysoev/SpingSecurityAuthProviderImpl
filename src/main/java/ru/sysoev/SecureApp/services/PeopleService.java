package ru.sysoev.SecureApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sysoev.SecureApp.models.Person;
import ru.sysoev.SecureApp.repositories.PeopleRepository;

import java.util.Optional;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;
    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
    public Optional<Person> findUserByPerson(Person person) {
        return peopleRepository.findByUsername(person.getUsername());
    }
}
