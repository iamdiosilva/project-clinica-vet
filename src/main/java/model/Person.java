package model;

import modelenum.DocumentType;

import javax.persistence.*;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_person",nullable = false)
    private long id_Person;

    @Column(name="doc_numero",length = 50,nullable = false)
    private String doc_Number;

    @Column(name="name_Person",length = 100,nullable = false)
    private String name_Person;

    @Column(name="document_Type",length = 50,nullable = false)
    private DocumentType document_Type;

    public String getName_Person() {
        return name_Person;
    }

    @Column(name="address",length = 100,nullable = false)
    private String address;

    @Column(name="telephone",length = 15,nullable = false)
    private String telephone;

    @Column(name="email",length = 100,nullable = false)
    private String email;


    /*
    public Person(long id_Person, long document_Number, String name_Person, DocumentType document_Type, String address, String telephone, String email) {
        this.id_Person = id_Person;
        this.document_Number = document_Number;
        this.name_Person = name_Person;
        this.document_Type = document_Type;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }
     */

    public long getId_Person() {
        return id_Person;
    }

    public void setId_Person(long id_Person) {
        this.id_Person = id_Person;
    }

    public String getDoc_Number() {
        return doc_Number;
    }

    public void setDoc_Number(String doc_Number) {
        this.doc_Number = doc_Number;
    }

    public String getName_Person(String text) {
        return name_Person;
    }

    public void setName_Person(String name_Person) {
        this.name_Person = name_Person;
    }

    public DocumentType getDocument_Type() {
        return document_Type;
    }

    public void setDocument_Type(DocumentType document_Type) {
        this.document_Type = document_Type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
