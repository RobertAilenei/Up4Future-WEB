package com.example.raiffaisen.Controller;

import com.example.raiffaisen.DTO.LoginDTO;
import com.example.raiffaisen.Service.ServiceInvestor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/investors")
public class InvestorController {
    private final ServiceInvestor investorService;

    //    @Autowired
//    private Authentication authenticationManager;
    @Autowired
    public InvestorController(ServiceInvestor serviceInvestor) {
        this.investorService = serviceInvestor;
        System.out.println("Luam investitorii folosind REST + numarul de investitori inregistrati este: " + investorService.getAllEntities().size());
    }

    /*
    Aici incercam sa logam Investor-ul,
    Deci gen, dupa ce Investor-ul alege sa se logheze in FrontEnd, o sa fie directionat
    catre un link de genul '/login', si aici isi introduce adresa de email si parola,
    apoi noi folosim algoritmul in care verificam daca exista Investorul asta in Baza de date
    * */

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        boolean investor = investorService.InvestorLogin(loginDTO.getEmail(), loginDTO.getPassword());
        System.out.println("Investor logat cu succes");

        if (investor) {
            return ResponseEntity.ok().body("Investor logat cu succes!");
            // Într-o aplicație reală, aici s-ar returna un token JWT sau alt mecanism de sesiune
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credențiale invalide!");
        }
    }
}
@RestController
@RequestMapping("/investors")
class ViewController {
    @GetMapping("/login")
    public String showLoginForm() {
        return "login page unde ar trb sa apara ";
    }
}
