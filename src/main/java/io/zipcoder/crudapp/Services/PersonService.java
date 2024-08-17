package io.zipcoder.crudapp.Services;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.zipcoder.crudapp.Models.Person;
import io.zipcoder.crudapp.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
   @Autowired
private PersonRepository repository;

public PersonService(PersonRepository repo){
    this.repository = repo;
}
public Person getPerson(int id){
    return repository.findOne(id);
}

public Iterable<Person> listPerson(){
    return repository.findAll();
}
 public Person createPerson(Person p){
    return repository.save(p);
 }
 public Person updatePerson(Integer id, Person p ){
    Person updPerson = repository.findOne(id);
    updPerson.setFirstName(p.getFirstName());
    updPerson.setLastName(p.getLastName());
      return repository.save(updPerson);
 }

public Iterable<Person> getPersonList(){
    return repository.findAll();
}

public Boolean deletePerson(int id){
    repository.delete(id);
    return true;
}


}
