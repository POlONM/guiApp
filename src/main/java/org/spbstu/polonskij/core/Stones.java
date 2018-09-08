package org.spbstu.polonskij.core;

public enum Stones {
    BLACK,
    WHITE;

    public Stones side() {
        if (this == BLACK) return WHITE;
        else return BLACK;
    }

    @Override
    public String toString() {
        if (this == BLACK) return "Black stone WIN!";
        return "White stone WIN!";
    }
}
