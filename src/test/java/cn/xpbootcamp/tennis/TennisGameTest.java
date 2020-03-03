package cn.xpbootcamp.tennis;


import cn.xpbootcamp.tennis.game1.TennisGame1;
import cn.xpbootcamp.tennis.game2.TennisGame2;
import cn.xpbootcamp.tennis.game3.TennisGame3;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

class TennisGameTest {
    private int player1Score;
    private int player2Score;
    private String expectedScore;

    public static Stream<List> getAllScores() {
        return Stream.of(
                Arrays.asList(0, 0, "Love-All"),
                Arrays.asList(1, 1, "Fifteen-All"),
                Arrays.asList(2, 2, "Thirty-All"),
                Arrays.asList(3, 3, "Deuce"),
                Arrays.asList(4, 4, "Deuce"),

                Arrays.asList(1, 0, "Fifteen-Love"),
                Arrays.asList(0, 1, "Love-Fifteen"),
                Arrays.asList(2, 0, "Thirty-Love"),
                Arrays.asList(0, 2, "Love-Thirty"),
                Arrays.asList(3, 0, "Forty-Love"),
                Arrays.asList(0, 3, "Love-Forty"),
                Arrays.asList(4, 0, "Win for player1"),
                Arrays.asList(0, 4, "Win for player2"),

                Arrays.asList(2, 1, "Thirty-Fifteen"),
                Arrays.asList(1, 2, "Fifteen-Thirty"),
                Arrays.asList(3, 1, "Forty-Fifteen"),
                Arrays.asList(1, 3, "Fifteen-Forty"),
                Arrays.asList(4, 1, "Win for player1"),
                Arrays.asList(1, 4, "Win for player2"),

                Arrays.asList(3, 2, "Forty-Thirty"),
                Arrays.asList(2, 3, "Thirty-Forty"),
                Arrays.asList(4, 2, "Win for player1"),
                Arrays.asList(2, 4, "Win for player2"),

                Arrays.asList(4, 3, "Advantage player1"),
                Arrays.asList(3, 4, "Advantage player2"),
                Arrays.asList(5, 4, "Advantage player1"),
                Arrays.asList(4, 5, "Advantage player2"),
                Arrays.asList(15, 14, "Advantage player1"),
                Arrays.asList(14, 15, "Advantage player2"),

                Arrays.asList(6, 4, "Win for player1"),
                Arrays.asList(4, 6, "Win for player2"),
                Arrays.asList(16, 14, "Win for player1"),
                Arrays.asList(14, 16, "Win for player2"));
    }

    @ParameterizedTest
    @MethodSource("getAllScores")
    public void checkAllScoresTennisGame1(List<Object> params) {
        TennisGame1 game = new TennisGame1("player1", "player2");
        checkAllScores(params, game);
    }

    @ParameterizedTest
    @MethodSource("getAllScores")
    public void checkAllScoresTennisGame2(List<Object> params) {
        TennisGame2 game = new TennisGame2("player1", "player2");
        checkAllScores(params, game);
    }

    @ParameterizedTest
    @MethodSource("getAllScores")
    public void checkAllScoresTennisGame3(List<Object> params) {
        TennisGame3 game = new TennisGame3("player1", "player2");
        checkAllScores(params, game);
    }

    public void checkAllScores(List<Object> params, TennisGame game) {
        player1Score = (int) params.get(0);
        player2Score = (int) params.get(1);
        expectedScore = (String) params.get(2);

        int highestScore = Math.max(this.player1Score, this.player2Score);
        for (int i = 0; i < highestScore; i++) {
            if (i < this.player1Score)
                game.wonPoint("player1");
            if (i < this.player2Score)
                game.wonPoint("player2");
        }
        assertEquals(this.expectedScore, game.getScore());
    }

}
