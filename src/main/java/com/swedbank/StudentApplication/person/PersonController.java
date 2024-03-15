package com.swedbank.StudentApplication.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/persons")
public class PersonController {
    private PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json")
    ResponseEntity<List<Person>> getAllPersons() {
        List<Person> list = service.getAll();
        return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
    }

    @GetMapping("{pid}")
    ResponseEntity<Person> getById(@PathVariable("pid") Long pid) {
        try {
            Person person = service.getById(pid);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch
        (PersonNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{pid}")
    ResponseEntity<Void> deletePersonById(@PathVariable("pid") Long pid) {
        try {
            service.deleteById(pid);
            return ResponseEntity.noContent().build();
        } catch (PersonNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

//    @DeleteMapping("/{pid}")
//    ResponseEntity<Void> deleteById(@PathVariable("pid")Long pig){
//        try{
//            service.deleteById(pid);
//        }
//        catch  (PersonNotFoundException ex) {
//            return ResponseEntity.notFound().build();
//        }
//    }

}
