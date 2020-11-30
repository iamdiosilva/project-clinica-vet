package model;

import modelenum.StatusEmployee;

public class Employee extends Person {
    private long id_Person;
    private long employee_Code;
    private double salary;
    private String access;
    private String login;
    private String password;
    private StatusEmployee status;

    public Employee(long id_Person, long employee_Code, double salary, String access, String login, String password, StatusEmployee status) {
        this.id_Person = id_Person;
        this.employee_Code = employee_Code;
        this.salary = salary;
        this.access = access;
        this.login = login;
        this.password = password;
        this.status = status;
    }

    @Override
    public long getId_Person() {
        return id_Person;
    }

    @Override
    public void setId_Person(long id_Person) {
        this.id_Person = id_Person;
    }

    public long getEmployee_Code() {
        return employee_Code;
    }

    public void setEmployee_Code(long employee_Code) {
        this.employee_Code = employee_Code;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public StatusEmployee getStatus() {
        return status;
    }

    public void setStatus(StatusEmployee status) {
        this.status = status;
    }
}