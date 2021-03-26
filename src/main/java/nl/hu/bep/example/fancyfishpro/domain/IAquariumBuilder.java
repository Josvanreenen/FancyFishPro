package nl.hu.bep.example.fancyfishpro.domain;

public interface IAquariumBuilder {
    void setDimensions(int length, int width, int height);
    void setBeddingType(String beddingType);
    void setWaterType(String waterType);
    IAquarium build();
}
