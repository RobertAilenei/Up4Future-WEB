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
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class RaiffaisenApplication {
    public static void main(String[] args) throws RepositoryException {
        SpringApplication.run(RaiffaisenApplication.class, args);
        IRepository<Investor> investorSQLRepository = new InvestorSQLRepository<Investor>();
        ServiceInvestor serviceInvestor = new ServiceInvestor(investorSQLRepository);

        /// Controllers
//        InvestorController investorController = new InvestorController(serviceInvestor);
        System.out.println(serviceInvestor.InvestorLogin("alexvescan16@yahoo.com", "Messi2016"));
        /*
//        System.out.println(serviceInvestor.InvestorLogin("investor1@yahoo.com", "Investor1Password"));

        System.out.println(serviceInvestor.InvestorRegister("Investor1", 21, "investor1@yahoo.com", "Investor1Password", 10000));

//        IRepository<Startup> startupSQLRepository = new StartupSQLRepository<>();
//        IService<Startup> startupService = new Service<>(startupSQLRepository);

        System.out.println("Afisam investitorii din DB");
        for (var investor : investorServiceInvestor.getAllEntities()) {
            System.out.println(investor.toString());
        }*/
    }
}
