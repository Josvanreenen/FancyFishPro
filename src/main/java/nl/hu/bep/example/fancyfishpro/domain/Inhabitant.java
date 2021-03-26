package nl.hu.bep.example.fancyfishpro.domain;

import lombok.Getter;

public class Inhabitant implements IInhabitant{
    @Getter private String name;

    public Inhabitant(){
        this.name = "unnamed";
    }

    public Inhabitant(String name) {
        this.name = name;
    }
}
