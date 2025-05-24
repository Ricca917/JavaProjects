package org.example;

public class Giocatore {
    private String nome;
    private String cognome;
    private int eta;
    private String ruolo;
    private int numeroMaglia;
    private int presenze;
    private int gol;

    // Costruttore

    public Giocatore(String nome, String cognome, int eta, String ruolo,int numeroMaglia, int presenze, int gol) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.ruolo = ruolo;
        this.numeroMaglia = numeroMaglia;
        this.presenze = presenze;
        this.gol = gol;
    }

    // Getter

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getRuolo() {
        return ruolo;
    }

    public int getEta() {
        return eta;
    }

    public int getNumeroMaglia() {
        return numeroMaglia;
    }

    public int getPresenze() {
        return presenze;
    }

    public int getGol() {
        return gol;
    }

    // Metodo che Descrive un giocatore secondo i suoi attributi
    public String statGiocatore() {
        return "Nome: " + nome + ", Cognome: " + cognome + ", Età: " + eta +
                ", Ruolo: " + ruolo + ", Numero Maglia: " + numeroMaglia +
                ", Presenze: " + presenze + ", Gol: " + gol;
    }

}
