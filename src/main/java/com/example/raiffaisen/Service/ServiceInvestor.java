package com.example.raiffaisen.Service;

import com.example.raiffaisen.Domain.Investor;
import com.example.raiffaisen.Repository.ExceptionRepository.RepositoryException;
import com.example.raiffaisen.Repository.IRepository;
import com.example.raiffaisen.Repository.SQLRepository.InvestorSQLRepository;
import org.aspectj.apache.bcel.util.Repository;

import java.util.List;

public class ServiceInvestor extends Service<Investor>{

    public ServiceInvestor(IRepository<Investor> Repository) {
        super(Repository);
    }

    public Investor InvestorLogin(String email, String password) {
        for (var elem : super.getAllEntities()) {
            if (elem.getInvestorEmail().equals(email) && elem.getInvestorPassword().equals(password)) {
                return elem;
            }
        }
        return new Investor();
    }
}



