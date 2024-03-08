package com.example.raiffaisen.Controller;//package com.example.raiffaisen.Controller;

import com.example.raiffaisen.DTO.LoginDTO;
import com.example.raiffaisen.Service.ServiceInvestor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/investor")
@RequiredArgsConstructor
public class InvestorController {

    @Autowired
    private ServiceInvestor serviceInvestor;
    @Autowired
    public InvestorController(ServiceInvestor serviceInvestor) {
        this.serviceInvestor = serviceInvestor;
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
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        System.out.println("LoginDTO + Luam investitorii folosind REST + numarul de investitori inregistrati este: " + this.serviceInvestor.getAllEntities().size());

        // Logica de autentificare
        System.out.println(loginDTO.getEmail() + " " + loginDTO.getPassword());

        boolean investor = serviceInvestor.InvestorLogin(loginDTO.getEmail(), loginDTO.getPassword());
        if (investor) {
            return ResponseEntity.ok().body("Investor logat cu succes!");
            // Într-o aplicație reală, aici s-ar returna un token JWT sau alt mecanism de sesiune
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credențiale invalide!");
        }
//        return "redirect:/investor"; // Redirect după login
    }
}