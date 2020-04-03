
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Ai class represent a Artificial intelligence in game
 * @author sevda imany
 * @version 0.0
 */
public class Ai extends Player {
  
    
    /** 
     * this method count how many black member can be replace with white in every possible block to put white
     * @param game
     * @return  a HashMap with point as a key and the number of replaced black member as value
     */
    public HashMap count(Game game) {
        int[][] twoD_arr = game.getTwoD_arr();
        GameMap map = new GameMap();
        int blocks = 0;
        int numBlack = 0;
        HashMap<Point, Integer> ways = new HashMap<Point, Integer>();
        for (int c = 0; c < 8; c++) {
            for (int l = 0; l < 8; l++) {
                numBlack = 0;
                if (twoD_arr[c][l] == 0) {
                   
                    int check = 0;
                    for (int i = -1; i < 2; i++) {
                        for (int k = -1; k < 2; k++) {
                            blocks = 0;
                            // check than can move in THIS way
                            Point point = new Point(c + i, l + k);

                            if (map.check(point)) {

                                if (twoD_arr[c + i][l + k] == 1) {
                                    blocks++;
                                    int x = c + i + i;
                                    int y = l + k + k;
                                    while (true) {
                                        Point point1 = new Point(x, y);

                                        if (map.check(point1)) {
                                            if (twoD_arr[x][y] == -1) {
                                                numBlack += blocks;
                                                check = 1;
                                                break;
                                            } else if (twoD_arr[x][y] == 0) {
                                                break;
                                            }
                                            x += i;
                                            y += k;
                                            blocks++;
                                        } else
                                            break;
                                    }

                                }
                            }

                        }
                    }
                    if(check == 1){ 
                    Point point2 = new Point(c, l);
                    ways.put(point2,numBlack);
                    }
                }

            }
        }
        return ways;
    }

    
    /** 
     * this method choose a coordinate which replace max number of black
     * @param game
     * @return coordinate of a block
     */
    public Point choose2(Game game) {
        Point point = new Point(-1, -1);
        HashMap<Point, Integer> ways = count(game);
        int maxWay = Collections.max(ways.values());
        for (Map.Entry<Point, Integer> entry : ways.entrySet()) {
            if (entry.getValue() == maxWay)
                return entry.getKey();
        }
        return point;

    }

}
