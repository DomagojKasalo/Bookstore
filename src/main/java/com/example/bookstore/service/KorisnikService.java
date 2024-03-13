package com.example.bookstore.service;

import com.example.bookstore.model.Korisnik;
import com.example.bookstore.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KorisnikService {

    private final KorisnikRepository korisnikRepository;

    @Autowired
    public KorisnikService(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    public List<Korisnik> findAllKorisnici() {
        return korisnikRepository.findAll();
    }

    public Optional<Korisnik> findKorisnikById(Long id) {
        return korisnikRepository.findById(id);
    }

    public Korisnik saveKorisnik(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    public void deleteKorisnik(Long id) {
        korisnikRepository.deleteById(id);
    }
}
