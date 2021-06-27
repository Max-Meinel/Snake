import java.util.ArrayList;

public class Players {
    public static ArrayList<Player> players = new ArrayList<>();

    public static Player getPlayer(int i) {
        return players.get(i);
    }

    public static void removeAllPlayers() {
        players.clear();
    }

    public static void addPlayer(Player player) {
        players.add(player);
    }
}
