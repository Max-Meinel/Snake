import java.util.ArrayList;

public class Players {
    public ArrayList<Player> players;

    public Players() {
        this.players = new ArrayList<>();
    }

    public Player getPlayer(int i) {
        return players.get(i);
    }

    public void removeAllPlayers() {
        players.clear();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }
}
