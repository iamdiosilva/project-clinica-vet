package model;

import modelenum.DocumentType;

public class Person {
    private long id_Person;
    private long document_Number;
    private String name_Person;
    private DocumentType document_Type;
    private String address;
    private String telephone;
    private String email;

    public Person() {

    }

    public Person(long id_Person, long document_Number, String name_Person, DocumentType document_Type, String address, String telephone, String email) {
        this.id_Person = id_Person;
        this.document_Number = document_Number;
        this.name_Person = name_Person;
        this.document_Type = document_Type;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }

    public long getId_Person() {
        return id_Person;
    }

    public void setId_Person(long id_Person) {
        this.id_Person = id_Person;
    }

    public long getDocument_Number() {
        return document_Number;
    }

    public void setDocument_Number(long document_Number) {
        this.document_Number = document_Number;
    }

    public String getName_Person() {
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
