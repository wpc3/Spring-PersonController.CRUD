package io.zipcoder.crudapp.Controllers;

import io.zipcoder.crudapp.Models.Person;
import io.zipcoder.crudapp.Services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private PersonService service;

//    public PersonController(PersonController service){
//        this.service = service;
//    }


    @PostMapping("/Person/")
    public ResponseEntity<Person> createPerson(@RequestBody Person p){

        return new ResponseEntity<>(service.createPerson(p), HttpStatus.CREATED);
    }

    @PutMapping("/Person/")
    public ResponseEntity<Person> update(@RequestBody int id, Person person){
        return new ResponseEntity<>(service.updatePerson(id,person),HttpStatus.OK);
    }

    @DeleteMapping("/Person/")
    public ResponseEntity<Boolean> destroy(int id){
        return  new ResponseEntity<>(service.deletePerson(id),HttpStatus.OK);
    }



}
