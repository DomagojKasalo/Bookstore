package com.example.bookstore.service;

import com.example.bookstore.model.Knjiga;
import com.example.bookstore.repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KnjigaService {

    private final KnjigaRepository knjigaRepository;

    @Autowired
    public KnjigaService(KnjigaRepository knjigaRepository) {
        this.knjigaRepository = knjigaRepository;
    }

    public List<Knjiga> findAllKnjige() {
        return knjigaRepository.findAll();
    }

    public Optional<Knjiga> findKnjigaById(Long id) {
        return knjigaRepository.findById(id);
    }

    public Knjiga saveKnjiga(Knjiga knjiga) {
        return knjigaRepository.save(knjiga);
    }

    public void deleteKnjiga(Long id) {
        knjigaRepository.deleteById(id);
    }
}
