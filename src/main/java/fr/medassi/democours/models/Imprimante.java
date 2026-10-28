package fr.medassi.democours.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity 
@Table (name = "imprimantes")
public class Imprimante extends Equipement {
    private boolean estCouleur;
    
    public boolean isEstCouleur() {
        return estCouleur;
    }
    public void setEstCouleur(boolean estCouleur) {
        this.estCouleur = estCouleur;
    }
}
