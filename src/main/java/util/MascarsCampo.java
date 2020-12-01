package util;


import javafx.application.Platform;
import javafx.scene.control.TextField;


public class MascarsCampo {

    private static void limitarTamanhoCampo(TextField textField, Integer tamanho) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null || newValue.length() > tamanho) {
                textField.setText(oldValue);
            }
        });
    }

    private static void posicionarCursor(TextField textField) { // add uma tred
        Platform.runLater(() -> { // posicionar o  cursor no final da palavra oou tetxo

            if (textField.getText().length() != 0) {
                textField.positionCaret(textField.getText().length());
            }
        });
    }

    public static void mskNumero(TextField textField) {
        MascarsCampo.limitarTamanhoCampo(textField, 11);

        textField.lengthProperty().addListener((observable, oldValue, newValue) -> {
            String textoDigitado = textField.getText();
            textoDigitado = textoDigitado.replaceAll("[^0-9]", "");// expressão regular
            textField.setText(textoDigitado);
            MascarsCampo.posicionarCursor(textField);
        });
    }
}
