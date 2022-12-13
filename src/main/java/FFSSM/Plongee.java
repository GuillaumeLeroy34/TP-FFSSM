/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Plongee {

    public ArrayList<Plongeur> myParticipants;

    public Site lieu;

    public Moniteur chefDePalanquee;

    public LocalDate date;

    public int profondeur;

    public int duree;

    public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
        this.myParticipants = new ArrayList<>();
    }

    public void ajouteParticipant(Plongeur participant) {
        this.myParticipants.add(participant);
    }

    public LocalDate getDate() {
        return date;
    }

    /**
     * Détermine si la plongée est conforme. Une plongée est conforme si tous
     * les plongeurs de la palanquée ont une licence valide à la date de la
     * plongée
     *
     * @return vrai si la plongée est conforme
     */
    public boolean estConforme() {
        boolean retour = true;
        for (Plongeur p : myParticipants) {
            if (!p.licenceRecente().estValide(LocalDate.now())) {
                retour = false;
            }
        }
        return retour;

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.myParticipants);
        hash = 47 * hash + Objects.hashCode(this.lieu);
        hash = 47 * hash + Objects.hashCode(this.chefDePalanquee);
        hash = 47 * hash + Objects.hashCode(this.date);
        hash = 47 * hash + this.profondeur;
        hash = 47 * hash + this.duree;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Plongee other = (Plongee) obj;
        if (this.profondeur != other.profondeur) {
            return false;
        }
        if (this.duree != other.duree) {
            return false;
        }
        if (!Objects.equals(this.myParticipants, other.myParticipants)) {
            return false;
        }
        if (!Objects.equals(this.lieu, other.lieu)) {
            return false;
        }
        if (!Objects.equals(this.chefDePalanquee, other.chefDePalanquee)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }
    
    

}   
