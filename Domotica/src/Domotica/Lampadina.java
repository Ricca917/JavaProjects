package Domotica;

// La classe Lampadina rappresenta una lampadina intelligente.
// Implementa l'interfaccia Dispositivo, quindi deve definire accendi(), spegni() e getNome().
public class Lampadina implements Dispositivo {

    // Attributo per il nome della lampadina (es. "Lampadina Camera")
    private String nome;

    // Indica se la lampadina è accesa (true) o spenta (false)
    private boolean accesa;

    // Costruttore: inizializza la lampadina con un nome e la imposta come spenta
    public Lampadina(String nome) {
        this.nome = nome;
        this.accesa = false;
    }

    // Metodo richiesto dall'interfaccia Dispositivo: accende la lampadina
    @Override
    public void accendi() {
        accesa = true;
        System.out.println(nome + " accesa.");
    }

    // Metodo richiesto dall'interfaccia Dispositivo: spegne la lampadina
    @Override
    public void spegni() {
        accesa = false;
        System.out.println(nome + " spenta.");
    }

    // Metodo richiesto dall'interfaccia Dispositivo: restituisce il nome della lampadina
    @Override
    public String getNome() {
        return nome;
    }

    // Metodo specifico della lampadina: imposta il livello di intensità della luce
    public void intensita(int livello) {
        System.out.println(nome + " intensità impostata a " + livello + ".");
    }
}