package Domotica;

// La classe Termostato rappresenta un termostato intelligente che può essere acceso/spento
// e permette di regolare la temperatura. Implementa l'interfaccia Dispositivo.
public class Termostato implements Dispositivo {

    // Attributo che memorizza il nome del termostato (es. "Termostato Soggiorno")
    private String nome;

    // Temperatura attuale impostata sul termostato
    private int temperatura;

    // Stato del termostato: true se acceso, false se spento
    private boolean acceso;

    // Costruttore: inizializza il nome, imposta una temperatura predefinita (20°C) e lo stato spento
    public Termostato(String nome) {
        this.nome = nome;
        this.temperatura = 20; // temperatura predefinita
        this.acceso = false;
    }

    // Metodo richiesto dall'interfaccia Dispositivo: accende il termostato
    @Override
    public void accendi() {
        acceso = true;
        System.out.println(nome + " acceso.");
    }

    // Metodo richiesto dall'interfaccia Dispositivo: spegne il termostato
    @Override
    public void spegni() {
        acceso = false;
        System.out.println(nome + " spento.");
    }

    // Metodo richiesto dall'interfaccia Dispositivo: restituisce il nome del termostato
    @Override
    public String getNome() {
        return nome;
    }

    // Metodo specifico del termostato: permette di impostare una nuova temperatura
    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
        System.out.println(nome + " temperatura impostata a " + temperatura + "°C.");
    }
}