package Game_Logic;
import UI.Cell;
import UI.Maze;

import java.util.Scanner;

/**
 * Including player current position
 * A move function required a maze as a argument
 */
public class Player {
    private static final String symbol = "@";
    private static int current_row = 1;
    private static int current_column = 1;

    public Player() {
        this.setCurrent_row(1);
        this.setCurrent_column(1);
    }

    public String getSymbol() {
        return symbol;
    }

    public int getCurrent_row() {
        return current_row;
    }

    public void setCurrent_row(int current_row) {
        this.current_row = current_row;
    }

    public int getCurrent_column() {
        return current_column;
    }

    public void setCurrent_column(int current_column) {
        this.current_column = current_column;
    }

    public void move(Cell[][] maze){
        Scanner console = new Scanner(System.in);
        char direction;
        direction = console.next().charAt(0);

        if(direction == 'w'){
            if(maze[this.getCurrent_row() - 1][this.getCurrent_column()].value == 1){
                System.out.println("invalid move: you cannot move through walls!");
                return;
            }
            this.setCurrent_row(this.getCurrent_row() - 1);
            System.out.println("Moved Up");
            return;
        }
        if(direction == 'a'){
            if(maze[this.getCurrent_row()][this.getCurrent_column() - 1].value == 1){
                System.out.println("invalid move: you cannot move through walls!");
                return;
            }
            this.setCurrent_column(this.getCurrent_column() - 1);
            System.out.println("Moved Left");
            return;
        }
        if(direction == 's'){
            if(maze[this.getCurrent_row() + 1][this.getCurrent_column()].value == 1){
                System.out.println("invalid move: you cannot move through walls!");
                return;
            }
            this.setCurrent_row(this.getCurrent_row() + 1);
            System.out.println("Moved Down");
            return;
        }
        if(direction == 'd'){
            if(maze[this.getCurrent_row()][this.getCurrent_column() + 1].value == 1){
                System.out.println("invalid move: you cannot move through walls!");
                return;
            }
            this.setCurrent_column(this.getCurrent_column() + 1);
            System.out.println("Moved Right");
            return;
        }
    }
}
