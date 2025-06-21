package org.example;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class ListaSpesa {

    static class Prodotto {
        String nome;
        String marca;
        int quantita;
        double prezzo;


        public Prodotto(String nome, String marca, int quantita, double prezzo) {
            this.nome = nome;
            this.marca = marca;
            this.quantita = quantita;
            this.prezzo = prezzo;

        }

        @Override
        public String toString() {
            return "Prodotto{" +
                    "nome='" + nome + '\'' +
                    ", marca='" + marca + '\'' +
                    ", quantita=" + quantita +
                    ", prezzo=" + prezzo +
                    '}';
        }
    }

    Map<String, Integer> lista;
    List<Prodotto> acquisti;

    public ListaSpesa() {
        this.lista = new LinkedHashMap<>();
        this.acquisti = new LinkedList<>();
    }

    public void add(String nomeProdotto, int quantita) {
        int nuovaQuantita = lista.getOrDefault(nomeProdotto, 0) + quantita;
        lista.put(nomeProdotto, nuovaQuantita);
    }

    /*
        public void add(String nomeProdotto, int quantita) {
            if (lista.containsKey(nomeProdotto)) {
                lista.put(nomeProdotto, quantita);
            }
        }
    */
    public void stampaLista() {
        System.out.println("Lista della spesa:");
        for (Map.Entry<String, Integer> entry : lista.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public Integer remove(String nomeProdotto) {
        return lista.remove(nomeProdotto);
    }

    public void acquista(String nomeProdotto, int quantitaEffettiva, double prezzo, String marca) {
        this.remove(nomeProdotto);
        Prodotto prodotto = new Prodotto(nomeProdotto, marca, quantitaEffettiva, prezzo);
        acquisti.add(prodotto);
    }

    public void stampaAcquisti() {
        for (Prodotto prodotto : acquisti) {
            System.out.println(prodotto);
        }
    }
}
