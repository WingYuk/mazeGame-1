package Game_Logic;

import java.util.Random;

import UI.Cell;


/**
 * Contains monster current position and also
 * the previous position.
 *
 * The can_move function helps to check is there
 * any way the monster can go will out hitting a wall
 * or backtracked.
 *
 * The move function will random generate a
 * direction until the monster find a way to go.
 */
public class Monster{
    private static final String symbol = "!";
    private int current_row;
    private int current_column;
    private int pre_row;
    private int pre_column;

    public Monster(int row, int column) {
        this.current_row = row;
        this.current_column = column;
        this.pre_column = -1;
        this.pre_row = -1;
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

    public int getPre_row() {
        return pre_row;
    }

    public int getPre_column() {
        return pre_column;
    }

    public boolean can_move(Cell[][] maze){

        if(maze[this.current_row + 1][this.current_column].value != 1
                && !(this.current_column == this.pre_column && this.current_row + 1 == this.pre_row)){
            return true;
        } // able to move down
        if(maze[this.current_row][this.current_column + 1].value != 1
                && !(this.current_column + 1 == this.pre_column && this.current_row == this.pre_row)){
            return true;
        } // able to move right
        if(maze[this.current_row - 1][this.current_column].value != 1
                && !(this.current_column == this.pre_column && this.current_row - 1 == this.pre_row)){
            return true;
        } // able move up
        if(maze[this.current_row][this.current_column - 1].value != 1
                && !(this.current_column - 1 == this.pre_column && this.current_row == this.pre_row)){
            return true;
        } // able to move left

        return false;
        // unable to move
    }

    public void move(Cell[][] maze) {
        // Back track
        if(this.can_move(maze) == false){
            int temp_row = this.current_row;
            int temp_column = this.current_column;
            this.current_row = this.pre_row;
            this.current_column = this.pre_column;
            this.pre_column = temp_column;
            this.pre_row = temp_row;
            System.out.println("moved backward");
            return;
        }

        // Move until it finds a direction
        // 0 = up, 1 = left, 2 = down, 3 = right
        Random random = new Random();
        int direction;
        boolean moved = false;
        do {
            direction = random.nextInt(4);
            if (direction == 0) {
                System.out.println("UP");
                if (maze[this.current_row - 1][this.current_column].value == 1 ||
                        (this.current_column == this.pre_column && this.current_row - 1 == this.pre_row)) {
                    continue;
                }
                this.pre_row = this.current_row;
                this.pre_column = this.current_column;
                this.current_row--;
                System.out.println("moved up");
                moved = true;
            }
            else if(direction == 1){
                System.out.println("Left");
                if (maze[this.current_row][this.current_column - 1].value == 1 ||
                        (this.current_column - 1 == this.pre_column && this.current_row == this.pre_row)) {
                    continue;
                }
                this.pre_row = this.current_row;
                this.pre_column = this.current_column;
                this.current_column--;
                System.out.println("moved left");
                moved = true;
            }
            else if(direction == 2){
                System.out.println("Down");
                if (maze[this.current_row + 1][this.current_column].value == 1 ||
                        (this.current_column == this.pre_column && this.current_row + 1 == this.pre_row)) {
                    continue;
                }
                this.pre_row = this.current_row;
                this.pre_column = this.current_column;
                this.current_row++;
                System.out.println("moved down");
                moved = true;
            }
            else if(direction == 3){
                System.out.println("Right");
                if (maze[this.current_row][this.current_column + 1].value == 1 ||
                        (this.current_column + 1 == this.pre_column && this.current_row == this.pre_row)) {
                    continue;
                }
                this.pre_row = this.current_row;
                this.pre_column = this.current_column;
                this.current_column++;
                System.out.println("moved right");
                moved = true;
            }
        }while(moved == false);

    }

}
