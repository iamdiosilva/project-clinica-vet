package controll;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import formatter.TextFieldFormatter;
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

public class ConsultClientViewController implements Initializable {

    @FXML
    private JFXTextField tfName;

    @FXML
    private JFXTextField tfAddress;

    @FXML
    private JFXComboBox<DocumentType> cbTypeDocument;

    @FXML
    private JFXTextField tfNumberDocument;

    @FXML
    private JFXTextField tfContact;

    @FXML
    private JFXTextField tfEmail;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        maskContact();
        maskNumberDocument();
        fieldActivate();
        loadDocumentTypeList();
    }


    public void loadDocumentTypeList() {
        List<DocumentType> listDocument = Arrays.asList(DocumentType.CPF, DocumentType.CNPJ);
        ObservableList<DocumentType> obsDocument = FXCollections.observableArrayList(listDocument);
        cbTypeDocument.setItems(obsDocument);


    }

    @FXML
    void maskContact() {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.setMask("(##)#####-####");
        tff.setCaracteresValidos("0123456789");
        tff.setTf(tfContact);
        tff.formatter();
    }


    @FXML
    void maskNumberDocument() {
        if (cbTypeDocument.getValue() == DocumentType.CPF) {
            TextFieldFormatter tff = new TextFieldFormatter();
            tff.setMask("###.###.###-##");
            tff.setCaracteresValidos("0123456789");
            tff.setTf(tfNumberDocument);
            tff.formatter();
        } else {
            TextFieldFormatter tff = new TextFieldFormatter();
            tff.setMask("##.###.###/####-##");
            tff.setCaracteresValidos("0123456789");
            tff.setTf(tfNumberDocument);
            tff.formatter();
        }
    }

    @FXML
    void fieldActivate() {
        if(cbTypeDocument.getValue()==DocumentType.CNPJ || cbTypeDocument.getValue() == DocumentType.CPF){
            tfNumberDocument.setDisable(false);
        }
    }
}
