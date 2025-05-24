package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Creazione Squadre
         Squadra Juventus = new Squadra("Juventus",1897,"Gianluca Ferrero","Igor Tudor");

        Giocatore Vlahovic = new Giocatore("Dusan","Vlahovic", 22, "Attaccante", 9, 30, 10);
        Giocatore Yildiz = new Giocatore("Kenan","Yildiz", 18, "Centrocampista", 10, 15, 5);
        Giocatore Kolo_Muani = new Giocatore("Randal","Kolo Muani", 24, "Attaccante", 20, 10, 7);
        Giocatore Locatelli = new Giocatore("Manuel","Locatelli", 25, "Centrocampista", 8, 35, 3);
        Giocatore Bremer = new Giocatore("Gleison","Bremer", 26, "Difensore", 3, 40, 1);
        Giocatore Gatti = new Giocatore("Federico","Gatti", 24, "Difensore", 4, 30, 2);

        //Aggiunta Giocatori alla rosa della squadra Juventus
        Juventus.aggiungiGiocatore(Vlahovic);
        Juventus.aggiungiGiocatore(Yildiz);
        Juventus.aggiungiGiocatore(Kolo_Muani);
        Juventus.aggiungiGiocatore(Locatelli);
        Juventus.aggiungiGiocatore(Bremer);
        Juventus.aggiungiGiocatore(Gatti);

        //Stampa della rosa della squadra Juventus
        System.out.println("Rosa della squadra " + Juventus.getNomeSquadra() + ":");
        Juventus.stampaRosa();

        //Rimozione di un giocatore dalla rosa
        Juventus.rimuoviGiocatore(Kolo_Muani);
        Juventus.rimuoviGiocatore(Locatelli);
        System.out.println("Giocatore " + Kolo_Muani.getNome() + " rimosso dalla rosa della squadra " + Juventus.getNomeSquadra() + ".");

        //Stampa della rosa aggiornata della squadra Juventus
        System.out.println("Rosa aggiornata della squadra " + Juventus.getNomeSquadra() + ":");
        Juventus.stampaRosa();

        // Stampa delle info di un giocatore
        System.out.println("Info del giocatore " + Vlahovic.getNome() + ": " + Vlahovic.statGiocatore());

    }
}
