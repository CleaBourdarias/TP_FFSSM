package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;

public class Plongeur extends Personne{
    
    public int niveau;
    public GroupeSanguin gs;
    
    public ArrayList<Licence> listeLicences;

    public Plongeur(int niveau, GroupeSanguin gs, String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.gs = gs;
        this.listeLicences = new ArrayList<>();
        
    }

    

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public GroupeSanguin getGs() {
        return gs;
    }

    public void setGs(GroupeSanguin gs) {
        this.gs = gs;
    }
    
    public void ajouteLicence(String numero, LocalDate delivrance, Club club){
        this.listeLicences.add(new Licence (this, numero, delivrance, club));
    }
    
    public Licence derniereLicence(){
        return listeLicences.get(listeLicences.size()-1);
    }
	
}
