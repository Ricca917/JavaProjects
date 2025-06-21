package org.example;

import java.time.LocalTime;

public class Presenza {
    private PersonaleSanitario personale;
    private LocalTime orarioIngresso;
    private LocalTime orarioUscita;

    // Costruttore
    public Presenza(PersonaleSanitario personale, LocalTime orarioIngresso) {
        this.personale = personale;
        this.orarioIngresso = orarioIngresso;
        this.orarioUscita = null;
    }

    // Getter
    public PersonaleSanitario getPersonale() {
        return personale;
    }

    public LocalTime getOrarioIngresso() {
        return orarioIngresso;
    }

    public LocalTime getOrarioUscita() {
        return orarioUscita;
    }

    // Metodo per registrare l'uscita
    public void registraUscita(LocalTime orarioUscita) {
        if (this.orarioUscita == null) {
            this.orarioUscita = orarioUscita;
        } else {
            System.out.println("Uscita già registrata per " + personale.getCognome());
        }
    }

    // Metodo per sapere la presenza del personale
    public boolean isPresente() {
        return orarioUscita == null;
    }

    // Metodo per ottenere info su ingressi e uscite del Personale
    public String toString() {
        String stato= isPresente() ? "Presente" : "Uscito alle " + orarioUscita;
        return personale.getDescrizione() + " | Entrato alle: " + orarioIngresso + " | " + stato;
    }
}