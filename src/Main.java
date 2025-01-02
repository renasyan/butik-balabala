import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("views/MainFrame.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Zeppelin's listening bar");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
    public static void main(String[] args) throws Exception {
        try {
            launch(args);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
