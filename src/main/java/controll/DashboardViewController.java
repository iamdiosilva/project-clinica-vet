package controll;

import animation.FadeInUpTransition;
import animation.FadeOutDownTransition;
import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardViewController implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;

    public void HallScreenView() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/dashboardView.fxml"));

        Stage dashboard = new Stage();

        Scene scene = new Scene(root);
        dashboard.setScene(scene);

        scene.getStylesheets().add("/styles/dasboardStyle.css");

        makeStageDraggable(root,dashboard);

        dashboard.initStyle(StageStyle.TRANSPARENT);
        dashboard.getScene().setFill(null);

        new FadeInUpTransition(root)
                .setDelayTime(Duration.ZERO)
                .setDuration(Duration.millis(300))
                .play();
        dashboard.show();
    }

    @FXML private AnchorPane mainDashboardAP;
    @FXML private AnchorPane dashboardAP;
    @FXML private AnchorPane apTranslateMenu;
    @FXML private AnchorPane apVBoxSidebar;

    @FXML private BorderPane bpViewsDashBoard;

    @FXML private JFXButton btnRegister;
    @FXML private JFXButton btnMinimize;
    @FXML private JFXButton btnFullscreen;
    @FXML private JFXButton btnLogout;

    @FXML private VBox vbSideBar;
    @FXML private VBox vbTranslateMenu;


    @FXML
    private void logOut (ActionEvent event) throws IOException {
        // Aplicando a animação de saida
        new FadeOutDownTransition(dashboardAP)
                .setOnFinish((e) -> {
                    ((Stage) btnLogout.getScene().getWindow()).close();
                    try {
                        new LoginViewController().loginScreenView();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                })
                .setDelayTime(Duration.ZERO)
                .setDuration(Duration.millis(200))
                .play();

    }

    @FXML
    private void setFullscreen(ActionEvent event){

        
        if( ((Stage) btnFullscreen.getScene().getWindow()).isFullScreen() ){

            ((Stage) btnFullscreen.getScene().getWindow()).setFullScreen(false);

        }else{

            ((Stage) btnFullscreen.getScene().getWindow()).setFullScreen(true);

        }
    }

    @FXML
    private void makeStageDraggable (Parent parent, Stage stage){
        parent.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
    }

    @FXML
    private void minimizeBtn(ActionEvent event) {

        FadeTransition ft = new FadeTransition(Duration.millis(200));

        ft.setOnFinished((e) -> {

            ((Stage) btnMinimize.getScene().getWindow()).setIconified(true);

            if (ft.getToValue() == 0.0) {
                ft.setFromValue(0.0);
                ft.setToValue(1.0);
                ft.play();
            }

        });
        ft.setNode(mainDashboardAP);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.play();
    }

    @FXML
    private void btnRegisterMenu (MouseEvent event){

        TranslateTransition slide = new TranslateTransition();

        if (apTranslateMenu.isVisible() == false){

                apTranslateMenu.toBack();
                apTranslateMenu.setVisible(true);
                slide.setDelay(Duration.ZERO);
                slide.setDuration(Duration.millis(200));
                slide.setNode(apTranslateMenu);
                slide.setToX(150);
                slide.play();

            }else{

            slide.setOnFinished((e)-> {

                apTranslateMenu.setVisible(false);

            });

            apTranslateMenu.toBack();
            slide.setNode(apTranslateMenu);
            slide.setDelay(Duration.ZERO);
            slide.setDuration(Duration.millis(200));
            slide.setToX(0);
            slide.play();


        }

    }

    /*BUTTON METHODS*/

    @FXML
    private void registerClientView(MouseEvent event) throws IOException {
        loadView("clientRegisterView");
        btnRegisterMenu(event);
    }

    @FXML
    private  void consultClientView(MouseEvent event) throws IOException{
        loadView("consultClientView");
        btnRegisterMenu(event);
    }

    /* LOAD VIEWS*/

    private void loadView(String view) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/"+view+".fxml"));
        bpViewsDashBoard.setCenter(root);

    }

    public void initialize(URL location, ResourceBundle resources) {

        apTranslateMenu.setVisible(false);
    }

}
