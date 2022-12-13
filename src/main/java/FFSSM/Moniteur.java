/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {
    private Optional<Club> employeur;
    private ArrayList<Embauche> myEmbauches;
    public int numeroDiplome;
    
    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int numeroDiplome, int niveau, GroupeSanguin g) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau, g);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        return this.employeur;
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
        this.myEmbauches.add(new Embauche(debutNouvelle,this,employeur));
        this.employeur = Optional.of(employeur); // optional of permet de convertir un object en objet optionnel
    }

    public List<Embauche> emplois() {
         // TODO: Implémenter cette méthode
        return this.myEmbauches;
    }
    
    public Embauche trouverParClub(Club cible){
        Embauche retour = null;
        for(Embauche e : myEmbauches){
            if (e.getEmployeur().equals(cible)){
                retour = e;
            }
        }
        return retour;
    }
    
    
    
    public void terminerEmbauche(){
            if (this.employeur.isPresent()){
                this.employeur = null;
                this.trouverParClub((this.employeurActuel())).terminer(LocalDate.now())  ;
               }
            
    }

}
