package org.example;

public class Infermiere extends PersonaleSanitario {
    private boolean abilitazioneFarmaci;

    // Costruttore
    public Infermiere(String nome, String cognome, String matricola, boolean abilitazioneFarmaci) {
        super(nome, cognome, matricola);
        this.abilitazioneFarmaci = abilitazioneFarmaci;
    }

    // Getter
    public boolean isAbilitazioneFarmaci() {
        return abilitazioneFarmaci;
    }

    // Descrizione dell'infermiere
    @Override
    public String getDescrizione() {
        return super.getDescrizione() + " - Infermiere, Abilitazione Farmaci: " + (abilitazioneFarmaci ? "Sì" : "No");
    }
}
