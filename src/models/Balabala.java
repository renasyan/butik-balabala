package models;

import java.util.Map;

public class Balabala {
    private String charName;
    private Map<String, Clothes> charClothes;

    public Balabala(){
        
    }

    public Balabala(String charName, Map<String, Clothes> charClothes) {
        this.charName = charName;
        this.charClothes = charClothes;
    }

    public String getCharName() {
        return charName;
    }
    public void setCharName(String charName) {
        this.charName = charName;
    }
    public Map<String, Clothes> getCharClothes() {
        return charClothes;
    }
    public void setCharClothes(Map<String, Clothes> charClothes) {
        this.charClothes = charClothes;
    }

    
    
}
