package com.example.bookstore.service;

import com.example.bookstore.model.Knjiga;
import com.example.bookstore.model.Korisnik;
import com.example.bookstore.model.Posudba;
import com.example.bookstore.repository.KnjigaRepository;
import com.example.bookstore.repository.KorisnikRepository;
import com.example.bookstore.repository.PosudbaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PosudbaService {

    private final PosudbaRepository posudbaRepository;
    private final KnjigaRepository knjigaRepository;
    private final KorisnikRepository korisnikRepository;

    @Autowired
    public PosudbaService(PosudbaRepository posudbaRepository, KnjigaRepository knjigaRepository, KorisnikRepository korisnikRepository) {
        this.posudbaRepository = posudbaRepository;
        this.knjigaRepository = knjigaRepository;
        this.korisnikRepository = korisnikRepository;
    }

    public List<Posudba> findAllPosudbe() {
        return posudbaRepository.findAll();
    }

    public Optional<Posudba> posudiKnjigu(Long knjigaId, String username) {
        Optional<Knjiga> knjiga = knjigaRepository.findById(knjigaId);
        Korisnik korisnik = korisnikRepository.findByUsername(username);

        if (knjiga.isPresent() && korisnik != null) {
            Posudba novaPosudba = new Posudba();
            novaPosudba.setKnjiga(knjiga.get());
            novaPosudba.setKorisnik(korisnik);
            novaPosudba.setDatumPosudbe(LocalDate.now());
            // Definirajte logiku za datum vraćanja prema poslovnoj logici
            return Optional.of(posudbaRepository.save(novaPosudba));
        }
        return Optional.empty();
    }

    public boolean vratiKnjigu(Long posudbaId) {
        Optional<Posudba> posudba = posudbaRepository.findById(posudbaId);
        if (posudba.isPresent()) {
            posudbaRepository.delete(posudba.get());
            return true;
        }
        return false;
    }

    // Implementacija metode za pronalaženje posudbi po korisniku
    public List<Posudba> findPosudbeByKorisnik(String username) {
        Korisnik korisnik = korisnikRepository.findByUsername(username);
        return posudbaRepository.findByKorisnik(korisnik);
    }
}
