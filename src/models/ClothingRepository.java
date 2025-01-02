package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ClothingRepository {

    private static String name;
    private static String category;
    private static String imagePath;
        

    public static List<Clothes> loadClothesFromTxt(String filePath) {
        List<Clothes> clothes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Assuming CSV format: name,category,imagePath
                if (parts.length == 3) {
                    name = parts[0].trim();
                    category = parts[1].trim();
                    imagePath = parts[2].trim();
                clothes.add(new Clothes(name, category, imagePath));
            }
        }
    
    } catch (Exception e) {
        e.printStackTrace();
    }
    return clothes;
    }

    public static String getName() {
        return name;
    }


    public static String getCategory() {
        return category;
    }


    public static String getImagePath() {
        return imagePath;
    }
}