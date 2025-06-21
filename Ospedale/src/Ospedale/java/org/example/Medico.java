package org.example;

public class Medico extends PersonaleSanitario {
    private String specializzazione;

    // Costruttore
    public Medico(String nome, String cognome, String matricola, String specializzazione) {
        super(nome, cognome, matricola);
        this.specializzazione = specializzazione;
    }

    // Getter
    public String getSpecializzazione() {
        return specializzazione;
    }

    // Descrizione del medico
    @Override
    public String getDescrizione() {
        return super.getDescrizione() + " - Medico, Specializzazione:" + specializzazione;
    }
}
