package model;

import modelenum.PaymentStatus;
import modelenum.TypeConsult;

import java.util.Date;

public class Consultation {
    private long id_Consultation;
    private long id_Animal;
    private long id_Client;
    private long id_Employee;
    private TypeConsult consult_type;
    private Date date_Consult;
    private Date date_input;
    private Date date_exit;
    private double price_Consult;
    private PaymentStatus status;

    public Consultation(long id_Consultation, long id_Animal, long id_Client, long id_Employee, TypeConsult consult_type, Date date_Consult, Date date_input, Date date_exit, double price_Consult, PaymentStatus status) {
        this.id_Consultation = id_Consultation;
        this.id_Animal = id_Animal;
        this.id_Client = id_Client;
        this.id_Employee = id_Employee;
        this.consult_type = consult_type;
        this.date_Consult = date_Consult;
        this.date_input = date_input;
        this.date_exit = date_exit;
        this.price_Consult = price_Consult;
        this.status = status;
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

    public TypeConsult getConsult_type() {
        return consult_type;
    }

    public void setConsult_type(TypeConsult consult_type) {
        this.consult_type = consult_type;
    }

    public Date getDate_Consult() {
        return date_Consult;
    }

    public void setDate_Consult(Date date_Consult) {
        this.date_Consult = date_Consult;
    }

    public Date getDate_input() {
        return date_input;
    }

    public void setDate_input(Date date_input) {
        this.date_input = date_input;
    }

    public Date getDate_exit() {
        return date_exit;
    }

    public void setDate_exit(Date date_exit) {
        this.date_exit = date_exit;
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
