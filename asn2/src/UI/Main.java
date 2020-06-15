package UI;

import Game_Logic.Game;
import Game_Logic.Player;

import java.util.Scanner;

public class Main {

    public static void main(String arg[]){
        Game game = new Game();

        TextMenu start = new TextMenu(game);
        start.display_purpose();

        Scanner console = new Scanner(System.in);
        char key;

        while(game.end()) {
            start.display_current_state();
            System.out.println("Power at: " + game.getPower().getRow() + ", " + game.getPower().getColumn());
            System.out.println("Player at: " + game.getPlayer().getCurrent_row() + ", " + game.getPlayer().getCurrent_column());
            while (true) {
                start.ask_input();
                key = console.next().charAt(0);
                if(key == '?'){
                    start.display_purpose();
                    continue;
                }
                else if (key == 'c') {
                    game.cheating();
                    continue;
                } else if (key == 'm') {
                    game.clean_map();
                    break;
                } else if (key == 'w' || key == 'a' || key == 's' || key == 'd') {
                    if(game.move(key)){
                        break;
                    }
                    continue;
                } else {
                    start.display_invalid_input();
                    continue;
                }
            }
        }

        System.out.println("---------------END-----------------");
    }

}
