package com.swedbank.StudentApplication.person;

public class PersonNotFoundException extends PersonException{

    public PersonNotFoundException(long pid) {
        super("Can't find person with " + pid);
    }
}
