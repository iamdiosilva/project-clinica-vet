package controll;

import Dao.CrudGernericDao;
import Util.Alerta;
import Util.ValidarCampo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import formatter.TextFieldFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import model.Client;
import modelenum.DocumentType;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ClientRegisterViewController implements Initializable {

    @FXML
    private JFXButton btnSair;
    @FXML
    private JFXTextField tfName;

    @FXML
    private JFXTextField tfAdress;

    @FXML
    private JFXTextField tfNumDocument;

    @FXML
    private JFXTextField tfContact;

    @FXML
    private JFXTextField tfEmail;
    @FXML
    private JFXComboBox<DocumentType> cbTypeDocument;

    private CrudGernericDao<Client> dao = new CrudGernericDao<>();

    private List<DocumentType> listdoc = new ArrayList<>();
    private ObservableList<DocumentType> obsdoc;

    public void loadDocumentTypeList() {

        listdoc.add(DocumentType.CPF);
        listdoc.add(DocumentType.CNPJ);
        obsdoc = FXCollections.observableArrayList(listdoc);
        cbTypeDocument.setItems(obsdoc);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ocultarCampoNmDoc();
        loadDocumentTypeList();
        maskNumberDocument();
        maskContact();
        ativarCampo();


    }


    @FXML
    void cadastroRegistro(ActionEvent event) {

        if (ValidarCampo.chegcarcampoVazio(tfName, tfAdress, tfContact, cbTypeDocument, tfNumDocument)) {

        }
        Client client = new Client();
        client.setName_Person(tfName.getText());
        client.setAddress(tfAdress.getText());
        client.setTelephone(tfContact.getText());
        client.setDocument_Type(cbTypeDocument.getSelectionModel().getSelectedItem());
        client.setDoc_Number(tfNumDocument.getText());
        client.setEmail(tfEmail.getText());

        if (dao.salvarDados(client)) {
            Alerta.msgInformacao("Registro Salvo com Sucesso ");
            limparCampos();
        } else {
            Alerta.msgInformacao("Ocorreu erros ao Gravar o registro ");
        }
    }

    public void limparCampos() {
        tfName.clear();
        tfAdress.clear();
        tfContact.clear();
        tfEmail.clear();
        tfNumDocument.clear();
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
            tff.setTf(tfNumDocument);
            tff.formatter();
        } else {
            TextFieldFormatter tff = new TextFieldFormatter();
            tff.setMask("##.###.###/####-##");
            tff.setCaracteresValidos("0123456789");
            tff.setTf(tfNumDocument);
            tff.formatter();
        }

    }

    @FXML
    void ativarCampo() {
        if(cbTypeDocument.getValue()==DocumentType.CNPJ || cbTypeDocument.getValue() == DocumentType.CPF){
            tfNumDocument.setDisable(false);
        }
    }

    @FXML
    void sairTela(ActionEvent event) {
            btnSair.getScene().getWindow().hide();
    }

    public void ocultarCampoNmDoc() {
        tfNumDocument.setDisable(true);
    }
}