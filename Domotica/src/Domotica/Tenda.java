package Domotica;

// La classe Tenda rappresenta una tenda automatizzata che può essere aperta o chiusa.
// Implementa l'interfaccia Dispositivo, quindi deve definire i metodi accendi(), spegni() e getNome().
public class Tenda implements Dispositivo {

    // Attributo per memorizzare il nome della tenda (es. "Tenda Salotto")
    private String nome;

    // Indica se la tenda è attualmente aperta (true) o chiusa (false)
    private boolean aperta;

    // Costruttore: inizializza la tenda con un nome e la imposta come chiusa
    public Tenda(String nome) {
        this.nome = nome;
        this.aperta = false;
    }

    // Metodo per aprire la tenda: imposta 'aperta' a true e stampa un messaggio
    public void apri() {
        aperta = true;
        System.out.println(nome + " aperta.");
    }

    // Metodo per chiudere la tenda: imposta 'aperta' a false e stampa un messaggio
    public void chiudi() {
        aperta = false;
        System.out.println(nome + " chiusa.");
    }

    // Metodo richiesto dall'interfaccia Dispositivo: restituisce il nome della tenda
    public String getNome() {
        return nome;
    }

    // Metodo richiesto dall'interfaccia Dispositivo: accende la tenda (la apre)
    @Override
    public void accendi() {
        apri();
    }

    // Metodo richiesto dall'interfaccia Dispositivo: spegne la tenda (la chiude)
    @Override
    public void spegni() {
        chiudi();
    }
}