package Domotica;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // Creo una lista di dispositivi di tipo Dispositivo (interfaccia)
        List<Dispositivo> dispositivi = new ArrayList<>();

        // Creo i dispositivi concreti con i loro nomi
        Lampadina lampadina = new Lampadina("Lampadina");
        Termostato termostato = new Termostato("Termostato");
        Tenda tenda = new Tenda("Tenda");

        // Aggiungo i dispositivi alla lista
        dispositivi.add(lampadina);
        dispositivi.add(termostato);
        dispositivi.add(tenda);

        // Ciclo su tutti i dispositivi e li accendo usando il metodo comune accendi()
        for (Dispositivo d : dispositivi) {
            d.accendi();
        }

        // Ora uso i metodi specifici delle singole classi con cast esplicito
        lampadina.intensita(10);    // Imposta intensità luce della lampadina
        termostato.setTemperatura(22);   // Imposta temperatura del termostato

        // Ciclo di nuovo su tutti i dispositivi per spegnerli usando il metodo comune spegni()
        for (Dispositivo d : dispositivi) {
            d.spegni();
        }
    }
}