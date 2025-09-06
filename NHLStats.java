import java.io.*;
import java.util.LinkedList;

public class NHLStats {
    private LinkedList<PlayerRecord> playerRecords;

    public NHLStats() {
        playerRecords = new LinkedList<>();
    }

    public void addPlayerRecord(PlayerRecord record) {
        playerRecords.add(record);
    }

    public boolean isEmpty() {
        return playerRecords.isEmpty();
    }

    public void displayPlayerRecords() {
        for (PlayerRecord record : playerRecords) {
            System.out.println(record);
        }
    }

    // Load NHL stats from a file
    public void loadFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");  // Assuming CSV format: name,gamesPlayed,goals,assists
            if (parts.length == 4) {
                String name = parts[0].trim();
                int gamesPlayed = Integer.parseInt(parts[1].trim());
                int goals = Integer.parseInt(parts[2].trim());
                int assists = Integer.parseInt(parts[3].trim());
                PlayerRecord record = new PlayerRecord(name, gamesPlayed, goals, assists);
                addPlayerRecord(record);
            }
        }
        reader.close();
    }

    // Display all players
    public void displayAllPlayers() {
        for (PlayerRecord record : playerRecords) {
            System.out.println(record);
        }
    }

    // Display the top scorer
    public void displayTopScorer() {
        if (playerRecords.isEmpty()) {
            System.out.println("No players available.");
            return;
        }
        PlayerRecord topScorer = playerRecords.get(0);
        for (PlayerRecord record : playerRecords) {
            if (record.getGoals() > topScorer.getGoals()) {
                topScorer = record;
            }
        }
        System.out.println("Top Scorer: " + topScorer);
    }

    // Display a player by name
    public void displayPlayer(String name) {
        PlayerRecord record = searchByName(name);
        if (record != null) {
            System.out.println(record);
        } else {
            System.out.println("Player not found.");
        }
    }

    public PlayerRecord searchByName(String name) {
        for (PlayerRecord record : playerRecords) {
            if (record.getName().equalsIgnoreCase(name)) {
                return record;
            }
        }
        return null;
    }
}
