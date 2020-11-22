package model;

import modelenum.PaymentStatus;
import modelenum.TypeConsult;
import java.util.Date;

public class Consultation {

    private long id_Consultation;
    private long id_Animal;
    private long id_Client;
    private long id_Employee;
    private Date date_Consult;
    private Date date_Input;
    private Date date_Exit;
    private double price_Consult;
    private TypeConsult consult_Type;
    private PaymentStatus status;



    public Consultation(long id_Consultation, long id_Animal, long id_Client, long id_Employee, TypeConsult consult_Type, Date date_Consult, Date date_Input, Date date_Exit, double price_Consult, PaymentStatus status) {
        this.id_Consultation = id_Consultation;
        this.id_Animal = id_Animal;
        this.id_Client = id_Client;
        this.id_Employee = id_Employee;
        this.consult_Type = consult_Type;
        this.date_Consult = date_Consult;
        this.date_Input = date_Input;
        this.date_Exit = date_Exit;
        this.price_Consult = price_Consult;
        this.status = status;
    }

    public Consultation() {
    }

    public long getId_Consultation() {
        return id_Consultation;
    }

    public void setId_Consultation(long id_Consultation) {
        this.id_Consultation = id_Consultation;
    }

    public long getId_Animal() {
        return id_Animal;
    }

    public void setId_Animal(long id_Animal) {
        this.id_Animal = id_Animal;
    }

    public long getId_Client() {
        return id_Client;
    }

    public void setId_Client(long id_Client) {
        this.id_Client = id_Client;
    }

    public long getId_Employee() {
        return id_Employee;
    }

    public void setId_Employee(long id_Employee) {
        this.id_Employee = id_Employee;
    }

    public TypeConsult getConsult_Type() {
        return consult_Type;
    }

    public void setConsult_Type(TypeConsult consult_Type) {
        this.consult_Type = consult_Type;
    }

    public Date getDate_Consult() {
        return date_Consult;
    }

    public void setDate_Consult(Date date_Consult) {
        this.date_Consult = date_Consult;
    }

    public Date getDate_Input() {
        return date_Input;
    }

    public void setDate_Input(Date date_Input) {
        this.date_Input = date_Input;
    }

    public Date getDate_Exit() {
        return date_Exit;
    }

    public void setDate_Exit(Date date_Exit) {
        this.date_Exit = date_Exit;
    }

    public double getPrice_Consult() {
        return price_Consult;
    }

    public void setPrice_Consult(double price_Consult) {
        this.price_Consult = price_Consult;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
