import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game game;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    @BeforeEach
    public void setUp() {
        game = new Game();
        player1 = new Player(1, "Anya", 10);
        player2 = new Player(2, "Vasya", 8);
        player3 = new Player(3, "Petya", 9);
        player4 = new Player(4, "Sveta", 10);
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
    }

    @Test
    public void testRegister() {
        Player newPlayer = new Player(5, "Emily", 6);
        game.register(newPlayer);
        Player foundPlayer = game.findByName("Emily");
        Assertions.assertEquals(newPlayer, foundPlayer);
    }

    @Test
    public void testRound_player1Wins() throws NotRegisteredException {
        int result = game.round("Anya", "Vasya");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testRound_player2Wins() throws NotRegisteredException {
        int result = game.round("Vasya", "Anya");
        Assertions.assertEquals(2, result);
    }

    @Test
    public void testRound_tie() throws NotRegisteredException {
        int result = game.round("Anya", "Sveta");
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testRound_playerNotRegistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Anya", "Eva");
        });
    }

    @Test
    public void testRound_allPlayerNotRegistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Kolya", "Eva");
        });
    }
}