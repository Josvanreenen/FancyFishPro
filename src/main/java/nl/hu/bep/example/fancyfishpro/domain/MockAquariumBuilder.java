package nl.hu.bep.example.fancyfishpro.domain;

import lombok.Setter;

public class MockAquariumBuilder implements IAquariumBuilder{
    private int length=0;
    private int width=0;
    private int height=0;

    @Setter private String beddingType="";
    @Setter private String waterType="";

    @Override
    public void setDimensions(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }


    @Override
    public IAquarium build() {
        if(this.length>0 && this.width>0 && this.height>0 && !this.beddingType.isBlank() && !this.waterType.isBlank()) return new MockAquarium(this.length, this.width, this.height, this.waterType, this.beddingType);
        return null;
    }
}
