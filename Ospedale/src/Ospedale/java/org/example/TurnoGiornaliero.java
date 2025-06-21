package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TurnoGiornaliero {
    private LocalDate data; // Data del turno
    private List<Presenza> presenze;  // Lista delle presenze PS

    // Costruttore
    public TurnoGiornaliero(LocalDate data) {
        this.data = data;
        this.presenze = new ArrayList<>();
    }

    // Getter

    public LocalDate getData() {
        return data;
    }

    // Metodo di aggiunta ingresso
    public void aggiungiIngresso(Presenza presenza) {
        if (presenze.contains(presenza)) {
            System.out.println("Presenza già registrata per " + presenza.getPersonale().getCognome());
        } else {
            presenze.add(presenza);
        }
    }

    // Metodo di aggiunta uscita
    public void aggiungiUscita(String matricola, LocalTime orarioUscita) {
        for (Presenza p : presenze) {
            if (p.getPersonale().getMatricola().equals(matricola)) {
                p.registraUscita(orarioUscita);
                return;
            }
        }
        System.out.println("Presenza non trovata per matricola: " + matricola);
    }

    // Metodo per ottenere la lista delle presenze
    public void stampaPresenti() {
        System.out.println("Presenti il " + data + ":");
        for (Presenza p : presenze) {
            if (p.isPresente()) {
                System.out.println(p);
            }
        }
    }
}