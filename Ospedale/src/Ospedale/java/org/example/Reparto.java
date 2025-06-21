package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*La classe Reparto rappresenta un reparto di un ospedale.
*Contiene informazioni sul nome, codice identificativo,
*personale sanitario e turni giornalieri.
*/

public class Reparto {
    private String nome;
    private String codice;
    private List<PersonaleSanitario> personale;
    private Map<LocalDate, TurnoGiornaliero> turni;


    public Reparto(String nome, String codice) {
        this.nome = nome;                       // Nome del reparto
        this.codice = codice;                   // Codice identificativo del reparto
        this.personale = new ArrayList<>();     // Lista di personale sanitario
        this.turni = new HashMap<>();           // Mappa dei turni giornalieri
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getCodice() {
        return codice;
    }

    public List<PersonaleSanitario> getPersonale() {
        return personale;
    }

    public Map<LocalDate, TurnoGiornaliero> getTurni() {
        return turni;
    }

    // Metodo per aggiungere personale sanitario al reparto
    public boolean aggiungiPersonale(PersonaleSanitario ps) {
        for (PersonaleSanitario p : personale) {
            if (p.getMatricola().equals(ps.getMatricola())) {
                System.out.println("Attenzione! Personale con matricola: " + ps.getMatricola() + "e cognome" + ps.getCognome() + "già presente in reparto.");
                return false;
            }

        }
        personale.add(ps);
        System.out.println("Personale " + ps.getNome() + " " + ps.getCognome() + " aggiunto al reparto " + nome);
        return true;

    }

    // Metodo per rimuovere personale sanitario dal reparto
    // Cerco il personale da rimuovere in base alla matricola
    public boolean rimuoviPersonale(String matricola) {
        PersonaleSanitario psDaRimuovere = null;
        for (PersonaleSanitario ps : personale) {
            if (ps.getMatricola().equals(matricola)) {
                psDaRimuovere = ps;
                break;  // Uscita dal ciclo se trovato personale da rimuovere
            }
        }

        if (psDaRimuovere != null) {
            personale.remove(psDaRimuovere);
            System.out.println(psDaRimuovere.getCognome() + " " +  matricola + "rimosso dal reparto" + nome + ".");
            return true;


        } else {
            System.out.println("ERRORE: Personale con matricola " + matricola + "non esiste nel reparto" + nome + ".");
            return false;
        }
    }

    // Metodo per stampare la lista di tutto il personale presente in reparto
    public void stampaPersonale() {
        System.out.println("Personale attualmente in reparto: " + nome + " " + codice );
        if (personale.isEmpty()) {
            System.out.println("Nessun personale in reparto: " + nome + "al momento. ");
            return;
        }

        for (PersonaleSanitario ps : personale) {
            System.out.println("- " + ps.getDescrizione());
        }
    }
}

