package UI;

//import Game_Logic.Board;
import Game_Logic.Game;

public class TextMenu {
    private static Game game;


    public TextMenu(Game game){
        this.game = game;
    }

    // Display the game purpose when input = m
    public void display_purpose(){
        System.out.println("DIRECTIONS:\n\tKill 3 Monsters!");
        System.out.println("Legend:\n\t#: Wall\n\t@: You (a hero)\n\t"
                + "!: Monster\n\t$: Power\n\t.: Unexplored space");
        System.out.println("Moves:\n\tUse W (up), A (left), S (down) "
                + "and D (right) to move.\n\t (You must press enter after each move).\n");
    }

    //Display Map
//    public void display_map(){
//        for(int i = 0; i < game.getMaze().length; i++){
//            for(int j = 0; j < game.getMaze()[0].length; j++){
//                System.out.print(game.getMaze()[i][j].value + " ");
//            }
//            System.out.println();
//        }
//    }

    // Display the current state of the game
    public void display_current_state(){
        for(int i = 0; i < game.getMaze().length; i++){
            for(int j = 0; j < game.getMaze()[0].length; j++){
                System.out.print(game.getMaze()[i][j].value + " ");
            }
            System.out.println();
        }
        System.out.println("Total number of monsters to be killed: " + game.getMonster_to_be_killed());
        System.out.println("Number of powers currently in possession: " + game.getPowers_in_possession());
        System.out.println("Number of monsters alive: " + game.getMonster_alive());
    }

    // Ask for input
    public void ask_input(){
        System.out.println("Enter your move [WASD?]: ");
    }

    // Invalid input
    public void display_invalid_input(){
        System.out.println("Invalid Input!");
    }
}
