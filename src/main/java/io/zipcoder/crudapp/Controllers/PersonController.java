package io.zipcoder.crudapp.Controllers;

import io.zipcoder.crudapp.Models.Person;
import io.zipcoder.crudapp.Services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private PersonService service;

    public PersonController(PersonService service){
        this.service = service;
    }
    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") int id){
        return new ResponseEntity<>(service.getPerson(id),HttpStatus.OK);
    }

    public ResponseEntity<Iterable<Person>> listPersons(){
        return new ResponseEntity<>(service.listPerson(),HttpStatus.OK);
    }

    @PostMapping("/people/")
    public ResponseEntity<Person> createPerson(@RequestBody Person p){

        return new ResponseEntity<>(service.createPerson(p), HttpStatus.CREATED);
    }

    @PutMapping("/people/")
    public ResponseEntity<Person> update(@RequestBody int id, Person person){
        return new ResponseEntity<>(service.updatePerson(id,person),HttpStatus.OK);
    }

    @DeleteMapping("/people/")
    public ResponseEntity<Boolean> destroy(@PathVariable("id") int id){
        return  new ResponseEntity<>(service.deletePerson(id),HttpStatus.OK);
    }



}
