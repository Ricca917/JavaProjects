package org.example;

public class MainSpesa {
    public static void main(String[] args) {
        ListaSpesa listaSpesa = new ListaSpesa();


        listaSpesa.add("Carne", 3);
        listaSpesa.add("latte", 2);
        listaSpesa.add("coca cola", 1);
        listaSpesa.add("verdure", 2);
        listaSpesa.add("frutta", 1);


        listaSpesa.stampaLista();

        listaSpesa.remove("latte");

        listaSpesa.stampaLista();

        listaSpesa.acquista("latte", 4, 1.5, "Mukki");
        listaSpesa.acquista("frutta", 2, 5.0, "Mele");
        listaSpesa.acquista("Mozzarella", 1, 1.0, "Deliziosa");

        listaSpesa.stampaAcquisti();
    }
}