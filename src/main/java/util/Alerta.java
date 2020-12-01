package util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Alerta {

    static ButtonType btnConfirmar = new ButtonType("Confirmar");
    static ButtonType btnCancelar = new ButtonType("Cancelar");
    static boolean resposta;

    public  static void msgInformacao(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Informação do Cadastrado");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static boolean msgConfimarExclusao(String msgExclusao){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Exclusão de Registro");
        alert.setContentText("Deseja excluir o registro " + msgExclusao + "?");
        alert.getButtonTypes().setAll(btnConfirmar,btnCancelar);
        alert.showAndWait().ifPresent(b ->{ // expressao lambida
            if (b== btnConfirmar){
                resposta = true;
            }else {
                resposta = false;
                            }
        });
        return resposta;
    }
}
