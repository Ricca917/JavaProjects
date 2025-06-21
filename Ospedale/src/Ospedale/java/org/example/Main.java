package org.example;

public class Main {
    public static void main(String[] args) {

        // Creazione Reparto
        Reparto cardiologia = new Reparto("Cardiologia", "CARD01");
        System.out.println("Reparto creato: " + cardiologia.getNome() + " (Codice: " + cardiologia.getCodice() + ")");

        // Creazione personale sanitario
        Medico drMarco = new Medico("Marco", "Verdi", "M006", "Cardiologia");
        Infermiere infSara = new Infermiere("Sara", "Neri", "I010", true);
        Infermiere infPaolo = new Infermiere("Paolo", "Rossi", "I011", false);

        System.out.println("- " + drMarco.getDescrizione());
        System.out.println("- " + infSara.getDescrizione());
        System.out.println("- " + infPaolo.getDescrizione());

        // Aggiungo personale al reparto
        System.out.println("Aggiungo Dr. Marco");
        cardiologia.aggiungiPersonale(drMarco);
        System.out.println("Aggiungo Inf. Sara");
        cardiologia.aggiungiPersonale(infSara);
        System.out.println("Aggiungo Inf. Paolo ");
        cardiologia.aggiungiPersonale(infPaolo);

        // Stampa del personale attuale
        cardiologia.stampaPersonale();

        // Rimozione di Infermiera Sara che ha ID: I010
        System.out.println("Rimuovo Inf. Sara (I010)");
        cardiologia.rimuoviPersonale("I010");

        // Stampa del personale attuale
        cardiologia.stampaPersonale();

    }

}