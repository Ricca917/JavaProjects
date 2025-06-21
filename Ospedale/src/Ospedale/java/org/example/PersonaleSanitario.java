package org.example;

public abstract class PersonaleSanitario {
    private String nome;
    private String cognome;
    private String matricola;

    // Costruttore
    public PersonaleSanitario(String nome, String cognome, String matricola) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
    }


    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getMatricola() {
        return matricola;
    }

    // Metodo per ottenere la descrizione del personale sanitario

    public String getDescrizione() {
        return "Nome: " + nome + ", Cognome: " + cognome + ", Matricola: " + matricola;
    }


}