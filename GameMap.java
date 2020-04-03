import java.util.ArrayList;

/**
 * GameMap class represent a map in game
 * @author sevda imany
 * @version 0.0
 */
public class GameMap{

    
    /** 
     * this method print a map 
     * @param twoD_arr
     */
    public void printMap(int[][] twoD_arr) {
        ArrayList<String> sample = new ArrayList<String>();
        sample.add(0, "_____ ");
        sample.add(1, "_____|");
        sample.add(2, "  b  |");
        sample.add(3, "  w  |");
        sample.add(4, "     |");

        int n = -1;

        System.out.println("\t\t\t\t\t\t\t\t\t\t     A     B     C     D     E     F     G     H");

        for (int j = 0; j < 8; j++) {
            if (j == 0)
                System.out.print("\t\t\t\t\t\t\t\t\t\t   " + sample.get(0));
            else
                System.out.print(sample.get(0));
        }
        System.out.print("\n");

        for (int i = 1; i < 25; i++) {
            if (i % 3 == 2)
                n++;

            for (int j = 0; j < 8; j++) {

                if (j == 0) {
                    if (i % 3 == 2)
                        System.out.print("\t\t\t\t\t\t\t\t\t\t" + (n + 1) + " |");
                    else
                        System.out.print("\t\t\t\t\t\t\t\t\t\t" + "  |");

                }

                if (i % 3 == 1) {
                    System.out.print(sample.get(4));
                } else if (i % 3 == 0) {
                    System.out.print(sample.get(1));
                } else if (i % 3 == 2) {
                    if (twoD_arr[n][j] == 0) {
                        System.out.print(sample.get(4));
                    } else if (twoD_arr[n][j] == 1) {
                        System.out.print(sample.get(2));
                    } else if (twoD_arr[n][j] == -1) {
                        System.out.print(sample.get(3));
                    }
                }

            }
            System.out.print("\n");
        }

    }
    
    
    /** 
     * @param player
     * @param game
     * @return boolean
     */
    public boolean select(Object player, Game game) {
         if(player instanceof Ai){
            Ai newAi = (Ai)player;
            Point point = newAi.choose2(game);
            if(check(point, newAi, game))
            return true;
        }
        else if(player instanceof Player){ 
            Player newPlayer = (Player)player;
        Point point = newPlayer.choose();
       if(check(point) && check(point,newPlayer, game))
       return true;
       else{ 
       return false;
       }
    }
    return true;
    }
    

    
    /** 
     * this method check if the given point is in the map or not
     * @param point
     * @return {@code true} if the point is in map otherwise {@code false}
     */
    public boolean check(Point point) {
        if (point.getX() >= 0 && point.getX() < 8 && point.getY() >= 0 && point.getY() < 8)
            return true;
        else
            return false;
    }

    
    /** 
     * this method check if can play with given point or not
     * @param point
     * @param player
     * @param game
     * @return {@code tr}
     */
    private boolean check(Point point, Player player, Game game) {
        return game.game(point.getX(), point.getY(), player.getPlayer());

    }
    
    public void menu(){
        System.out.println("1)Play with friend\n2)Play online");
    }

   
}