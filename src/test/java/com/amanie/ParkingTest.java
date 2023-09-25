package com.amanie;

import static org.junit.jupiter.api.Assertions.assertEquals;

// import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ParkingTest {

    @Test
    // contexte_methodeSousTest_resultat
    public void vehiculesAutorisesVide_ajoutVehicule_devraitAjouterLeVehicule() {
        /// AAA : Arrange, Act, Assert
        // Arrange je mets en place mon test, notamment en instanciant et initialisation
        // le ou les objets concérnées

        Parking parking = new Parking(0);

        // Act j'appelle la méthode qui est sous test
        parking.ajoutVehicule("AB-3C");
        // Assert verification que tout s'est passé comme prévu
        assertEquals("AB-3C", parking.getVehiculesAutorises().get(0),
                "L'immatriculation n'est pas correct");
    }

    public void vehiculeDansLaListe_ajouterLeMemeVehicule_devraitNePasEtreAjoute() {

        Parking parking = new Parking(0);
        // parking.ajoutVehicule("AB-3C");
        parking.ajoutVehicule("AB-4C");
        // Assert verification que tout s'est passé comme prévu
        assertEquals(2, parking.getVehiculesAutorises().size(),
                "Insertion d'un doublon non possible revoir son code");
    }

    public void vehiculeDansLaListe_entreeVehicule_devraitEntree() {

        Parking parking = new Parking(1);
        parking.ajoutVehicule("AB-4C");

        // Assert verification que tout s'est passé comme prévu
        assertEquals(true, parking.entree("AB-4C"),
                "Entree pas possible alors que tout est ok");
        // assertEquals(false, parking.entree("AB-4C"),
        // "Entree possible alors que immatriculation non autorisées");
        // "Entree possible alors que capacité = 0 revoir son code"
    }

    public void vehiculeDansLaListe_entreeVehicule_devraitPasEntree() {

        Parking parking = new Parking(1);
        // Parking parking = new Parking(0);
        parking.ajoutVehicule("AB-4C");

        // Assert verification que tout s'est passé comme prévu
        assertEquals(false, parking.entree("AB-4C"),
                "Entree possible alors que immatriculation non autorisées");
        // "Entree possible alors que capacité = 0 revoir son code"
    }

    public void vehiculeDansLaListe_sortieVehicule_devraitSortir() {

        Parking parking = new Parking(1);
        parking.ajoutVehicule("AB-4C");

        // Assert verification que tout s'est passé comme prévu
        assertEquals(true, parking.sortie("AB-4C"),
                "Sortie pas possible alors que tout est ok");
    }

    public void vehiculePasDansLaListe_sortieVehicule_devraitPasSortir() {

        Parking parking = new Parking(0);

        // Assert verification que tout s'est passé comme prévu
        assertEquals(false, parking.sortie("AB-4C"),
                "Sortie possible alors que le vehicule n'est pas stationné ");

    }

    public void capaciteEgaleVehiculeStationnes_remplissage_remplit() {

        Parking parking = new Parking(0);

        // Assert verification que tout s'est passé comme prévu
        assertEquals(true, parking.remplit(),
                "Sortie possible alors que le vehicule n'est pas stationné ");

    }

    public void capaciteSuperieurVehiculesStationnes_remplissage_nonRemplit() {

        Parking parking = new Parking(2);
        parking.ajoutVehicule("AB-4C");
        // Assert verification que tout s'est passé comme prévu
        assertEquals(false, parking.remplit(),
                "Sortie possible alors que le vehicule n'est pas stationné ");

    }

    public void aucunVehiculesStationnes_nbVehicules_zero() {

        Parking parking = new Parking(0);
        assertEquals(0, parking.nbVehiculesStationnes(),
                "Normalement 0 vehicule or ca retourne un vehicule sans qu'il ait été ajouté");

    }

    public void aucunVehiculesStationnes_nbVehicules_un() {

        Parking parking = new Parking(0);
        parking.ajoutVehicule("abc-de");
        assertEquals(1, parking.nbVehiculesStationnes(),
                "Normalement 1 vehicule or ca retourne un autre nombre");

    }

    public void deuxVehiculesStationnes_listeVehiculesStationnes_listeDeTailleDeux() {

        Parking parking = new Parking(0);
        parking.ajoutVehicule("abc-de");
        parking.ajoutVehicule("12-dk");
        assertEquals(2, parking.GetVehiculesStationnes().size(),
                "Normalement 2 véhicules doivent être stationnés");

    }

    public void zeroVehiculesStationnes_listeVehiculesStationnes_listeDeTailleZero() {

        Parking parking = new Parking(0);

        assertEquals(0, parking.GetVehiculesStationnes().size(),
                "Normalement 0 véhicules doivent être stationnés");

    }

    public void zeroVehiculeAutorises_listeVehiculesAutorises_listeDeTailleZero() {

        Parking parking = new Parking(0);

        assertEquals(0, parking.GetVehiculesAutorises().size(),
                "Normalement 0 véhicules doivent être stationnés");

    }

    public void unVehiculeAutorises_listeVehiculesAutorises_listeDeTailleUn() {

        Parking parking = new Parking(0);
        parking.ajoutVehicule("ABC-234");
        assertEquals(1, parking.GetVehiculesAutorises().size(),
                "Normalement 0 véhicules doivent être stationnés");

    }

    public void unVehiculeStationneCapaciteUn_tauxRemplissage_cent() {
        Parking parking = new Parking(1);
        parking.ajoutVehicule("ABC-234");
        parking.entree("ABC-234");
        assertEquals(100, parking.tauxRemplissage(),
                "Normalement 100% taux remplissage");
    }

    public void zeroVehiculeStationneCapaciteDeux_tauxRemplissage_zero() {
        Parking parking = new Parking(2);

        assertEquals(0, parking.tauxRemplissage(),
                "Normalement 0% taux remplissage");
    }

    public void zeroVehiculeStationneCapaciteUn_tauxRemplissage_zero() {
        Parking parking = new Parking(2);
        parking.ajoutVehicule("ABC-234");
        parking.entree("ABC-234");
        assertEquals(50, parking.tauxRemplissage(),
                "Normalement 50% taux remplissage");
    }

}
