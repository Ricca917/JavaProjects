package org.example;

public enum Categoria {
    VERDURE(true),
    LATTICINI(true),
    FRUTTA(true),
    CARNE(true),
    SOTTOLI(false);

    private final boolean refrigerare;

    Categoria(boolean refrigerare) {
        this.refrigerare = refrigerare;
    }

    public String toString() {
        return this.name();
    }

}
