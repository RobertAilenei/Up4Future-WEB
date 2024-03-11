package com.example.raiffaisen.Service;

import com.example.raiffaisen.Domain.Investor;
import com.example.raiffaisen.Domain.Startup;
import com.example.raiffaisen.Repository.ExceptionRepository.RepositoryException;
import com.example.raiffaisen.Repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

@org.springframework.stereotype.Service
public class ServiceStartup extends Service<Startup>
{

    public ServiceStartup(IRepository<Startup> Repository) {
        super(Repository);
    }

    /*
     * Verificam daca exista investitorul in baza noastra de date, astfe, il putem loga, altfel, aruncam exceptie si ii zicem ca nu exista.
     * Noi verificam daca exista INVESTITORUL primind Email-ul si Parola aferente Login-ului.

     */

    /// Cautam Investitorul care incearca sa se Logheze in baza de date, dupa Email-ul si Parola furnizate.
    public Startup findStartupByEmailPassword(String email, String password) {
        List<Startup> entities = super.getAllEntities();

        for (Startup entity : entities)
            if (Objects.equals(entity.getStartupEmail(), email) && Objects.equals(entity.getStartupPassword(), password)) {
                {
                    System.out.println("Am gasit startup-ul");
                    return entity; // Returnam obiectul de tip Investor}
                }

            }
        System.out.println("NU am gasit startup-ul asta");
        return null;
    }

    public boolean StartupLogin(String email, String password) {
        Startup startup = findStartupByEmailPassword(email, password);

        if (startup == null) /// Trebuie trimis in UI adresa de email sau parola gresita/e, sau posibil sa trebuiasca sa faca Register
        {
            System.out.println("Startup-ul nu exista in DB, deci trebuie sa se INREGISTREZE, sau email/parola e/sunt gresit/e");
            return false;
        }

        System.out.println("Successfull login");
        return true;
    }

    /**
     Metoda folosita pentru a INREGISTRA un Startup in BAZA DE DATE.
     */
    public boolean StartupRegister(String name, String email, String password) throws RepositoryException {
        Startup startup = findStartupByEmailPassword(email, password);
        /*
            Daca nu exista nici email ul si nici parola in DB,
            Atunci, inregistrarea se face punand obiectul in DB,
         */
        if (startup == null)
        {
            // Adaugam in DB

            // Luam ID-ul ultimului obiect din DB, si actualizam cu + 1, apoi adaugam in DB
            int idxLastInvestor = super.getAllEntities().size() - 1;
            Startup startup1 = new Startup(idxLastInvestor, name, email, password);
            super.add(startup1);

            System.out.println("Successfull Register");
        }
        // Inseamna ca exista deja inregistrat acest Investor in baza de date, deci trebuie sa se LOGHEZE.
        System.out.println("Startup-ul deja existent in DB, deci trebuie sa se logheze");
        return false;
    }
}



