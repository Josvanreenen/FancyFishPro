package nl.hu.bep.example.fancyfishpro.domain;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class MockAquarium implements IAquarium{
    private int length;
    private int width;
    private int height;

    private String waterType;
    private String beddingType;

    @Getter
    private List<IInhabitant> myInhabitants;

    public MockAquarium(){
        myInhabitants = new ArrayList<>();
    }

    public MockAquarium(int length, int width, int height, String waterType, String beddingType){
        this();
        this.length = length;
        this.width = width;
        this.height = height;
        this.waterType = waterType;
        this.beddingType = beddingType;
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
