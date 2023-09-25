package com.amanie;

import java.util.ArrayList;

public class Parking {
    private ArrayList<String> vehiculesAutorises;// S'ils ne sont pas instanciés 0 des objets c'est NULL
    private ArrayList<String> vehiculesStationnes; // S'ils ne sont pas instanciés 0 des objets c'est NULL
    private int capacite; // = 0
    // S'ils ne sont pas instanciés Pour un boolean ca sera false

    public Parking(int capacite) {
        super();
        this.capacite = capacite;
        this.vehiculesAutorises = new ArrayList<>();
        this.vehiculesStationnes = new ArrayList<>();
    };

    public ArrayList<String> getVehiculesAutorises() {
        return vehiculesAutorises;
    }

    // Ajouter l'immatriculation d'un véhicule à la liste des immatriculations
    public void ajoutVehicule(String immatriculation) {
        if (!this.vehiculesAutorises.contains(immatriculation)) {
            this.vehiculesAutorises.add(immatriculation);
        }

    }

    // Entrée d'un véhicule, identifié par son immatriculation en verifiant s'il est
    // est ce que je sépare la verification du stationnement ?
    // est ce que je return True false ou du texte ?²
    public boolean entree(String immatriculation) {
        if (this.vehiculesAutorises.contains(immatriculation) && this.tauxRemplissage() < 100) {
            this.vehiculesStationnes.add(immatriculation);
            return true;
        }
        return false;
    };
    // Enregistrer la sortie d'un véhicule

    public boolean sortie(String immatriculation) {
        if (dansParking(immatriculation)) {
            this.vehiculesStationnes.remove(immatriculation);
            return true;
        }
        return false;
    };

    // Savoir si x vehicule est dans le parking
    public boolean dansParking(String immatriculation) {
        if (this.vehiculesStationnes.contains(immatriculation)) {
            return true;
        }
        return false;
    };

    // Parking pleins ou pas
    public boolean remplit() {
        return this.vehiculesStationnes.size() == capacite;
    };

    // le nombre de véhicules actuellement sur le parking.
    public int nbVehiculesStationnes() {
        return this.vehiculesStationnes.size();
    }

    // Liste véhicule stationner
    public ArrayList<String> GetVehiculesStationnes() {
        return this.vehiculesStationnes;
    }

    // la liste des véhicules autorisés
    public ArrayList<String> GetVehiculesAutorises() {
        return this.vehiculesAutorises;
    }

    // taux remplissage parking
    public double tauxRemplissage() {
        double tauxRemplissage = (double) this.vehiculesStationnes.size() / this.capacite * 100;
        return tauxRemplissage;
    }

}
