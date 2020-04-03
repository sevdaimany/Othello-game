import java.util.Scanner;
/**
 * Player class represent a player in game
 * @author sevda imany
 * @version 0.0
 */
public class Player {
    //1 for black and -1 for white
    private int player;

    
    /** 
     * get player
     * @return 1 for black and -1 for white
     */
    public int getPlayer() {
        return player;
    }

    
    /** 
     * set player
     * @param player
     */
    public void setPlayer(int player) {
        this.player = player;
    }

    
    /** 
     * this method ask user to choose a block in table
     * @return coordinate of a block
     */
    public Point choose() {
        if (player == 1)
            System.out.println("Black turn:");
        else
            System.out.println("White turn:");

        Scanner sc = new Scanner(System.in);

        int l;
        int c = sc.nextInt();
        String ch = sc.nextLine();

        switch (ch) {
            case " A":
                l = 0;
                break;
            case " B":
                l = 1;
                break;
            case " C":
                l = 2;
                break;
            case " D":
                l = 3;
                break;
            case " E":
                l = 4;
                break;
            case " F":
                l = 5;
                break;
            case " G":
                l = 6;
                break;
            case " H":
                l = 7;
                break;
            default:
                l = -1;

        }
        Point point = new Point(c - 1, l);

        return point;
    }
}