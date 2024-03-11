package com.example.raiffaisen;
import com.example.raiffaisen.Controller.InvestorController;
import com.example.raiffaisen.Domain.Investor;
import com.example.raiffaisen.Domain.Startup;
import com.example.raiffaisen.Repository.ExceptionRepository.RepositoryException;
import com.example.raiffaisen.Repository.IRepository;
import com.example.raiffaisen.Repository.SQLRepository.InvestorSQLRepository;
import com.example.raiffaisen.Repository.SQLRepository.StartupSQLRepository;
import com.example.raiffaisen.Service.ServiceInvestor;
import com.example.raiffaisen.Service.ServiceStartup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class RaiffaisenApplication {
    public static void main(String[] args) throws RepositoryException {
        SpringApplication.run(RaiffaisenApplication.class, args);
        IRepository<Investor> investorSQLRepository = new InvestorSQLRepository<Investor>();
        ServiceInvestor serviceInvestor = new ServiceInvestor(investorSQLRepository);
        IRepository<Startup> startupIRepository = new StartupSQLRepository<Startup>();
        ServiceStartup serviceStartup = new ServiceStartup(startupIRepository);

        /// Controllers
        System.out.println(serviceInvestor.InvestorLogin("alexvescan16@yahoo.com", "Messi2016"));
        for(Startup startup: serviceStartup.getAllEntities()){
            System.out.println(startup);
        }
        System.out.println(serviceStartup.StartupLogin("endava@yahoo.com", "1234"));
    }
}
