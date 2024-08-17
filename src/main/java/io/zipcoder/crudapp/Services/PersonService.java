package io.zipcoder.crudapp.Services;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.zipcoder.crudapp.Models.Person;
import io.zipcoder.crudapp.Repositories.PersonRepository;

public class PersonService {
private PersonRepository repository;

public PersonService(PersonRepository repo){
    this.repository = repo;
}
 public Person createPerson(Person p){
    return repository.save(p);
 }
 public Person updatePerson(Integer id, Person p ){
    Person updPerson = new Person();
    updPerson.setFirstName(updPerson.getFirstName());
    updPerson.setLastName(updPerson.getLastName());
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
