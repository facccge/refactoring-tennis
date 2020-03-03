package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1 == m_score2)
            return buildScoreWhenEqual();
        if (m_score1 >= 4 || m_score2 >= 4)
            return buildScoreWhenBothGreaterThan4();
        return buildScoreForNormalCase();
    }

    private String buildScoreForNormalCase() {
        StringBuilder score = new StringBuilder();
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = m_score1;
            else {
                score.append("-");
                tempScore = m_score2;
            }
            switch (tempScore) {
                case 0:
                    score.append("Love");
                    break;
                case 1:
                    score.append("Fifteen");
                    break;
                case 2:
                    score.append("Thirty");
                    break;
                case 3:
                    score.append("Forty");
                    break;
            }
        }
        return score.toString();
    }

    private String buildScoreWhenBothGreaterThan4() {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1)
            return "Advantage " + player1Name;
        if (minusResult == -1)
            return "Advantage " + player2Name;
        if (minusResult >= 2)
            return "Win for " + player1Name;
        return "Win for " + player2Name;
    }

    private String buildScoreWhenEqual() {
        switch (m_score1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }
}
