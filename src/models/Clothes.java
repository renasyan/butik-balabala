package models;

public class Clothes {
    private final String itemName;
    private final String itemCategory;
    private final String itemPath;
    
    public Clothes(String itemName, String itemCategory, String itemPath) {
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemPath = itemPath;
    }
    public String getItemName() {
        return itemName;
    }
    public String getItemCategory() {
        return itemCategory;
    }
    public String getItemPath() {
        return itemPath;
    }



    

    
}
