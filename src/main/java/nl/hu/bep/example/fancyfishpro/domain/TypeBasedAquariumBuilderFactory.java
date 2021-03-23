package nl.hu.bep.example.fancyfishpro.domain;

public class TypeBasedAquariumBuilderFactory implements IAquariumBuilderFactory{

    private static TypeBasedAquariumBuilderFactory uniqueInstance;
    private String type;

    private TypeBasedAquariumBuilderFactory(String type) {
        this.type = type;
    }

    public static TypeBasedAquariumBuilderFactory getMockInstance(){
        if(uniqueInstance==null){
           uniqueInstance = new TypeBasedAquariumBuilderFactory("Mock");
        }
        return uniqueInstance;
    }


    @Override
    public IAquariumBuilder createAquariumBuilder() {
        switch (type){
            case "Mock" : return new MockAquariumBuilder();
            default: return null;
        }
    }
}
