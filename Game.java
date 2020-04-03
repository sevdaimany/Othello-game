
public class Game {
    int[][] twoD_arr;

    public Game() {
        twoD_arr = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                twoD_arr[i][j] = 0;
        }
        twoD_arr[3][3] = -1;
        twoD_arr[4][4] = -1;
        twoD_arr[3][4] = 1;
        twoD_arr[4][3] = 1;

    }

    public int[][] getTwoD_arr() {
        return twoD_arr;
    }

    // turn 1 for black and -1 for white
    public boolean game(int c, int l, int turn) {
        GameMap map = new GameMap();
        if (twoD_arr[c][l] == 0) {
            int otherPlayer;
            if (turn == 1)
                otherPlayer = -1;
            else
                otherPlayer = 1;
            // check that can move ore not
            int check = 0;

            for (int i = -1; i < 2; i++) {
                for (int k = -1; k < 2; k++) {
                    // check than can move in THIS way
                    int check2 = 0;
                    Point point = new Point(c + i, l + k);
                    if (map.check(point)) {

                        if (twoD_arr[c + i][l + k] == otherPlayer) {
                            int currentOtherPlayerX = c + i;
                            int currentOtherPlayerY = l + k;
                            int x = currentOtherPlayerX + i;
                            int y = currentOtherPlayerY + k;
                            while (true) {
                                Point point1 = new Point(x, y);
                                if (map.check(point1)) {
                                    if (twoD_arr[x][y] == turn) {
                                        check = 1;
                                        check2 = 1;
                                        break;
                                    } else if (twoD_arr[x][y] == 0) {
                                        break;
                                    }
                                    x += i;
                                    y += k;
                                } else
                                    break;
                            }
                            if (check2 == 1) {
                                twoD_arr[c][l] = turn;
                                while (twoD_arr[currentOtherPlayerX][currentOtherPlayerY] != turn) {
                                    twoD_arr[currentOtherPlayerX][currentOtherPlayerY] = turn;
                                    currentOtherPlayerX += i;
                                    currentOtherPlayerY += k;
                                }
                            }

                        }
                    }

                }
            }
            if (check == 0) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean pass(int player) {
        GameMap map = new GameMap();
        int other;
        int check = 0;
        if (player == 1)
            other = -1;
        else
            other = 1;

        for (int c = 0; c < 8; c++) {
            for (int l = 0; l < 8; l++) {

                if (twoD_arr[c][l] == 0) {

                    check = 0;
                    for (int i = -1; i < 2; i++) {
                        for (int k = -1; k < 2; k++) {
                            // check than can move in THIS way
                            Point point = new Point(c + i, l + k);

                            if (map.check(point)) {

                                if (twoD_arr[c + i][l + k] == other) {
                                    int x = c + i + i;
                                    int y = l + k + k;
                                    while (true) {
                                        Point point1 = new Point(x, y);

                                        if (map.check(point1)) {
                                            if (twoD_arr[x][y] == player) {
                                                check = 1;
                                                return true;
                                            } else if (twoD_arr[x][y] == 0) {
                                                break;
                                            }
                                            x += i;
                                            y += k;
                                        } else
                                            break;
                                    }

                                }
                            }

                        }
                    }

                }

            }
        }
        if (check == 0) {
            return false;
        }
        return true;
    }

    public int num(int number) {
        int num = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (twoD_arr[i][j] == number)
                    num++;
            }
        }
        return num;
    }

    public void endGame() {
        if (num(1) > num(-1))
            System.out.println("Black won!");
        else if (num(1) < num(-1))
            System.out.println("White won!");
        else
            System.out.println("Equal!");

    }

    public void print() {
        int numBlack = num(1);
        int numWhite = num(-1);
        System.out.println("Black score: " + numBlack);
        System.out.println("White score: " + numWhite + "\n");
    }


    
}