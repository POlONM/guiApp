package org.spbstu.polonskij.core;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameBoard {

    public GameBoard(int i, int i1) {
        int x = 15;
        int y = 15;
    }


    public final Map<GameCell, Stones> stones = new HashMap<GameCell, Stones>();

    public Stones turn = Stones.BLACK;

    @Nullable
    private Stones getStone(GameCell cell) {
        return stones.get(cell);
    }

    @Nullable
    private Stones getStone(int x, int y) {
        return getStone(new GameCell(x, y));
    }

    public boolean freeCell() {
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                if (getStone(x, y) == null) return true;
            }
        }
        return false;
    }

    private boolean fouls(Stones stone) {
        ArrayList<Integer> foul = new ArrayList<Integer>();
        foul.add(2);
        foul.add(3);
        if (turn.equals(Stones.BLACK)) {
            for (int x = 0; x < 15; x++) {
                for (int y = 0; y < 15; y++) {
                    GameCell cell = new GameCell(x, y);
                    stone = getStone(cell);
                    if (stone == null) continue;
                    int i;
                    for (i = 1; i < 4; i++) {
                        if (getStone(x + i, y) != stone && getStone(x - i, y) != stone) break;
                    }
                    if (foul.contains(i)) {
                        return true;
                    }
                    for (i = 1; i < 4; i++) {
                        if (getStone(x + i, y) != stone && getStone(x, y + i) != stone) break;
                    }
                    if (foul.contains(i)) {
                        return true;
                    }
                    for (i = 1; i < 4; i++) {
                        if (getStone(x + i, y) != stone && getStone(x, y - i) != stone) break;
                    }
                    if (foul.contains(i)) {
                        return true;
                    }
                    for (i = 1; i < 4; i++) {
                        if (getStone(x - i, y) != stone && getStone(x, y - i) != stone) break;
                    }
                    if (foul.contains(i)) {
                        return true;
                    }
                    for (i = 1; i < 4; i++) {
                        if (getStone(x - i, y) != stone && getStone(x, y + i) != stone) break;
                    }
                    if (foul.contains(i)) {
                        return true;
                    }
                    for (i = 1; i < 4; i++) {
                        if (getStone(x, y + i) != stone && getStone(x, y - i) != stone) break;
                    }
                    if (foul.contains(i)) {
                        return true;
                    }
                    for (i = 1; i < 4; i++) {
                        if (getStone(x + i, y + i) != stone && (getStone(x + i, y) != stone
                                && getStone(x, y + i) != stone) && getStone(x, y - i) != stone
                                && getStone(x - i, y) != stone) break;
                    }
                    if (foul.contains(i)) {
                        return true;
                    }
                    for (i = 1; i < 4; i++) {
                        if (getStone(x - i, y - i) != stone && (getStone(x + i, y) != stone
                                && getStone(x, y + i) != stone) && getStone(x, y - i) != stone
                                && getStone(x - i, y) != stone) break;
                    }
                    if (foul.contains(i)) {
                        return true;
                    }
                    for (i = 1; i < 4; i++) {
                        if (getStone(x + i, y - i) != stone && (getStone(x + i, y) != stone
                                && getStone(x, y + i) != stone) && getStone(x, y - i) != stone
                                && getStone(x - i, y) != stone) break;
                    }
                    if (foul.contains(i)) {
                        return true;
                    }
                    for (i = 1; i < 4; i++) {
                        if (getStone(x - i, y + i) != stone && (getStone(x + i, y) != stone
                                && getStone(x, y + i) != stone) && getStone(x, y - i) != stone
                                && getStone(x - i, y) != stone) break;
                    }
                    if (foul.contains(i)) {
                        return true;
                    }
                    for (i = 1; i < 4; i++) {
                        if (getStone(x + i, y + i) != stone && getStone(x - i, y - i) != stone) break;
                    }
                    if (foul.contains(i)) {
                        return true;
                    }
                    for (i = 1; i < 4; i++) {
                        if (getStone(x + i, y + i) != stone && getStone(x + i, y - i) != stone) break;
                    }
                    if (foul.contains(i)) {
                        return true;
                    }
                    for (i = 1; i < 4; i++) {
                        if (getStone(x + i, y + i) != stone && getStone(x - i, y + i) != stone) break;
                    }
                    if (foul.contains(i)) {
                        return true;
                    }
                    for (i = 1; i < 4; i++) {
                        if (getStone(x + i, y - i) != stone && getStone(x - i, y + i) != stone) break;
                    }
                    if (foul.contains(i)) {
                        return true;
                    }
                    for (i = 1; i < 4; i++) {
                        if (getStone(x + i, y - i) != stone && getStone(x - i, y - i) != stone) break;
                    }
                    if (foul.contains(i)) {
                        return true;
                    }
                    for (i = 1; i < 4; i++) {
                        if (getStone(x - i, y + i) != stone && getStone(x - i, y - i) != stone) break;
                    }
                    if (foul.contains(i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Stones win(Map<GameCell, Stones> stones) {
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                GameCell cell = new GameCell(x, y);
                Stones stone = getStone(cell);
                if (stone == null) continue;
                int i;
                for (i = 1; i < 9; i++) {
                    if (getStone(x + i, y) != stone) break;
                }
                if (i >= 5) {
                    if ((stone.equals(Stones.WHITE)) || stone.equals(Stones.BLACK) && (i > 5 || fouls(getStone(x + i, y))))
                        return Stones.WHITE;
                    else return Stones.BLACK;
                }
                for (i = 1; i < 9; i++) {
                    if (getStone(x - i, y) != stone) break;
                }
                if (i >= 5) {
                    if ((stone.equals(Stones.WHITE)) || stone.equals(Stones.BLACK) && (i > 5 || fouls(getStone(x - i, y))))
                        return Stones.WHITE;
                    else return Stones.BLACK;
                }
                for (i = 1; i < 9; i++) {
                    if (getStone(x, y + i) != stone) break;
                }
                if (i >= 5) {
                    if ((stone.equals(Stones.WHITE)) || stone.equals(Stones.BLACK) && (i > 5 || fouls(getStone(x, y + i))))
                        return Stones.WHITE;
                    else return Stones.BLACK;
                }
                for (i = 1; i < 9; i++) {
                    if (getStone(x, y - i) != stone) break;
                }
                if (i >= 5) {
                    if ((stone.equals(Stones.WHITE)) || stone.equals(Stones.BLACK) && (i > 5 || fouls(getStone(x, y - i))))
                        return Stones.WHITE;
                    else return Stones.BLACK;
                }
                for (i = 1; i < 9; i++) {
                    if (getStone(x + i, y + i) != stone) break;
                }
                if (i >= 5) {
                    if ((stone.equals(Stones.WHITE)) || stone.equals(Stones.BLACK) && (i > 5 || fouls(getStone(x + i, y + i))))
                        return Stones.WHITE;
                    else return Stones.BLACK;
                }
                for (i = 1; i < 9; i++) {
                    if (getStone(x - i, y - i) != stone) break;
                }
                if (i >= 5) {
                    if ((stone.equals(Stones.WHITE)) || stone.equals(Stones.BLACK) && (i > 5 || fouls(getStone(x - i, y - i))))
                        return Stones.WHITE;
                    else return Stones.BLACK;
                }
                for (i = 1; i < 9; i++) {
                    if (getStone(x + i, y - i) != stone) break;
                }
                if (i >= 5) {
                    if ((stone.equals(Stones.WHITE)) || stone.equals(Stones.BLACK) && (i > 5 || fouls(getStone(x + i, y - i))))
                        return Stones.WHITE;
                    else return Stones.BLACK;
                }
                for (i = 1; i < 9; i++) {
                    if (getStone(x - i, y + i) != stone) break;
                }
                if (i >= 5) {
                    if ((stone.equals(Stones.WHITE)) || stone.equals(Stones.BLACK) && (i > 5 || fouls(getStone(x - i, y + i))))
                        return Stones.WHITE;
                    else return Stones.BLACK;
                }
            }
        }
        return null;
    }
}
