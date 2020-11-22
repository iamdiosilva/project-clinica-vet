package model;

public class Client extends Person{

    private long id_Person;
    private long person_Code;

    public Client(long id_Person, long person_Code) {
        this.id_Person = id_Person;
        this.person_Code = person_Code;
    }

    public Client() {
    }

    public long getId_Person() {
        return id_Person;
    }

    public void setId_Person(long id_Person) {
        this.id_Person = id_Person;
    }

    public long getPerson_Code() {
        return person_Code;
    }

    public void setPerson_Code(long person_Code) {
        this.person_Code = person_Code;
    }
}
