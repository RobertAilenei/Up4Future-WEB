package com.example.raiffaisen.Service;

import com.example.raiffaisen.Domain.Investor;
import com.example.raiffaisen.Repository.ExceptionRepository.RepositoryException;
import com.example.raiffaisen.Repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

@org.springframework.stereotype.Service
public class ServiceInvestor extends Service<Investor>
{

    public ServiceInvestor(IRepository<Investor> Repository) {
        super(Repository);
    }

    /*
     * Verificam daca exista investitorul in baza noastra de date, astfe, il putem loga, altfel, aruncam exceptie si ii zicem ca nu exista.
     * Noi verificam daca exista INVESTITORUL primind Email-ul si Parola aferente Login-ului.

     */

    /// Cautam Investitorul care incearca sa se Logheze in baza de date, dupa Email-ul si Parola furnizate.
    public Investor findInvestorByEmailPassword(String email, String password) {
        List<Investor> entities = super.getAllEntities();

        for (Investor entity : entities)
            if (Objects.equals(entity.getInvestorEmail(), email) && Objects.equals(entity.getInvestorPassword(), password)) {
                {
                    System.out.println("Am gasit investitorul");
                    return entity; // Returnam obiectul de tip Investor}
            }

    }
        System.out.println("NU am gasit investitorul asta");
        return null;
    }

    public boolean InvestorLogin(String email, String password) {
        Investor investor = findInvestorByEmailPassword(email, password);

        if (investor == null) /// Trebuie trimis in UI adresa de email sau parola gresita/e, sau posibil sa trebuiasca sa faca Register
        {
            System.out.println("Investor nu exista in DB, deci trebuie sa se INREGISTREZE, sau email/parola e/sunt gresit/e");
            return false;
        }

        System.out.println("Successfull login");
        return true;
    }

    /**
        Metoda folosita pentru a INREGISTRA un INVESTOR in BAZA DE DATE.
     */
    public boolean InvestorRegister(String name, int age, String email, String password, float money) throws RepositoryException {
        Investor investor = findInvestorByEmailPassword(email, password);

        /*
            Daca nu exista nici email ul si nici parola in DB,
            Atunci, inregistrarea se face punand obiectul in DB,
         */
        if (investor == null)
        {
            // Adaugam in DB

            // Luam ID-ul ultimului obiect din DB, si actualizam cu + 1, apoi adaugam in DB
            int idxLastInvestor = super.getAllEntities().size() - 1;
            Investor investor1 = new Investor(idxLastInvestor, name, age, email, password, money);
            super.add(investor1);

            System.out.println("Successfull Register");
        }
        // Inseamna ca exista deja inregistrat acest Investor in baza de date, deci trebuie sa se LOGHEZE.
        System.out.println("Investor deja existent in DB, deci trebuie sa se logheze");
        return false;
    }
}



