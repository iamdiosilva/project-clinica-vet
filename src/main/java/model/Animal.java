package model;

import modelenum.AnimalType;
import modelenum.Situation;

public class Animal {
    private long id_Animal;
    private String name_Animal;
    private String breed;
    private String description;
    private String characterist;
    private Situation status;
    private AnimalType animal_Type;

    public Animal(long id_Animal, String name_Animal, String breed, String description, String characterist, Situation status, AnimalType animal_Type) {
        this.id_Animal = id_Animal;
        this.name_Animal = name_Animal;
        this.breed = breed;
        this.description = description;
        this.characterist = characterist;
        this.status = status;
        this.animal_Type = animal_Type;
    }

    public long getId_Animal() {
        return id_Animal;
    }

    public void setId_Animal(long id_Animal) {
        this.id_Animal = id_Animal;
    }

    public String getName_Animal() {
        return name_Animal;
    }

    public void setName_Animal(String name_Animal) {
        this.name_Animal = name_Animal;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCharacterist() {
        return characterist;
    }

    public void setCharacterist(String characterist) {
        this.characterist = characterist;
    }

    public Situation getStatus() {
        return status;
    }

    public void setStatus(Situation status) {
        this.status = status;
    }

    public AnimalType getAnimal_Type() {
        return animal_Type;
    }

    public void setAnimal_Type(AnimalType animal_Type) {
        this.animal_Type = animal_Type;
    }
}

