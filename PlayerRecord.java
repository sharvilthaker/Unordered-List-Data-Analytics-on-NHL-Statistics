public class PlayerRecord {
    private String name;
    private int gamesPlayed;
    private int goals;
    private int assists;
    private int points;

    public PlayerRecord(String name, int gamesPlayed, int goals, int assists) {
        this.name = name;
        this.gamesPlayed = gamesPlayed;
        this.goals = goals;
        this.assists = assists;
        this.points = goals + assists; // Points calculation
    }

    public String getName() {
        return name;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return name + ": " + gamesPlayed + " GP, " + goals + " G, " + assists + " A, " + points + " P";
    }
}
