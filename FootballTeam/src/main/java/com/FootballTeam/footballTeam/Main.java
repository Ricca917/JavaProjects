package com.FootballTeam.footballTeam; // Mantiene il package originale per ora

import com.FootballTeam.footballTeam.model.Player; // Importa la tua entità Player dal modello
import com.FootballTeam.footballTeam.model.Team;   // Importa la tua entità Team dal modello
import java.util.List; // Necessario se ci fossero metodi che restituiscono List

public class Main {
    public static void main(String[] args) {

        //Creazione Squadre
        Team juventus = new Team("Juventus", 1897, "Gianluca Ferrero", "Igor Tudor");

        Player vlahovic = new Player("Dusan", "Vlahovic", 22, "Attaccante", 9, 30, 10);
        Player yildiz = new Player("Kenan", "Yildiz", 18, "Centrocampista", 10, 15, 5);
        Player koloMuani = new Player("Randal", "Kolo Muani", 24, "Attaccante", 20, 10, 7);
        Player locatelli = new Player("Manuel", "Locatelli", 25, "Centrocampista", 8, 35, 3);
        Player bremer = new Player("Gleison", "Bremer", 26, "Difensore", 3, 40, 1);
        Player gatti = new Player("Federico", "Gatti", 24, "Difensore", 4, 30, 2);

        //Aggiunta Giocatori alla rosa della squadra Juventus
        juventus.addPlayer(vlahovic); // Usa il nuovo nome del metodo
        juventus.addPlayer(yildiz);
        juventus.addPlayer(koloMuani);
        juventus.addPlayer(locatelli);
        juventus.addPlayer(bremer);
        juventus.addPlayer(gatti);

        //Stampa della rosa della squadra Juventus (questa parte va adattata, Team.stampaRosa() non esiste più)
        System.out.println("Rosa della squadra " + juventus.getTeamName() + ":");
        // Per stampare la rosa qui, si dovrebbe iterare manualmente:
        for (Player p : juventus.getRosterPlayers()) {
            System.out.println(p.toString()); // Usa il toString di Player
        }

        //Rimozione di un giocatore dalla rosa
        juventus.removePlayer(koloMuani); // Usa il nuovo nome del metodo
        juventus.removePlayer(locatelli);
        System.out.println("Giocatore " + koloMuani.getFirstName() + " rimosso dalla rosa della squadra " + juventus.getTeamName() + ".");

        //Stampa della rosa aggiornata della squadra Juventus
        System.out.println("Rosa aggiornata della squadra " + juventus.getTeamName() + ":");
        for (Player p : juventus.getRosterPlayers()) {
            System.out.println(p.toString());
        }

        // Stampa delle info di un giocatore
        System.out.println("Info del giocatore " + vlahovic.getFirstName() + ": " + vlahovic.toString()); // Usa il toString di Player
    }
}