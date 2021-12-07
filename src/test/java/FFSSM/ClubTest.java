/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package FFSSM;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author cleab
 */
public class ClubTest {
    
    
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
     * Test of organisePlongee method, of class Club.
     */
    @Test
    public void testOrganisePlongee() {
        // on ajoute plongee a la liste des plongees de club
            club.organisePlongee(plongee1);
            assertEquals(club.listePlongees.get(club.listePlongees.size()-1), plongee1);

    }
    
    @Test void testPlongeesNonConformes(){
            // on ajoute les plongees a la liste des plongees de club
            plongeur.ajouteLicence(licence.numero, licence.delivrance, licence.club);
            plongee1.ajouteParticipant(plongeur);
            plongee2.ajouteParticipant(plongeur);
            club.organisePlongee(plongee1);
            club.organisePlongee(plongee2);
           
            Set<Plongee> plongeesNonConformes = new HashSet<>();
            plongeesNonConformes.add(plongee2);

            assertEquals(club.plongeesNonConformes(), plongeesNonConformes);
    }
    
}
