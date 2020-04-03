/**
 * Point class represent a coordinate in map it holds map x and y
 * 
 * @author sevda imany
 * @version 0.0
 */
public class Point {
    private final int x;
    private final int y;

    /**
     * creat a new point with given x and y
     * 
     * @param x
     * @param y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * get blocks x
     * 
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * get blocks y
     * @return int
     */
    public int getY() {
        return y;
    }

}