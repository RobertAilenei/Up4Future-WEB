package com.example.raiffaisen;

import com.example.raiffaisen.Domain.Investor;
import com.example.raiffaisen.Domain.Startup;
import com.example.raiffaisen.Repository.ExceptionRepository.RepositoryException;
import com.example.raiffaisen.Repository.IRepository;
import com.example.raiffaisen.Repository.SQLRepository.InvestorSQLRepository;
import com.example.raiffaisen.Repository.SQLRepository.StartupSQLRepository;
import com.example.raiffaisen.Service.IService;
import com.example.raiffaisen.Service.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RaiffaisenApplication {


    public static void main(String[] args) throws RepositoryException {
        SpringApplication.run(RaiffaisenApplication.class, args);

        IRepository<Investor> investorSQLRepository = new InvestorSQLRepository<Investor>();
        IService<Investor> investorService = new Service<>(investorSQLRepository);

        IRepository<Startup> startupSQLRepository = new StartupSQLRepository();
        IService<Startup> startupService = new Service<>(startupSQLRepository);

//        investorService.add(new Investor(1, "Investitor1"));
//        investorService.add(new Investor(2, "Investitor2"));
//        investorService.add(new Investor(3, "Investitor3"));

         for (var investor : investorService.getAllEntities())
          {
                System.out.println(investor.toString());
        }
    }
}
