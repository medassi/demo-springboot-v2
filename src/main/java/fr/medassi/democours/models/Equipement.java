package fr.medassi.democours.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "equipements")
@Inheritance (strategy = jakarta.persistence.InheritanceType.JOINED)
public abstract class Equipement {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String numeroSerie;
    private Float prix ;
    @ManyToOne(fetch = FetchType.LAZY)
    private Service service;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNumeroSerie() {
        return numeroSerie;
    }
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    public Float getPrix() {
        return prix;
    }
    public void setPrix(Float prix) {
        this.prix = prix;
    }
    public Service getService() {
        return service;
    }
    public void setService(Service service) {
        this.service = service;
    }
    @Override
    public String toString() {
        return "Equipement [id=" + id + ", nom=" + nom + ", numeroSerie=" + numeroSerie + ", prix=" + prix
                + ", service=" + (service != null ? service.getNom() : "Non affecté") + "]";
    }
}