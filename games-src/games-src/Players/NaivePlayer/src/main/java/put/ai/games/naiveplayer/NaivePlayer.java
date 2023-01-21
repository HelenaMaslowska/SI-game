/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package put.ai.games.naiveplayer;

import java.util.List;
import java.util.Random;
import put.ai.games.game.Board;
import put.ai.games.game.Move;
import put.ai.games.game.Player;

public class NaivePlayer extends Player {

    private Random random = new Random(0xdeadbeef);


    @Override
    public String getName() {
        return "Helena Masłowska 148182 Jan Kiwlenko 148152";
    }


    @Override
    public Move nextMove(Board b) {
        List<Move> moves = b.getMovesFor(getColor());
        return moves.get(random.nextInt(moves.size()));
    }
    public void alpha_beta(Board b)
    {
        if (b.getMovesFor(getColor()))
        {

        }
    }
    /*
    funkcja alfabeta(węzeł, głębokość, α, β)
    jeżeli węzeł jest końcowy lub głębokość = 0
        zwróć wartość heurystyczną węzła
    jeżeli przeciwnik ma zagrać w węźle
        dla każdego potomka węzła
            β := min(β, alfabeta(potomek, głębokość-1, α, β))
            jeżeli α≥β
                przerwij przeszukiwanie  {odcinamy gałąź Alfa}
        zwróć β
    w przeciwnym przypadku {my mamy zagrać w węźle}
        dla każdego potomka węzła
            α := max(α, alfabeta(potomek, głębokość-1, α, β))
            jeżeli α≥β
                przerwij przeszukiwanie  {odcinamy gałąź Beta}
        zwróć α
     */
}
