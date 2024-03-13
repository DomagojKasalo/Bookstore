package com.example.bookstore.repository;

import com.example.bookstore.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Korisnik findByUsername(String username);
}
