import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> registeredPlayers = new ArrayList<>();

    public void register(Player player) {
        registeredPlayers.add(player);
    }

    Player findByName(String playerName) {
        for (Player player : registeredPlayers) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1 == null || player2 == null) {
            throw new NotRegisteredException("One or more players not registered");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player2.getStrength() > player1.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}