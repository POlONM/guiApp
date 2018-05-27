package org.spbstu.polonskij;

public enum Stones {
    BLACK,
    WHITE;

    public Stones side() {
        if (this == BLACK) return WHITE;
        else return BLACK;
    }
}
