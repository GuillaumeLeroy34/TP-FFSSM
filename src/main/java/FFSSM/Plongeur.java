package FFSSM;

import java.time.LocalDate;
import java.util.TreeSet;

public class Plongeur extends Personne {
    private TreeSet<Licence> myLicence = new TreeSet<>();
    private int niveau;
    private GroupeSanguin groupeSanguin;
    /**
     * constructeur de Plongeur
     * @param numeroINSEE
     * @param nom
     * @param prenom
     * @param adresse
     * @param telephone
     * @param naissance
     * @param niveau
     * @param g
     */
    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin g) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.groupeSanguin = g;
    }

    public void ajouteLicense(String numero, LocalDate delivrance, Club c) {
        this.myLicence.add(new Licence(this, numero, delivrance, c));
    }
        
    
    /**
     * renvoie la licence la plus récente
     * @return 
     */
        public Licence licenceRecente(){
            return this.myLicence.first();
        }
    }

