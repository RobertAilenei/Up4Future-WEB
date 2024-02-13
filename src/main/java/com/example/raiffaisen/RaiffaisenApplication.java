package com.example.raiffaisen;

import com.example.raiffaisen.Domain.Investor;
import com.example.raiffaisen.Repository.ExceptionRepository.RepositoryException;
import com.example.raiffaisen.Repository.IRepository;
import com.example.raiffaisen.Repository.SQLRepository.InvestorSQLRepository;
import com.example.raiffaisen.Service.ServiceInvestor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RaiffaisenApplication {


    public static void main(String[] args) throws RepositoryException {
        SpringApplication.run(RaiffaisenApplication.class, args);

        IRepository<Investor> investorSQLRepository = new InvestorSQLRepository<Investor>();
        ServiceInvestor investorServiceInvestor = new ServiceInvestor(investorSQLRepository);

        System.out.println(investorServiceInvestor.InvestorLogin("alexvescan16@yahoo.com", "Messi2016"));
        System.out.println(investorServiceInvestor.InvestorLogin("investor1@yahoo.com", "Investor1Password"));

        System.out.println(investorServiceInvestor.InvestorRegister("Investor1", 21, "investor1@yahoo.com", "Investor1Password", 10000));

//        IRepository<Startup> startupSQLRepository = new StartupSQLRepository<>();
//        IService<Startup> startupService = new Service<>(startupSQLRepository);

        System.out.println("Afisam investitorii din DB");
        for (var investor : investorServiceInvestor.getAllEntities()) {
            System.out.println(investor.toString());
        }
    }
}
