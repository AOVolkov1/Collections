import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void FirstNotregistered() {
        Player Dima = new Player(1, "Дима", 40);
        Player Vova = new Player(10, "Вова", 50);

        Game game = new Game();
        game.register(Vova);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Дима", "Вова"));
    }

    @Test
    void SecondNotregistered() {
        Player Dima = new Player(1, "Дима", 40);
        Player Vova = new Player(10, "Вова", 50);

        Game game = new Game();
        game.register(Dima);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Дима", "Вова"));
    }

    @Test
    void FirstPlayerWin() {
        Player Dima = new Player(1, "Дима", 70);
        Player Vova = new Player(10, "Вова", 50);
        Player Donuld = new Player(101, "Дональд", 60);


        Game game = new Game();
        game.register(Vova);
        game.register(Dima);
        game.register(Donuld);

        int actual = game.round("Дима", "Вова");
        int expected = 1;
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void SecondPlayerWin() {
        Player Donuld = new Player(1, "Дональд", 60);
        Player Vova = new Player(10, "Вова", 70);
        Player Dima = new Player(101, "Дима", 80);

        Game game = new Game();
        game.register(Vova);
        game.register(Donuld);
        game.register(Dima);

        int actual = game.round("Дональд", "Вова");
        int expected = 2;
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void Draw() {
        Player Kim = new Player(1, "Ким", 22);
        Player Vova = new Player(10, "Вова", 22);
        Player Dima = new Player(101, "Дима", 70);
        Player Donuld = new Player(11, "Дональд", 60);

        Game game = new Game();
        game.register(Vova);
        game.register(Kim);
        game.register(Donuld);
        game.register(Dima);


        int actual = game.round("Ким", "Вова");
        int expected = 0;
        Assertions.assertEquals(expected,actual);
    }
}