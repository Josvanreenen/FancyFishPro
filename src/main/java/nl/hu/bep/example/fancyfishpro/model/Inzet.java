package nl.hu.bep.example.fancyfishpro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Inzet {

    @Id
    @GeneratedValue
    @Getter @Setter private Long id;
    @Getter @Setter private double bedrag;

}
