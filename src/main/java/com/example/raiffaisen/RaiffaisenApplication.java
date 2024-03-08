package com.example.raiffaisen;
import com.example.raiffaisen.Controller.InvestorController;
import com.example.raiffaisen.Domain.Investor;
import com.example.raiffaisen.Repository.ExceptionRepository.RepositoryException;
import com.example.raiffaisen.Repository.IRepository;
import com.example.raiffaisen.Repository.SQLRepository.InvestorSQLRepository;
import com.example.raiffaisen.Service.ServiceInvestor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class RaiffaisenApplication {
    public static void main(String[] args) throws RepositoryException {
        SpringApplication.run(RaiffaisenApplication.class, args);
        IRepository<Investor> investorSQLRepository = new InvestorSQLRepository<Investor>();
        ServiceInvestor serviceInvestor = new ServiceInvestor(investorSQLRepository);

        /// Controllers
        System.out.println(serviceInvestor.InvestorLogin("alexvescan16@yahoo.com", "Messi2016"));
    }
}
