package Domotica;

// Interfaccia che definisce il comportamento comune di tutti i dispositivi domotici
public interface Dispositivo {

        // Metodo per accendere il dispositivo
        void accendi();

        // Metodo per spegnere il dispositivo
        void spegni();

        // Metodo per ottenere il nome identificativo del dispositivo
        String getNome();
}