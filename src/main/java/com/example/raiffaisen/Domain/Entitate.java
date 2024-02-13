package com.example.raiffaisen.Domain;

import java.io.Serializable;

public abstract class Entitate implements Serializable {
    /*
        * Vom face o functionalitate care incrementeaza automat ID-ul fiecarui obiect adaugat in Baza de date,
          bazandu-ne pe ultimul ID al obiectului introdus, sau pe ID-ul care nu exista, daca este < decat ID-ul introdus
          (Presupunem ca am dat DELETE la un produs anterior);
          ID-ul nu poate sa aiba functionalitate de SET!
     */
    public Entitate(int id) {
        this.id = id;
    }

    private int id;

    public int getId() {
        return id;
    }
}

