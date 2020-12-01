package controll;

import Dao.CrudGernericDao;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.Client;
import modelenum.DocumentType;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ClientRegisterViewController implements Initializable {
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
        loadDocumentTypeList();
    }


    @FXML
    void cadastroRegistro(ActionEvent event) {

    Client client = new Client();
    client.setName_Person(tfName.getText());
    client.setAddress(tfAdress.getText());
    client.setTelephone(tfContact.getText());
    client.setDocument_Type(cbTypeDocument.getSelectionModel().getSelectedItem());
    client.setDoc_Number(tfNumDocument.getText());
    client.setEmail(tfEmail.getText());

      if(dao.salvarDados(client)){
          System.out.println("salvou");
      }else {
          System.out.println("Erro ao naconexão");
      }

}
}