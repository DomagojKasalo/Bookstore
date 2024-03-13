package com.example.bookstore.controller;

import com.example.bookstore.model.Knjiga;
import com.example.bookstore.service.KnjigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/knjige")
public class KnjigaController {

    private final KnjigaService knjigaService;

    @Autowired
    public KnjigaController(KnjigaService knjigaService) {
        this.knjigaService = knjigaService;
    }

    @GetMapping
    public String listKnjige(Model model) {
        model.addAttribute("knjige", knjigaService.findAllKnjige());
        return "knjige/lista";
    }

    @GetMapping("/nova")
    public String novaKnjigaForm(Model model) {
        model.addAttribute("knjiga", new Knjiga());
        return "knjige/forma";
    }

    @PostMapping("/spremi")
    public String spremiKnjigu(@ModelAttribute("knjiga") Knjiga knjiga) {
        knjigaService.saveKnjiga(knjiga);
        return "redirect:/knjige";
    }

    @GetMapping("/uredi/{id}")
    public String urediKnjigaForm(@PathVariable Long id, Model model) {
        Knjiga knjiga = knjigaService.findKnjigaById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid knjiga Id:" + id));
        model.addAttribute("knjiga", knjiga);
        return "knjige/forma";
    }

    @GetMapping("/obrisi/{id}")
    public String obrisiKnjigu(@PathVariable Long id) {
        knjigaService.deleteKnjiga(id);
        return "redirect:/knjige";
    }
}
