package nl.hu.bep.example.fancyfishpro.domain;

import lombok.Getter;

public class InhabitantMock implements IInhabitant{
    @Getter private String name;
    @Getter private String color; //possible colors
    @Getter private double size; //size in centimeters

}
