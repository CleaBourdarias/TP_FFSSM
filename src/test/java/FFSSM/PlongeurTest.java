/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package FFSSM;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author cleab
 */
public class PlongeurTest {
    
    
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
        
        @Test
        public void testAjouterLicence(){
            // on ajoute licence a la liste des licences de plongeur
            plongeur.ajouteLicence(licence.numero,  licence.delivrance, licence.club);
            assertEquals(plongeur.listeLicences.get(plongeur.listeLicences.size()-1).club, licence.club);
            assertEquals(plongeur.listeLicences.get(plongeur.listeLicences.size()-1).delivrance, licence.delivrance);
            assertEquals(plongeur.listeLicences.get(plongeur.listeLicences.size()-1).numero, licence.numero);
            assertEquals(plongeur.listeLicences.get(plongeur.listeLicences.size()-1).possesseur, licence.possesseur);
        }
        
        @Test
        public void testDerniereLicence(){
            // on ajoute licence a la liste des licences de plongeur
            plongeur.ajouteLicence(licence.numero,  licence.delivrance, licence.club);
            Licence l = plongeur.derniereLicence();
            assertEquals(l.club, licence.club);
            assertEquals(l.delivrance, licence.delivrance);
            assertEquals(l.numero, licence.numero);
            assertEquals(l.possesseur, licence.possesseur);
        }
}
