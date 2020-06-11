package UI;

/**
 * I separated the Cell from the maze
 * because I need to use the Cell class
 * in class Player, Monster and Power.
 *
 * Also I have asked Victor, he said it
 * will be a better idea to separate them
 */

public class Cell {
    public int x;
    public int y;
    public int value;
    public boolean visited = false;
}
