package com.example.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "posudbe")
public class Posudba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "korisnik_id")
    private Korisnik korisnik;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "knjiga_id")
    private Knjiga knjiga;

    private LocalDate datumPosudbe;
    private LocalDate datumVracanja;

    // Default konstruktor
    public Posudba() {
    }

    // Konstruktor sa parametrima
    public Posudba(Korisnik korisnik, Knjiga knjiga, LocalDate datumPosudbe, LocalDate datumVracanja) {
        this.korisnik = korisnik;
        this.knjiga = knjiga;
        this.datumPosudbe = datumPosudbe;
        this.datumVracanja = datumVracanja;
    }

    // Getters i Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public LocalDate getDatumPosudbe() {
        return datumPosudbe;
    }

    public void setDatumPosudbe(LocalDate datumPosudbe) {
    	this.datumPosudbe = datumPosudbe;
    }
    
    public LocalDate getDatumVracanja() {
        return datumVracanja;
    }

    public void setDatumVracanja(LocalDate datumVracanja) {
        this.datumVracanja = datumVracanja;
    }

    // toString metoda
    @Override
    public String toString() {
        return "Posudba{" +
                "id=" + id +
                ", korisnik=" + korisnik +
                ", knjiga=" + knjiga +
                ", datumPosudbe=" + datumPosudbe +
                ", datumVracanja=" + datumVracanja +
                '}';
    }
}
