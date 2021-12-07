/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    public ArrayList<Embauche> listeEmbauches;

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin gs, int numeroDiplome) {
        super(niveau, gs, numeroINSEE,  nom,  prenom,  adresse,  telephone,  naissance);
        this.numeroDiplome = numeroDiplome;
        this.listeEmbauches = new ArrayList<>();
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
         // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        //Optional <Club>  club = Optional.empty();
        Club club = null;
        if (this.listeEmbauches.get(this.listeEmbauches.size()-1).estTerminee()== false){
            club = this.listeEmbauches.get(this.listeEmbauches.size()-1).getEmployeur();
        }
        Optional<Club> op1 = Optional.ofNullable(club);
        return op1;
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
         // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        this.listeEmbauches.add(new Embauche(debutNouvelle, this, employeur));
    }

    public List<Embauche> emplois() {
         // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        return this.listeEmbauches;
    }
    
    public void terminerEmbauche(LocalDate fin){
        this.listeEmbauches.get(this.listeEmbauches.size()-1).terminer(fin);     
    }

}
