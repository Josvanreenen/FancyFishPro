package nl.hu.bep.example.fancyfishpro.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class AquariumMock implements IAquarium{
    @Getter
    private List<IInhabitant> myInhabitants;

    public AquariumMock(){
        myInhabitants = new ArrayList<IInhabitant>();
    }
    @Override
    public boolean addInhabitant(IInhabitant toAdd) {
        return false;
    }

    @Override
    public boolean addAccessory(IAccessory toAdd) {
        return false;
    }

    public List<String> listAllInhabitantNames(){
        List<String> result = new ArrayList<String>();
        myInhabitants.forEach(inhabitant -> result.add(inhabitant.getName()));
        return result;
    }

}
