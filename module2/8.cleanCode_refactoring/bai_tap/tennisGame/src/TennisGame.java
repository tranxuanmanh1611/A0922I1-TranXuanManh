public class TennisGame {

    private static boolean scoreIsDraw;
    private static boolean scoreIsFrom4;

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String score = "";
        scoreIsDraw = player1Score == player2Score;
        if (scoreIsDraw) {
            score = getDrawResult(player1Score);
        } else {
            scoreIsFrom4 = player1Score >= 4 || player2Score >= 4;
            if (scoreIsFrom4) {
                score = getAdvantageResult(player1Score, player2Score);
            } else {
                score = getScoreBelow4(player1Score, player2Score);
            }
        }
        return score;
    }

    public static String getDrawResult(int player1Score) {
        String score;
        switch (player1Score) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    public static String getAdvantageResult(int player1Score, int player2Score) {
        String score;
        int minusScore = player1Score - player2Score;
        if (minusScore == 1) {
            score = "Advantage player1";
        } else if (minusScore == -1) {
            score = "Advantage player2";
        } else if (minusScore >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }

    public static String getScoreBelow4(int player1Score, int player2Score) {
        String score = "";
        for (int i = 1; i < 3; i++) {
            int tempScore = 0;
            if (i == 1) {
                tempScore = player1Score;
            } else {
                score += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }
}
