package nl.hu.bep.example.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity //so it can be stored in a JPA-based data store
@NoArgsConstructor
class Person {

  @Getter @Setter private @Id @GeneratedValue Long id; //id is marked as identifier
  @Getter @Setter private String name;
  @Getter @Setter private String role;

/**
* a custom constructor is created when we need to create a new instance, but don’t yet have an id.
*/
  Employee(String name, String role) {

    this.name = name;
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Employee))
      return false;
    Employee employee = (Employee) o;
    return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
        && Objects.equals(this.role, employee.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.role);
  }

  @Override
  public String toString() {
    return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
  }
}
