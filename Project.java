import java.util.Scanner;

/**
 * Project class represent an othelo game
 * 
 * @author sevda imany
 * @version 0.0
 */
public class Project {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    
    
    public static void main(String[] args) {
        Game game = new Game();
        GameMap map = new GameMap();

        Scanner sc = new Scanner(System.in);
        map.menu();
        int choose = sc.nextInt();
        clearScreen();

        Player player = new Player();
        player.setPlayer(1);
        Player player2 = null;

        if (choose == 1) {
            player2 = new Player();
            player2.setPlayer(-1);
        }

        else if (choose == 2) {
            player2 = new Ai();
            player2.setPlayer(-1);
        }

        clearScreen();
        map.printMap(game.getTwoD_arr());
        int checkEndOfGame = 0;

        while (true) {
            if (game.pass(player.getPlayer())) {
                checkEndOfGame = 0;
                game.print();
                boolean check = map.select(player, game);
                if (check) {
                    if (game.pass(player2.getPlayer())) {
                        checkEndOfGame = 0;

                        clearScreen();
                        map.printMap(game.getTwoD_arr());
                        game.print();

                        boolean check2 = map.select(player2, game);
                        clearScreen();
                        map.printMap(game.getTwoD_arr());
                        while (!check2) {
                            checkEndOfGame = 0;

                            clearScreen();
                            map.printMap(game.getTwoD_arr());
                            System.out.println("Wrong input!\n");

                            game.print();

                            check2 = map.select(player2, game);
                            clearScreen();
                            map.printMap(game.getTwoD_arr());
                        }

                    } else {
                        checkEndOfGame++;

                        if (checkEndOfGame == 2) {
                            clearScreen();
                            map.printMap(game.getTwoD_arr());
                            game.print();
                            game.endGame();
                            return;
                        }
                        clearScreen();
                        map.printMap(game.getTwoD_arr());
                        System.out.println("Pass.");
                    }

                } else if (!check) {
                    clearScreen();
                    map.printMap(game.getTwoD_arr());
                    System.out.println("Wrong input!\n");
                }
            } else {
                checkEndOfGame++;

                if (checkEndOfGame == 2) {
                    clearScreen();
                    map.printMap(game.getTwoD_arr());
                    game.print();
                    game.endGame();
                    return;
                }
                clearScreen();
                map.printMap(game.getTwoD_arr());
                System.out.println("Pass.");
            }
        }
    }

}
