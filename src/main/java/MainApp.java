import controll.LoginViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        new LoginViewController()
                .loginScreenView();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
