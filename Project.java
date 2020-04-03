import java.util.Scanner;

public class Project {
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void alternate(Player player){
        if(player.getPlayer()== 1 )
        player.setPlayer(-1);
        else
        player.setPlayer(1);
    }
 
    

    public static void main(String[] args) {
        Game game = new Game();
        GameMap map = new GameMap();
      
        Player player = new Player();
        player.setPlayer(1);

        
        clearScreen();
        map.printMap(game.getTwoD_arr());
        int checkEndOfGame = 0;
    
        while (true) {
            if (game.pass(player.getPlayer())) {
                checkEndOfGame = 0;
            
                game.print();
               boolean check =  map.select(player, game);
                if(check){
                    alternate(player);
                }
              
                clearScreen();
                map.printMap(game.getTwoD_arr());
                if(!check)
                System.out.println("Wrong input!\n");
               
           
            } else {
                checkEndOfGame++;
               
               alternate(player);

                if (checkEndOfGame == 2){ 
                    game.print();
                    game.endGame();
                    return;
                }
                    System.out.println("Pass.");
            }

        }
    }
    
    }
    
    
