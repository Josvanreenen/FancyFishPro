package nl.hu.bep.example.fancyfishpro.domain;

public interface IOwner {
    boolean addAquarium(IAquarium toAdd);
    boolean addInhabitant(IAquarium toAddTo, IInhabitant toAdd);
}
