import java.util.*;

//Choose the initial cell, mark it as visited and push it to the stack
//        While the stack is not empty
//        Pop a cell from the stack and make it a current cell
//        If the current cell has any neighbours which have not been visited
//        Push the current cell to the stack
//        Choose one of the unvisited neighbours
//        Remove the wall between the current cell and the chosen cell
//        Mark the chosen cell as visited and push it to the stack

public class Maze {
    class Cell {
        public int x;
        public int y;
        public int value;
        boolean visited = false;
    }
    private int width;
    private int height;
    public  Cell[][] maze;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell[][] generateMaze(int width, int height) {
        Cell[][] maze = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Cell cell = new Cell();
                if (i % 2 == 0) {
                    cell.value = 1;
                } else {
                    if (j % 2 == 0) {
                        cell.value = 1;

                    }
                    else {
                        cell.value = 0;
                    }
                }
                cell.x = i;
                cell.y = j;

                maze[i][j] = cell;
            }
        }

        swap(maze);//if width's number is even
        Stack<Cell> stack = new Stack<Cell>();
        Cell start = maze[1][1];
        start.visited = true;
        stack.push(start);

        while (!stack.isEmpty()) {
            List<Cell> neiList = new ArrayList<Cell>();
            Cell cur = stack.pop();
            //Up
            if (cur.x - 2 > 0) {
                Cell up = maze[cur.x - 2][cur.y];
                if (!up.visited)
                    neiList.add(up);
            }
            //Down
            if (cur.x + 2 < height) {
                Cell down = maze[cur.x + 2][cur.y];
                if (!down.visited)
                    neiList.add(down);
            }

            //Left
            if (cur.y - 2 > 0) {
                Cell left = maze[cur.x][cur.y - 2];
                if (!left.visited)
                    neiList.add(left);
            }

            //Right

            if (cur.y + 2 < width - 1) {

                Cell right = maze[cur.x][cur.y + 2];
                if (!right.visited)
                    neiList.add(right);
            }

            if (neiList.size() != 0) {
                stack.push(cur);
                Cell nextCell = neiList.get(new Random().nextInt(neiList.size()));
                maze[(cur.x + nextCell.x) / 2][(cur.y + nextCell.y) / 2].value = 0;
                nextCell.visited = true;
                stack.push(nextCell);
            }
        }


        for(int i = 2; i < maze.length - 1; i += 2) {
            List<Cell> list = new ArrayList<>();
            for(int j = 1; j < maze[0].length - 1; j++) {
                if(maze[i][j].value == 1) {
                    list.add(maze[i][j]);
                }
            }
            if(list.size() > 0) {
                Cell pickedCell = list.get(new Random().nextInt(list.size()));
                pickedCell.value = 0;
            }
        }

        return maze;


    }

    private void swap(Cell[][] maze) {
        int width = maze[0].length;
        for(int i = 0; i < maze.length ; i++) {
            int temp = maze[i][width - 1].value;
            maze[i][width - 1].value = maze[i][width - 2].value;
            maze[i][width - 2].value = temp;
        }
    }

    private boolean validMaze(Cell[][] maze) {
       for(int i = 1; i < maze.length - 1; i++) {
           for(int j = 1; j < maze[0].length - 1; j++) {
               int up = i - 1;
               int down = i + 1;
               int left = j - 1;
               int val = maze[i][j].value;
               if(maze[up][j].value == val && maze[down][j].value == val
               && maze[i][left].value == val && maze[i - 1][j - 1].value == val) {
                   return false;
               }

           }
       }
       return true;
    }

    public static void main(String[] args) {
        Maze m = new Maze();

        while(true) {
            Cell[][] maze = m.generateMaze(20, 15);
            if(m.validMaze(maze)) {
                for(int i = 0; i < maze.length; i++){
                    for(int j = 0; j < maze[0].length; j++){
                        System.out.print(maze[i][j].value + " ");
                    }
                    System.out.println();
                }

                break;
            }

        }




    }
}
