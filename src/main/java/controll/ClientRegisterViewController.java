package controll;

import dao.CrudGenericDao;
import util.Alerta;
import util.ValidarCampo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import formatter.TextFieldFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.Client;
import modelenum.DocumentType;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ClientRegisterViewController implements Initializable {

    @FXML private JFXTextField tfName;

    @FXML private JFXTextField tfAddress;

    @FXML private JFXTextField tfNumberDocument;

    @FXML private JFXTextField tfContact;

    @FXML private JFXTextField tfEmail;

    @FXML private JFXButton btnRegister;

    @FXML private JFXButton btnExit;

    @FXML private JFXComboBox<DocumentType> cbTypeDocument;

    private CrudGenericDao<Client> dao = new CrudGenericDao<>();

    public void loadDocumentTypeList() {
        List<DocumentType> listDocument = Arrays.asList(DocumentType.CPF, DocumentType.CNPJ);
        ObservableList<DocumentType> obsDocument = FXCollections.observableArrayList(listDocument);
        cbTypeDocument.setItems(obsDocument);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hideFieldNmDoc();
        loadDocumentTypeList();
        maskNumberDocument();
        maskContact();
        fieldActive();

    }


    @FXML
    void registerClient(ActionEvent event) {

        if (ValidarCampo.chegcarcampoVazio(tfName, tfAddress, tfContact, cbTypeDocument, tfNumberDocument)) {

        }
        Client client = new Client();
        client.setName_Person(tfName.getText());
        client.setAddress(tfAddress.getText());
        client.setTelephone(tfContact.getText());
        client.setDocument_Type(cbTypeDocument.getSelectionModel().getSelectedItem());
        client.setDoc_Number(tfNumberDocument.getText());
        client.setEmail(tfEmail.getText());

        if (dao.saveInformation(client)) {
            Alerta.msgInformacao("Registro Salvo com Sucesso ");
            clearFields();
        } else {
            Alerta.msgInformacao("Ocorreu erros ao Gravar o registro ");
        }
    }

    public void clearFields() {
        tfName.clear();
        tfAddress.clear();
        tfContact.clear();
        tfEmail.clear();
        tfNumberDocument.clear();
        cbTypeDocument.setValue(DocumentType.TIPO_DOCUMENTO);
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
    void fieldActive() {
        if(cbTypeDocument.getValue()==DocumentType.CNPJ || cbTypeDocument.getValue() == DocumentType.CPF){
            tfNumberDocument.setDisable(false);
        }
    }

    @FXML
    void exitScreen(ActionEvent event) {
            btnExit.getScene().getWindow().hide();
    }

    public void hideFieldNmDoc() {
        tfNumberDocument.setDisable(true);
    }
}