package com.example.raiffaisen.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public abstract class Entitate implements Serializable {
    /*
        * Vom face o functionalitate care incrementeaza automat ID-ul fiecarui obiect adaugat in Baza de date,
          bazandu-ne pe ultimul ID al obiectului introdus, sau pe ID-ul care nu exista, daca este < decat ID-ul introdus
          (Presupunem ca am dat DELETE la un produs anterior);
          ID-ul nu poate sa aiba functionalitate de SET!
     */
    @Id
    private int id;

    public Entitate() {}

    public Entitate(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

