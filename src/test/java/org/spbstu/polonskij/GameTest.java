package org.spbstu.polonskij;

import org.junit.Test;
import org.spbstu.polonskij.core.GameBoard;
import org.spbstu.polonskij.core.GameCell;
import org.spbstu.polonskij.core.Stones;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GameTest {
    private GameBoard board = new GameBoard(15, 15);

    @Test
    public void testBlack(){
        Map<GameCell, Stones> stones = new HashMap<GameCell, Stones>();
        stones.put(new GameCell(0, 0), Stones.BLACK);
        stones.put(new GameCell(1, 0), Stones.WHITE);
        stones.put(new GameCell(0, 1), Stones.BLACK);
        stones.put(new GameCell(2, 0), Stones.WHITE);
        stones.put(new GameCell(0, 2), Stones.BLACK);
        stones.put(new GameCell(3, 0), Stones.WHITE);
        stones.put(new GameCell(0, 3), Stones.BLACK);
        stones.put(new GameCell(4, 0), Stones.WHITE);
        stones.put(new GameCell(0, 4), Stones.BLACK);
        assertEquals(Stones.BLACK, board.win(stones));
    }

    @Test
    public void testWhite(){
        Map<GameCell, Stones> stones = new HashMap<GameCell, Stones>();
        stones.put(new GameCell(0, 0), Stones.BLACK);
        stones.put(new GameCell(1, 0), Stones.WHITE);
        stones.put(new GameCell(0, 1), Stones.BLACK);
        stones.put(new GameCell(2, 0), Stones.WHITE);
        stones.put(new GameCell(0, 2), Stones.BLACK);
        stones.put(new GameCell(3, 0), Stones.WHITE);
        stones.put(new GameCell(0, 3), Stones.BLACK);
        stones.put(new GameCell(4, 0), Stones.WHITE);
        stones.put(new GameCell(1, 4), Stones.BLACK);
        stones.put(new GameCell(6, 0), Stones.WHITE);
        stones.put(new GameCell(2, 4), Stones.BLACK);
        stones.put(new GameCell(5, 0), Stones.WHITE);
        assertEquals(Stones.BLACK, board.win(stones));
    }

    @Test
    public void testFoul3x3(){
        Map<GameCell, Stones> stones = new HashMap<GameCell, Stones>();
        stones.put(new GameCell(0, 0), Stones.BLACK);
        stones.put(new GameCell(1, 0), Stones.WHITE);
        stones.put(new GameCell(0, 1), Stones.BLACK);
        stones.put(new GameCell(2, 0), Stones.WHITE);
        stones.put(new GameCell(0, 2), Stones.BLACK);
        stones.put(new GameCell(3, 0), Stones.WHITE);
        stones.put(new GameCell(0, 3), Stones.BLACK);
        stones.put(new GameCell(4, 0), Stones.WHITE);
        stones.put(new GameCell(1, 4), Stones.BLACK);
        stones.put(new GameCell(6, 0), Stones.WHITE);
        stones.put(new GameCell(2, 4), Stones.BLACK);
        stones.put(new GameCell(5, 0), Stones.WHITE);
        assertEquals(Stones.BLACK, board.win(stones));
    }

    @Test
    public void testFoul4x4(){
        Map<GameCell, Stones> stones = new HashMap<GameCell, Stones>();
        stones.put(new GameCell(0, 0), Stones.BLACK);
        stones.put(new GameCell(1, 0), Stones.WHITE);
        stones.put(new GameCell(0, 1), Stones.BLACK);
        stones.put(new GameCell(2, 0), Stones.WHITE);
        stones.put(new GameCell(0, 2), Stones.BLACK);
        stones.put(new GameCell(3, 0), Stones.WHITE);
        stones.put(new GameCell(0, 3), Stones.BLACK);
        stones.put(new GameCell(4, 0), Stones.WHITE);
        stones.put(new GameCell(1, 4), Stones.BLACK);
        stones.put(new GameCell(6, 0), Stones.WHITE);
        stones.put(new GameCell(2, 4), Stones.BLACK);
        stones.put(new GameCell(5, 0), Stones.WHITE);
        assertEquals(Stones.BLACK, board.win(stones));
    }
}
