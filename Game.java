
import java.util.ArrayList;

public class Game {
    int[][] twoD_arr = new int[8][8];

    public Game() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                twoD_arr[i][j] = 0;
        }
        twoD_arr[3][3] = -1;
        twoD_arr[4][4] = -1;
        twoD_arr[3][4] = 1;
        twoD_arr[4][3] = 1;

    }

    public void printMap() {
        ArrayList<String> sample = new ArrayList<String>();
        sample.add(0, "_____ ");
        sample.add(1, "_____|");
        sample.add(2, "  b  |");
        sample.add(3, "  w  |");
        sample.add(4, "     |");

        int n = -1;

        for (int j = 0; j < 8; j++) {
            if (j == 0)
                System.out.print(" " + sample.get(0));
            else
                System.out.print(sample.get(0));
        }
        System.out.print("\n");

        for (int i = 1; i < 25; i++) {
            if (i % 3 == 2)
                n++;

            for (int j = 0; j < 8; j++) {
                if (j == 0) {
                    System.out.print("|");
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
}