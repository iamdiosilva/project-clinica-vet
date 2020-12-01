package controll;

import animation.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginViewController implements Initializable {

    private double xOffset =0;
    private double yOffset =0;

    public void loginScreenView() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/loginView.fxml"));

        Stage primaryStage = new Stage();

        Scene scene = new Scene(root);

        makeStageDraggable(root,primaryStage);

        primaryStage.setScene(scene);
        scene.getStylesheets().add("/styles/loginStyle.css");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.getScene().setFill(null);

        new FadeInUpTransition(root)
                .setDelayTime(Duration.ZERO)
                .setDuration(Duration.millis(800))
                .play();

        primaryStage.show();

    }

    @FXML private AnchorPane mainAP;
    @FXML private AnchorPane leftAP;
    @FXML private AnchorPane rightAP;

    @FXML private JFXButton btnExitLogin;
    @FXML private JFXButton btnLogin;
    @FXML private JFXButton btnMinimize;

    @FXML private JFXTextField jfxUserField;

    @FXML private JFXTextField jfxTextFieldPassword;


    @FXML private JFXPasswordField jfxPasswordField;


    @FXML private ToggleButton tgButtonView;




    @FXML
    private void loginVerification () throws IOException {
        //Animacao de tremor

        jfxUserField.setId(null);
        jfxPasswordField.setId(null);

        if (jfxUserField.getText().equals("admin") && jfxPasswordField.getText().equals("admin") || jfxTextFieldPassword.getText().equals("admin")) {

            // Aplicando a animação de entrada
            new FadeOutDownTransition(mainAP)
                    .setOnFinish((e) -> {

                        ((Stage) jfxUserField.getScene().getWindow()).close();
                    })
                    .setDelayTime(Duration.ZERO)
                    .setDuration(Duration.millis(200))
                    .play();
            ((Stage) jfxUserField.getScene().getWindow()).close();
            new DashboardViewController().HallScreenView();


        } else {

            jfxUserField.setText("");
            jfxPasswordField.setText("");
            jfxUserField.requestFocus();

            // Aplicando a animação de validação
            new ShakeTransition(mainAP)
                    .setDelayTime(Duration.ZERO)
                    .setDuration(Duration.millis(800))
                    .play();


            if (!jfxUserField.getText().equals("admin")) {
                jfxUserField.setId("text-field-validation-error");
            }

            if (!jfxPasswordField.getText().equals("admin") || !jfxTextFieldPassword.getText().equals("admin")) {
                jfxPasswordField.setId("text-field-validation-error");
            }

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
    void loginBtnAction(ActionEvent event) throws IOException {
        loginVerification();
    }


    @FXML
    private void shortCutLoginBtn(KeyEvent shortcut) throws IOException {
            if(shortcut.getCode() == KeyCode.ENTER){
                loginVerification();
            }
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
            ft.setNode(mainAP);
            ft.setFromValue(1.0);
            ft.setToValue(0.0);
            ft.play();
    }

    @FXML
    private void closeLoginScreenBtn (ActionEvent event) {
        // Aplicando a animação de saida
        new FadeOutDownTransition(mainAP)
                .setOnFinish((e) -> {
                    ((Stage) btnExitLogin.getScene().getWindow()).close();
                    Platform.exit();
                })
                .setDelayTime(Duration.ZERO)
                .setDuration(Duration.millis(300))
                .play();
    }

    public void viewPass () {
        tgButtonView.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if(tgButtonView.isSelected()){
                    tgButtonView.setGraphic(new ImageView("/images/eyeClosed.png"));
                    jfxTextFieldPassword.setText(jfxPasswordField.getText());
                    jfxPasswordField.setVisible(false);
                    jfxTextFieldPassword.setVisible(true);

                }else{
                    tgButtonView.setGraphic(new ImageView("/images/eyeOpen.png"));
                    jfxPasswordField.setText(jfxTextFieldPassword.getText());
                    jfxPasswordField.setVisible(true);
                    jfxTextFieldPassword.setVisible(false);

                }
            }
        });
    }

    public void initialize(URL location, ResourceBundle resources) {
        tgButtonView.setGraphic(new ImageView("/images/eyeOpen.png"));
        jfxTextFieldPassword.setVisible(false);
        viewPass();
    }


}
