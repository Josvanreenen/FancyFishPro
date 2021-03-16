package nl.hu.bep.example.persistency;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.hu.bep.example.domain.Person;

interface PersonRepository extends JpaRepository<Person, Long> {

}
