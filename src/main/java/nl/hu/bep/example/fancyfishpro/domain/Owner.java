package nl.hu.bep.example.fancyfishpro.domain;

public class Owner implements IOwner{


    @Override
    public boolean addAquarium(IAquarium toAdd) {
        return false;
    }

    @Override
    public boolean addInhabitant(IAquarium toAddTo, IInhabitant toAdd) {
        return false;
    }
}
