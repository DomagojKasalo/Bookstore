package com.example.bookstore.repository;

import com.example.bookstore.model.Knjiga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnjigaRepository extends JpaRepository<Knjiga, Long> {
    // Ovdje možete dodati prilagođene metode upita ako su potrebne
}
