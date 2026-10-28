package fr.medassi.democours.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity 
@Table(name = "ordinateurs")
public class Ordinateur extends Equipement {
    private String processeur;
    private Integer ramGo;
    @Enumerated (jakarta.persistence.EnumType.STRING)
    private TypePC typePc;

    public String getProcesseur() {
        return processeur;
    }
    public void setProcesseur(String processeur) {
        this.processeur = processeur;
    }
    public Integer getRamGo() {
        return ramGo;
    }
    public void setRamGo(Integer ramGo) {
        this.ramGo = ramGo;
    }
    public TypePC getTypePc() {
        return typePc;
    }
    public void setTypePc(TypePC typePc) {
        this.typePc = typePc;
    }
}
