package com.example.bookstore.controller;

import com.example.bookstore.model.Posudba;
import com.example.bookstore.service.PosudbaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posudbe")
public class PosudbaController {

    private final PosudbaService posudbaService;

    @Autowired
    public PosudbaController(PosudbaService posudbaService) {
        this.posudbaService = posudbaService;
    }

    @GetMapping
    public String listAllPosudbe(Model model) {
        model.addAttribute("posudbe", posudbaService.findAllPosudbe());
        return "posudbe/lista";
    }

    @GetMapping("/moje-posudbe")
    public String listMojePosudbe(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // Dohvaća trenutno prijavljenog korisnika
        model.addAttribute("posudbe", posudbaService.findPosudbeByKorisnik(username));
        return "posudbe/moje-posudbe";
    }

    @PostMapping("/posudi/{knjigaId}")
    public String posudiKnjigu(@PathVariable Long knjigaId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); // Dohvaća trenutno prijavljenog korisnika
        posudbaService.posudiKnjigu(knjigaId, username);
        return "redirect:/posudbe/moje-posudbe";
    }

    @PostMapping("/vrati/{posudbaId}")
    public String vratiKnjigu(@PathVariable Long posudbaId) {
        posudbaService.vratiKnjigu(posudbaId);
        return "redirect:/posudbe/moje-posudbe";
    }
}
