package com.example.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "knjige")
public class Knjiga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naslov;
    private String autor;
    private String isbn;
    private Integer godinaIzdanja;

    // Default konstruktor
    public Knjiga() {
    }

    // Konstruktor sa parametrima
    public Knjiga(String naslov, String autor, String isbn, Integer godinaIzdanja) {
        this.naslov = naslov;
        this.autor = autor;
        this.isbn = isbn;
        this.godinaIzdanja = godinaIzdanja;
    }

    // Getters i Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getGodinaIzdanja() {
        return godinaIzdanja;
    }

    public void setGodinaIzdanja(Integer godinaIzdanja) {
        this.godinaIzdanja = godinaIzdanja;
    }

    // toString metoda
    @Override
    public String toString() {
        return "Knjiga{" +
                "id=" + id +
                ", naslov='" + naslov + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", godinaIzdanja=" + godinaIzdanja +
                '}';
    }
}
