package com.example.bookstore.controller;

import com.example.bookstore.model.Korisnik;
import com.example.bookstore.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/korisnici")
public class KorisnikController {

    private final KorisnikService korisnikService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public KorisnikController(KorisnikService korisnikService, PasswordEncoder passwordEncoder) {
        this.korisnikService = korisnikService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/registracija")
    public String showRegistrationForm(Model model) {
        model.addAttribute("korisnik", new Korisnik());
        return "korisnici/registracija";
    }

    @PostMapping("/registracija")
    public String registerKorisnik(Korisnik korisnik) {
        korisnik.setLozinka(passwordEncoder.encode(korisnik.getLozinka()));
        korisnikService.saveKorisnik(korisnik);
        return "redirect:/login";
    }
}
