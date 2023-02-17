/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package put.ai.games.naiveplayer;

import put.ai.games.game.Board;
import put.ai.games.game.Move;
import put.ai.games.game.Player;
//import put.ai.games.game.moves.impl.MoveMoveImpl;

import java.util.Collections;
import java.util.List;
import java.util.Random;
public class NaivePlayer extends Player {

    private Random random = new Random(0xdeadbeef);


    @Override
    public String getName() {
        return "Helena Masłowska 148182 Jan Kiwlenko 148152";
    }


    @Override
    public Move nextMove(Board b) {
        List<Move> moves = b.getMovesFor(getColor());
        //random.nextInt(moves.size())
        Color color = getColor();
//        for (Move move : moves) {
//            if (move instanceof MoveMoveImpl) {
//                MoveMoveImpl ruch = (MoveMoveImpl) move;
//
//            }
//        }
        //int max = Collections.max(moves);
        //int index = moves.indexOf(max);

        //MoveMoveImpl ruch;
        for (Move move : moves)
        {
            if (color == Color.PLAYER1)
            {
                return moves.get(moves.size()-1);
            }
        }
        return moves.get(moves.size()-1);
    }
//    private int alpha_beta(int[] piles, int begin, int end, int alpha, int beta, boolean maximizing)
//    {
//
//        if (begin > end) return 0;
//
//        if (maximizing) {
//            int val = Integer.MIN_VALUE;
//            val = Math.max(val, alpha_beta(piles, begin + 1, end, alpha, beta, false) + piles[begin]);
//            alpha = Math.max(alpha, val);
//            if (alpha >= beta) return val;
//
//            val = Math.max(val, alpha_beta(piles, begin, end - 1, alpha, beta, false) + piles[end]);
//            return val;
//        } else {
//            int val = Integer.MAX_VALUE;
//            val = Math.min(val, alpha_beta(piles, begin + 1, end, alpha, beta, true) - piles[begin]);
//            beta = Math.min(beta, val);
//            if (alpha >= beta) return val;
//
//            val = Math.min(val, alpha_beta(piles, begin, end - 1, alpha, beta, true) - piles[end]);
//            return val;
//        }
//    }
}
