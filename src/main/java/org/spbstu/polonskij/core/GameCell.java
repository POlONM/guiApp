package org.spbstu.polonskij.core;

public final class GameCell {
    private final int x;

    private final int y;

    public GameCell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameCell gameCell = (GameCell) o;

        if (getX() != gameCell.getX()) return false;
        return getY() == gameCell.getY();
    }

    @Override
    public int hashCode() {
        int result = getX();
        result = 31 * result + getY();
        return result;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}
