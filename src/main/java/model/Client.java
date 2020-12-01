package model;

import javax.persistence.*;


@Entity
@Table
public class Client extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Person",nullable = false)
    @OneToOne
    private long id_Person;

    @Column(name ="person_Code",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long person_Code;

    @Override
    public long getId_Person() {
        return id_Person;
    }

    @Override
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

