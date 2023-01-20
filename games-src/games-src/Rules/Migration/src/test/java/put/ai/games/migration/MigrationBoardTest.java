/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package put.ai.games.migration;

import org.junit.Test;
import put.ai.games.game.Move;
import put.ai.games.game.Player.Color;
import put.ai.games.game.TypicalBoard;
import put.ai.games.game.moves.MoveMove;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static put.ai.games.BoardTestUtils.getState;

public class MigrationBoardTest {

    private Color[][] transpose(Color[][] input) {
        Color[][] result = new Color[input.length][input.length];
        for (int x = 0; x < input.length; ++x) {
            for (int y = 0; y < input.length; ++y) {
                result[x][y] = input[y][x];
            }
        }
        return result;
    }


    @Test
    public void constructorEven() {
        MigrationBoard b = new MigrationBoard(6);
        Color[][] state = getState(b);
        Color[][] expected = transpose(new Color[][]{
                new Color[]{Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY},
                new Color[]{Color.PLAYER1, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY},
                new Color[]{Color.PLAYER1, Color.PLAYER1, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY},
                new Color[]{Color.PLAYER1, Color.PLAYER1, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY},
                new Color[]{Color.PLAYER1, Color.EMPTY, Color.PLAYER2, Color.PLAYER2, Color.EMPTY, Color.EMPTY},
                new Color[]{Color.EMPTY, Color.PLAYER2, Color.PLAYER2, Color.PLAYER2, Color.PLAYER2, Color.EMPTY}});
        assertTrue(Arrays.deepEquals(expected, state));
    }


    @Test
    public void constructorOdd() {
        MigrationBoard b = new MigrationBoard(7);
        Color[][] state = getState(b);
        Color[][] expected = transpose(new Color[][]{
                new Color[]{Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY},
                new Color[]{Color.PLAYER1, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY,
                        Color.EMPTY},
                new Color[]{Color.PLAYER1, Color.PLAYER1, Color.EMPTY, Color.EMPTY, Color.EMPTY, Color.EMPTY,
                        Color.EMPTY},
                new Color[]{Color.PLAYER1, Color.PLAYER1, Color.PLAYER1, Color.EMPTY, Color.EMPTY, Color.EMPTY,
                        Color.EMPTY},
                new Color[]{Color.PLAYER1, Color.PLAYER1, Color.EMPTY, Color.PLAYER2, Color.EMPTY, Color.EMPTY,
                        Color.EMPTY},
                new Color[]{Color.PLAYER1, Color.EMPTY, Color.PLAYER2, Color.PLAYER2, Color.PLAYER2, Color.EMPTY,
                        Color.EMPTY},
                new Color[]{Color.EMPTY, Color.PLAYER2, Color.PLAYER2, Color.PLAYER2, Color.PLAYER2, Color.PLAYER2,
                        Color.EMPTY}});
        System.err.println(b);
        assertTrue(Arrays.deepEquals(expected, state));
    }


    @Test
    public void getMovesFor1() {
        MigrationBoard b = new MigrationBoard(6);
        List<Move> moves = b.getMovesFor(Color.PLAYER1);
        assertEquals(4, moves.size());
        for (Move m : moves) {
            assertTrue(m instanceof MoveMove);
            MoveMove mm = (MoveMove) m;
            assertEquals(Color.PLAYER1, b.getState(mm.getSrcX(), mm.getSrcY()));
            assertEquals(mm.getSrcY(), mm.getDstY());
            assertEquals(mm.getSrcX() + 1, mm.getDstX());
            assertEquals(Color.EMPTY, b.getState(mm.getDstX(), mm.getDstY()));
        }
    }


    @Test
    public void getMovesFor2() {
        MigrationBoard b = new MigrationBoard(6);
        List<Move> moves = b.getMovesFor(Color.PLAYER2);
        assertEquals(4, moves.size());
        for (Move m : moves) {
            assertTrue(m instanceof MoveMove);
            MoveMove mm = (MoveMove) m;
            assertEquals(Color.PLAYER2, b.getState(mm.getSrcX(), mm.getSrcY()));
            assertEquals(mm.getSrcY() - 1, mm.getDstY());
            assertEquals(mm.getSrcX(), mm.getDstX());
            assertEquals(Color.EMPTY, b.getState(mm.getDstX(), mm.getDstY()));
        }
    }

    @Test
    public void hasWinner() {
        MigrationBoard b = new MigrationBoard(4);
        assertNull(b.getWinner(Color.PLAYER1));
        b.doMove(new MigrationMove(0, 1, 1, 1, Color.PLAYER1));
        assertNull(b.getWinner(Color.PLAYER2));
        b.doMove(new MigrationMove(2, 3, 2, 2, Color.PLAYER2));
        assertNull(b.getWinner(Color.PLAYER1));
        b.doMove(new MigrationMove(0, 2, 1, 2, Color.PLAYER1));
        assertNull(b.getWinner(Color.PLAYER2));
        b.doMove(new MigrationMove(1, 1, 2, 1, Color.PLAYER1));
        assertEquals(Color.PLAYER1, b.getWinner(Color.PLAYER2));
    }
}
