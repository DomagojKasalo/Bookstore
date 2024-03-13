package com.example.bookstore.repository;

import com.example.bookstore.model.Korisnik;
import com.example.bookstore.model.Posudba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosudbaRepository extends JpaRepository<Posudba, Long> {
    List<Posudba> findByKorisnik(Korisnik korisnik);
    
    @Query("SELECT p FROM Posudba p WHERE p.korisnik.username = :username")
    List<Posudba> findByKorisnikUsername(@Param("username") String username);
}
