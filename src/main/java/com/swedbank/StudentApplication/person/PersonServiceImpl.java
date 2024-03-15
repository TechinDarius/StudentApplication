package com.swedbank.StudentApplication.person;

import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository repository;

    @Autowired
    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> getAll() {
        List<Person> list = new ArrayList<>(repository.findAll());
        return list;
    }

    @Override
    public Person getById(long pid) throws PersonNotFoundException {
        Person person = repository.findById(pid)
                .orElseThrow(() -> new PersonNotFoundException(pid));

        return person;
    }

    @Override
    public void deleteById(Long pid) throws PersonNotFoundException {

    }
}
