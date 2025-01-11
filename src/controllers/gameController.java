package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import models.Clothes;


public class gameController implements interfaceBalabala {

    @FXML
    private AnchorPane root;

    @FXML
    private ComboBox<String> accCB;
    
    @FXML
    private ComboBox<String> characterCB;
    
    @FXML
    private ComboBox<String> ekspressionCB;

    @FXML
    private ComboBox<String> skinToneCB;

    @FXML
    private ComboBox<String> customCB;

    @FXML
    private ImageView accImage;

    @FXML
    private Tab accTab;

    @FXML
    private Button addBTN;

    @FXML
    private ImageView baseImage;

    @FXML
    private ImageView charImage;


    @FXML
    private ImageView customImage;

    @FXML
    private Button downloadBTN;

    @FXML
    private ImageView faceImage;

    

    private final ObservableList<Clothes> items = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        // Set initial images for layers
        loadDataFromFile();
        skinComboBox();
        charComboBox();
        ekspressionComboBox();
        customComboBox();
        accComboBox();

    }

    @FXML
    void displaySkinTone(ActionEvent event) {        
        String selectedName = skinToneCB.getSelectionModel().getSelectedItem();
        if (selectedName != null) {
            for (Clothes item : items) {
                if (selectedName.equals(item.getItemName()) && "base".equalsIgnoreCase(item.getItemCategory())) {
                    baseImage.setImage(new Image(item.getItemPath()));
                    // System.out.println("Selected Path: " + item.getItemPath());
                    break;
                }
            }
        }
    }

    @FXML
    void displayChar(ActionEvent event) {      
        String selectedName = characterCB.getSelectionModel().getSelectedItem();
        if (selectedName != null) {
            for (Clothes item : items) {
                if (selectedName.equals(item.getItemName()) && "tipe".equalsIgnoreCase(item.getItemCategory())) {
                    charImage.setImage(new Image(item.getItemPath()));
                    // System.out.println("Selected Path: " + item.getItemPath());
                    break;
                }
            }
        }
        
    }
    
    @FXML
    void displayCustom(ActionEvent event) {
        String selectedName = customCB.getSelectionModel().getSelectedItem();
        if (selectedName != null) {
            for (Clothes item : items) {
                if (selectedName.equals(item.getItemName()) && "baju".equalsIgnoreCase(item.getItemCategory())) {
                    customImage.setImage(new Image(item.getItemPath()));
                    // System.out.println("Selected Path: " + item.getItemPath());
                    break;
                }
            }
        }
    }

    @FXML
    void displayAcc(ActionEvent event) {
        String selectedName = accCB.getSelectionModel().getSelectedItem();
        if (selectedName != null) {
            for (Clothes item : items) {
                if (selectedName.equals(item.getItemName()) && "acc".equalsIgnoreCase(item.getItemCategory())) {
                    accImage.setImage(new Image(item.getItemPath()));
                    // System.out.println("Selected Path: " + item.getItemPath());
                    break;
                }
            }
        }
    }

    @FXML
    void displayEx(ActionEvent event) {      
        String selectedName = ekspressionCB.getSelectionModel().getSelectedItem();
        if (selectedName != null) {
            for (Clothes item : items) {
                if (selectedName.equals(item.getItemName()) && "expression".equalsIgnoreCase(item.getItemCategory())) {
                    faceImage.setImage(new Image(item.getItemPath()));
                    // System.out.println("Selected Path: " + item.getItemPath());
                    break;
                }
            }
        }

    }

    @Override
    public void loadDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("assets/db.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    items.add(new Clothes(parts[0].trim(), parts[1].trim(), parts[2].trim()));
                    // System.out.println("Loaded: " + parts[0] + ", " + parts[1] + ", " + parts[2]);
                }
            }
            System.err.println(items.get(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void skinComboBox() {
        ObservableList<String> skinNames = FXCollections.observableArrayList();
        System.out.println("Skin ComboBox");
        for (Clothes item : items) {
            if ("base".equalsIgnoreCase(item.getItemCategory())) {
                skinNames.add(item.getItemName());
                // System.out.println("Added to ComboBox: " + item.getItemName());
            }
        }
        skinToneCB.setItems(skinNames);
    }

    @Override
    public void charComboBox() {
        ObservableList<String> charNames = FXCollections.observableArrayList();
        System.out.println("Skin ComboBox");
        for (Clothes item : items) {
            if ("tipe".equalsIgnoreCase(item.getItemCategory())) {
                charNames.add(item.getItemName());
                // System.out.println("Added to ComboBox: " + item.getItemName());
            }
        }
        characterCB.setItems(charNames);
    }

    @Override
    public void ekspressionComboBox() {
        ObservableList<String> ekspressionNames = FXCollections.observableArrayList();
        System.out.println("Skin ComboBox");
        for (Clothes item : items) {
            if ("expression".equalsIgnoreCase(item.getItemCategory())) {
                ekspressionNames.add(item.getItemName());
                // System.out.println("Added to ComboBox: " + item.getItemName());
            }
        }
        ekspressionCB.setItems(ekspressionNames);
    }

    @Override
    public void customComboBox() {
        ObservableList<String> bajuNames = FXCollections.observableArrayList();
        System.out.println("Skin ComboBox");
        for (Clothes item : items) {
            if ("baju".equalsIgnoreCase(item.getItemCategory())) {
                bajuNames.add(item.getItemName());
                // System.out.println("Added to ComboBox: " + item.getItemName());
            }   
        }
        customCB.setItems(bajuNames);
    }


    @Override
    public void accComboBox() {
        ObservableList<String> accNames = FXCollections.observableArrayList();
        System.out.println("Skin ComboBox");
        for (Clothes item : items) {
            if ("acc".equalsIgnoreCase(item.getItemCategory())) {
                accNames.add(item.getItemName());
                // System.out.println("Added to ComboBox: " + item.getItemName());
            }
        }
        accCB.setItems(accNames);
    }


    @FXML
    void downloadButton(ActionEvent event) {
        hideButtons(customCB, characterCB, customCB, accCB, ekspressionCB, downloadBTN, skinToneCB);
        WritableImage snapshot = root.snapshot(new SnapshotParameters(), null);
        saveImageToFile(snapshot, "screenshot.png");
        showButtons(customCB, characterCB, customCB, accCB, ekspressionCB, downloadBTN, skinToneCB);
    }

    private void hideButtons(Node... nodes) {
        for (Node i : nodes) {
            i.setVisible(false);
        }
    }

    private void showButtons(Node... nodes) {
        for (Node i : nodes) {
            i.setVisible(true);
        }
    }


    @Override
    public void saveImageToFile(WritableImage image, String filePath) {
        File file = new File(filePath);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            System.out.println("Screenshot dsimpan: " + file.getAbsolutePath());
        } catch (IOException e) {
            // System.err.println("gagal menyimpan screenshoot: " + e.getMessage());
            Alert alert = new Alert(AlertType.ERROR);            
            alert.setTitle("gagal menyimpan screenshoot");
            alert.setContentText("Silahkan cek kembali path penyimpanan");
            alert.showAndWait();
        }
    }
}
