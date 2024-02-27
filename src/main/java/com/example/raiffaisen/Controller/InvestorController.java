package com.example.raiffaisen.Controller;//package com.example.raiffaisen.Controller;

import com.example.raiffaisen.DTO.LoginDTO;
import com.example.raiffaisen.Service.ServiceInvestor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/investor")
public class InvestorController {
    private final ServiceInvestor investorService;

    //    @Autowired
//    private Authentication authenticationManager;
    @Autowired
    public InvestorController(ServiceInvestor serviceInvestor) {
        this.investorService = serviceInvestor;
        System.out.println("Luam investitorii folosind REST + numarul de investitori inregistrati este: " + investorService.getAllEntities().size());
    }

    @GetMapping
    public String investorPage() {
        return "Investor";
    }

    @GetMapping("/login")
    public String investorLoginPage() {
        return "InvestorLogin";
    }


    @GetMapping("/register")
    public String investorRegisterPage() {
        return "InvestorRegister";
    }

    /*
    Aici incercam sa logam Investor-ul,
    Deci gen, dupa ce Investor-ul alege sa se logheze in FrontEnd, o sa fie directionat
    catre un link de genul '/login', si aici isi introduce adresa de email si parola,
    apoi noi folosim algoritmul in care verificam daca exista Investorul asta in Baza de date
    * */

    //    @PostMapping("/login") // @ModelAttribute
//    public ResponseEntity<?> investorLogin(@RequestAttribute LoginDTO loginDTO) {
//        System.out.println("Metoda apelata din web");
//
//        boolean investor = investorService.InvestorLogin(loginDTO.getEmail(), loginDTO.getPassword());
//        System.out.println("Investor logat cu succes");
//        if (investor) {
//            return ResponseEntity.ok().body("Investor logat cu succes!");
//            // Într-o aplicație reală, aici s-ar returna un token JWT sau alt mecanism de sesiune
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credențiale invalide!");
//        }
    @PostMapping("/login")
    public ResponseEntity<?> login(@ModelAttribute LoginDTO loginDTO) {
        // Logica de autentificare
        System.out.println(loginDTO.getEmail() + " " + loginDTO.getPassword());

        boolean investor = investorService.InvestorLogin(loginDTO.getEmail(), loginDTO.getPassword());
        if (investor) {
            return ResponseEntity.ok().body("Investor logat cu succes!");
            // Într-o aplicație reală, aici s-ar returna un token JWT sau alt mecanism de sesiune
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credențiale invalide!");
        }
//        return "redirect:/investor"; // Redirect după login
    }
}