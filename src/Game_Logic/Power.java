package Game_Logic;

import UI.Cell;

import java.util.Random;

/**
 * Contains current location of the Power
 *
 * A Power generator generate randomly in the map
 */
public class Power {
    private static final char symbol = '$';
    private int current_row;
    private int current_column;
    private static boolean exist = true;

    public int getRow() {
        return current_row;
    }

    public void setRow(int row) {
        this.current_row = row;
    }

    public int getColumn() {
        return current_column;
    }

    public void setColumn(int column) {
        this.current_column = column;
    }

    public Power(Cell[][] maze) {
        Random x = new Random();
        Random y = new Random();
        int row;
        int column;
        while(true){
            row = x.nextInt(19) + 1;
            column = y.nextInt(13) + 1;
            if(maze[row][column].value != 1 && maze[row][column].character != '@'){
                this.current_row = row;
                this.current_column = column;
                break;
            }
        }
    }

    public void got_power(){
        exist = false;
    }

}
