package controll;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import modelenum.DocumentType;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ClientRegisterViewController implements Initializable {

    @FXML private JFXComboBox<DocumentType> cbTypeDocument;
    private List<DocumentType> listdoc = new ArrayList<>();
    private ObservableList<DocumentType> obsdoc;

    public void loadDocumentTypeList(){

        listdoc.add(DocumentType.CPF);
        listdoc.add(DocumentType.CNPJ);
        obsdoc = FXCollections.observableArrayList(listdoc);
        cbTypeDocument.setItems(obsdoc);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadDocumentTypeList();
    }
}
