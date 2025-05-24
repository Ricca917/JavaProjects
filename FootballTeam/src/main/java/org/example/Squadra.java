package org.example;
import java.util.ArrayList;
import java.util.List;

public class Squadra implements OperazioniRosa {
    private String nomeSquadra;
    private int annoFondazione;
    private String presidente;
    private String allenatore;
    private List<Giocatore> rosaGiocatori;

    //Costruttore
    public Squadra(String nomeSquadra, int annoFondazione, String presidente, String allenatore) {
        this.nomeSquadra = nomeSquadra;
        this.annoFondazione = annoFondazione;
        this.presidente = presidente;
        this.allenatore = allenatore;
        this.rosaGiocatori = new ArrayList<>();
    }

    // Getter
    public String getNomeSquadra() {
        return nomeSquadra;
    }

    public int getAnnoFondazione() {
        return annoFondazione;
    }

    public String getPresidente() {
        return presidente;
    }

    public String getAllenatore() {
        return allenatore;
    }

    public List<Giocatore> getRosaGiocatori() {
        return rosaGiocatori;
    }


    // Metodo per aggiungere un giocatore alla rosa
    @Override
    public void aggiungiGiocatore(Giocatore giocatore) {
        this.rosaGiocatori.add(giocatore);
    }


    @Override
    public void rimuoviGiocatore(Giocatore giocatore) {
        this.rosaGiocatori.remove(giocatore);
    }


    @Override
    public void stampaRosa() {
        for (Giocatore g : this.rosaGiocatori) {
            System.out.println(g.statGiocatore());
        }
    }



}

