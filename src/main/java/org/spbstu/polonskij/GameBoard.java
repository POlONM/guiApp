package org.spbstu.polonskij;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.HashMap;
import java.util.Map;

public class GameBoard {
    public static class Board {

        static public final int WIN = 5;

        private final int width;

        private final int height;

        private final Map<GameCell, Stones> stones = new HashMap<GameCell, Stones>();

        private Stones round = Stones.BLACK;

        public Board(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Nullable
        public Stones get(int x, int y) {
            return get(new GameCell(x, y));
        }

        @Nullable
        public Stones get(GameCell cell) {
            return stones.get(cell);
        }

        public GameCell makeTurn(int x) {
            if (x < 0 || x >= width) return null;
            for (int y = 0; y < height; y++) {
                GameCell cell = new GameCell(x, y);
                if (!stones.containsKey(cell)) {
                    stones.put(cell, round);
                    round = round.side();
                    return cell;
                }
            }
            return null;
        }

        public boolean foul() {
            if (round.equals(Stones.BLACK)) {
                for (int x = 0; x < width; x++) {
                    for (int y = 0; y < height; y++) {
                        GameCell cell = new GameCell(x, y);
                        Stones stone = stones.get(cell);
                        if (get(x, y) == stone) {
                            if ((((get(x + 1, y).equals(Stones.BLACK)) && (get(x + 2, y).equals(Stones.BLACK)))
                                    && (((get(x - 1, y).equals(Stones.BLACK)) && (get(x - 2, y).equals(Stones.BLACK)))
                                    || ((get(x, y + 1).equals(Stones.BLACK)) && (get(x, y + 2).equals(Stones.BLACK)))
                                    || ((get(x, y - 1).equals(Stones.BLACK)) && (get(x, y - 2).equals(Stones.BLACK))))))
                                return true;
                            if ((((get(x, y + 1).equals(Stones.BLACK)) && (get(x, y + 2).equals(Stones.BLACK)))
                                    && (((get(x - 1, y).equals(Stones.BLACK)) && (get(x - 2, y).equals(Stones.BLACK)))
                                    || ((get(x, y - 1).equals(Stones.BLACK)) && (get(x, y - 2).equals(Stones.BLACK)))
                            ))) return true;
                            if ((((get(x - 1, y).equals(Stones.BLACK)) && (get(x - 2, y).equals(Stones.BLACK)))
                                    && (((get(x, y - 1).equals(Stones.BLACK)) && (get(x, y - 2).equals(Stones.BLACK)))
                            ))) return true;
                        }
                    }
                }
            }
            return false;
        }

        public boolean hasFreeCells() {
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    if (get(x, y) == null) return true;
                }
            }
            return false;
        }

        @Nullable
        public Stones win() {
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    GameCell cell = new GameCell(x, y);
                    Stones stone = stones.get(cell);
                    if (stone == null) continue;
                    int i;
                    for (i = 1; i < WIN; i++) {
                        if (get(x + i, y) != stone) break;
                    }
                    if (i == WIN) {
                        if (round.equals(Stones.BLACK) && i == 6) return Stones.WHITE;
                    } else return stone;
                    for (i = 1; i < WIN; i++) {
                        if (get(x, y + i) != stone) break;
                    }
                    if (i == WIN) {
                        if (round.equals(Stones.BLACK) && i == 6) return Stones.WHITE;
                    } else return stone;
                    for (i = 1; i < WIN; i++) {
                        if (get(x + i, y + i) != stone) break;
                    }
                    if (i == WIN) {
                        if (round.equals(Stones.BLACK) && i == 6) return Stones.WHITE;
                    } else return stone;
                    for (i = 1; i < WIN; i++) {
                        if (get(x + i, y - i) != stone) break;
                    }
                    if (i == WIN) {
                        if (round.equals(Stones.BLACK) && i == 6) return Stones.WHITE;
                    } else return stone;
                }
            }
            return null;
        }
    }
}
