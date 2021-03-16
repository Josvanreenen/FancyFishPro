package nl.hu.bep.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.hu.bep.example.domain.Person;
import nl.hu.bep.example.persistency.PersonRepository;

@RestController
class PersonController {

  private final PersonRepository repository;

  PersonController(PersonRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/persons")
  CollectionModel<EntityModel<Person>> all() {

  List<EntityModel<Person>> persons = repository.findAll().stream()
      .map(person -> EntityModel.of(person,
          linkTo(methodOn(PersonController.class).one(person.getId())).withSelfRel(),
          linkTo(methodOn(PersonController.class).all()).withRel("persons")))
      .collect(Collectors.toList());

  return CollectionModel.of(persons, linkTo(methodOn(PersonController.class).all()).withSelfRel());
}
  // end::get-aggregate-root[]

  @PostMapping("/persons")
  Person newPerson(@RequestBody Person newPerson) {
    return repository.save(newPerson);
  }

  // Single item

  @GetMapping("/persons/{id}")
  EntityModel one(@PathVariable Long id) { //

    Person person = repository.findById(id)
      .orElseThrow(() -> new PersonNotFoundException(id));

      return EntityModel.of(person, //
        linkTo(methodOn(PersonController.class).one(id)).withSelfRel(),
        linkTo(methodOn(PersonController.class).all()).withRel("persons"));
  }

  @PutMapping("/persons/{id}")
  Person replacePerson(@RequestBody Person newPerson, @PathVariable Long id) {

    return repository.findById(id)
      .map(Person -> {
        Person.setName(newPerson.getName());
        Person.setRole(newPerson.getRole());
        return repository.save(Person);
      })
      .orElseGet(() -> {
        newPerson.setId(id);
        return repository.save(newPerson);
      });
  }

  @DeleteMapping("/persons/{id}")
  void deletePerson(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
