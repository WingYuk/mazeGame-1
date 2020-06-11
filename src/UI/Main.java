//package UI;
//
//import Game_Logic.Board;
//
//public class Main {
//    public static Board board = new Board();
//
//    public static void main(String[] args) {
//        board.display_purpose();
//        Maze m = new Maze();
//
//        while(true) {
//            Maze.Cell[][] maze = m.generateMaze(20, 15);
//            if(m.validMaze(maze)) {
//                for(int i = 0; i < maze.length; i++){
//                    for(int j = 0; j < maze[0].length; j++){
//                        System.out.print(maze[i][j].value + " ");
//                    }
//                    System.out.println();
//                }
//
//                break;
//            }
//
//        }
//        board.display_current_state();
//    }
//}
