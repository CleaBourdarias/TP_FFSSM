/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author cleab
 */
public class MoniteurTest {
    
    
        Club club;
        Moniteur moniteur;
        Plongee plongee1;
        Plongee plongee2;
        Plongeur plongeur;
        Licence licence;
        Embauche embauche;
    
        @BeforeEach
        public void setUp() {
            plongeur = new Plongeur(3, GroupeSanguin.APLUS, "HDG73VDH", "Truc", "Machin", "ici", "876352093", LocalDate.of(1980, 1, 8));
            moniteur = new Moniteur("E548", "untel", "truc", "la", "56524", LocalDate.of(1980, 1, 8), 3, GroupeSanguin.APLUS, 654);
            club = new Club(moniteur, "club1", "0956578");
            plongee1 = new Plongee(new Site("ici", "details"), moniteur, LocalDate.of(1980, 1, 8), 600, 3);	     
            plongee2 = new Plongee(new Site("ici", "details"), moniteur, LocalDate.of(2021, 1, 8), 600, 3);	     
            licence = new Licence(plongeur, "klcjk23",  LocalDate.of(1980, 1, 8), club);
            embauche = new Embauche(LocalDate.of(2020, 1, 8), moniteur, club);
        }
    /**
     * Test of employeurActuel method, of class Moniteur.
     */
    
    @Test
        public void testEmployeurActuel(){
            // on ajoute embauche a la liste des embauches du moniteur
            moniteur.nouvelleEmbauche(club, LocalDate.of(2020, 1, 8));
            assertEquals(club,embauche.getEmployeur());
        }
        
        @Test
        public void testEmployeurActuelNull(){
            moniteur.nouvelleEmbauche(club, LocalDate.of(2020, 1, 8));
            // on termine le dernière embauche
            moniteur.terminerEmbauche(LocalDate.of(2020, 1, 8));
            Optional<Club> c = Optional.empty();
            assertEquals(c,moniteur.employeurActuel());
        }

    
    
    @Test
    public void testNouvelleEmbauche(){
            // on ajoute embauche a la liste des embauches de moniteur
            moniteur.nouvelleEmbauche(embauche.getEmployeur(),  embauche.getDebut());
            assertEquals(moniteur.listeEmbauches.get(moniteur.listeEmbauches.size()-1).getDebut(), embauche.getDebut());
            assertEquals(moniteur.listeEmbauches.get(moniteur.listeEmbauches.size()-1).getEmploye(), embauche.getEmploye());
            assertEquals(moniteur.listeEmbauches.get(moniteur.listeEmbauches.size()-1).getEmployeur(), embauche.getEmployeur());
    }
        
    @Test
    public void testTerminerEmbauche(){
            // on ajoute embauche a la liste des embauches de moniteur
            moniteur.nouvelleEmbauche(embauche.getEmployeur(),  embauche.getDebut());
            // on termine l'embauche
            moniteur.terminerEmbauche(LocalDate.of(2020, 12, 3));
            assertTrue(moniteur.listeEmbauches.get(moniteur.listeEmbauches.size()-1).estTerminee());
    }
    
}
