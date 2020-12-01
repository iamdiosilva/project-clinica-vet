package Util;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

import java.util.ArrayList;
import java.util.List;

// Aula 55 link https://youtu.be/tQNzBykBXDw
public class ValidarCampo {
    private static final Tooltip tooltip = new Tooltip("Preencha os campos Obrigatório");

    public static boolean chegcarcampoVazio(Node... no) {
        List<Node> camposFalha = new ArrayList<>(); // se algum campo ficar em branco sera add na lista e mostra a msg

        tooltip.setStyle("-fx-backgraud-color: linear-gradient(#000000,#B222222);" + "-fx-font-weight:bold;");

        ValidaExibeTooTip.tempoToolTip(tooltip);
        //TextField
        for (Node n : no) {
            if (n instanceof TextField) {
                // criar um objeto para o node
                TextField textField = (TextField) n;
                //captirar carcter digitado e retirar a borda
                textField.textProperty().addListener(((observable, oldValue, newValue) -> {
                    ValidaExibeTooTip.removerCorBordaTooTip(textField, tooltip);
                }));
                // se o campo estiver vazio add a borda
                if (textField.getText().trim().equals("")) {

                    camposFalha.add(n);
                    ValidaExibeTooTip.addCorBordaTooTip(textField, tooltip);
                }
            }
            if (n instanceof ComboBox) {
                ComboBox<?> comboBox = (ComboBox<?>) n;
                comboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
                    ValidaExibeTooTip.removerCorBordaTooTip(comboBox, tooltip);
                });
                if (comboBox.getValue() == null) {
                    camposFalha.add(n);
                    ValidaExibeTooTip.addCorBordaTooTip(comboBox, tooltip);
                }
            }
            //calendario
            if (n instanceof DatePicker) {
                DatePicker data = (DatePicker) n;
                data.valueProperty().addListener((observable, oldValue, newValue) -> {
                    ValidaExibeTooTip.removerCorBordaTooTip(data, tooltip);
                });
                if (data.getValue() == null) {
                    camposFalha.add(n);
                    ValidaExibeTooTip.addCorBordaTooTip(data, tooltip);
                }
            }

        }

        return camposFalha.isEmpty();
    }

}
