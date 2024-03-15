package com.swedbank.StudentApplication.person;

import java.util.List;

public interface PersonService{
    List<Person> getAll();
    Person getById (long pid) throws PersonNotFoundException;

    void deleteById(Long pid) throws PersonNotFoundException;
}
