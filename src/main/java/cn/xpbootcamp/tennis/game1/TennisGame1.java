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
            return getScoreWhenEqual(m_score1);
        if (m_score1 >= 4 || m_score2 >= 4)
            return getScoreWhenBothGreaterThanOrEqual4();
        return getScoreForBothLessThan4();
    }

    private String getScoreForBothLessThan4() {
        StringBuilder score = new StringBuilder();
        score.append(buildScore(m_score1));
        score.append("-");
        score.append(buildScore(m_score2));
        return score.toString();
    }

    private String buildScore(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    private String getScoreWhenBothGreaterThanOrEqual4() {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1)
            return buildAdvantage(player1Name);
        if (minusResult == -1)
            return buildAdvantage(player2Name);
        if (minusResult >= 2)
            return buildWinFor(player1Name);
        return buildWinFor(player2Name);
    }

    private String buildAdvantage(String playerName) {
        return "Advantage " + playerName;
    }

    private String buildWinFor(String playerName) {
        return "Win for " + playerName;
    }

    private String getScoreWhenEqual(int score) {
        switch (score) {
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
