package Game_Logic;


public class Game {
    private static int monster_to_be_killed = 3;
    private static int powers_in_possession = 0;
    private static int monster_alive = 3;
    private static Cell[][] maze;
    private static Player player;
    private static Monster monster_1;
    private static Monster monster_2;
    private static Monster monster_3;
    private static Power power;
    private static boolean end = false;
    private static boolean win = false;
    private static boolean lose = false;

    public Game() {
        Maze m = new Maze();
        do {
            maze = m.generateMaze(20, 15);
        }while(m.validMaze(maze));
        player = new Player();
        monster_1 = new Monster(1, 18);
        monster_2 = new Monster(13, 1);
        monster_3 = new Monster(13,18);
        power = new Power(maze);
    }



    public boolean move(char key) {
        if (player.move(maze, key)) {
            monster_1.move(maze);
            monster_2.move(maze);
            monster_3.move(maze);
            get_power();
            return true;
        }
        return false;
    }

    public void cheating(){
        this.setMonster_to_be_killed(1);
    }

    // clean the map vision
    public void clean_map(){
        /**
         * Type Here
         */
    }

    public boolean end(){
        /**
         *
         */
        return true;
    }

    public boolean lose(){
        /**
         *
         */
        return false;
    }

    public boolean win(){
        /**
         *
         */
        return false;
    }

    // If player get the power, increase power in hand
    // generate new power
    public void get_power(){
        if(player.getCurrent_row() == power.getRow() &&
                player.getCurrent_row() == power.getColumn()){
            powers_in_possession++;
            power = new Power(maze);
        }
        return;
    }

    public int getMonster_to_be_killed() {
        return monster_to_be_killed;
    }

    public int getPowers_in_possession() {
        return powers_in_possession;
    }

    public int getMonster_alive() {
        return monster_alive;
    }

    public Cell[][] getMaze() {
        return maze;
    }

    public Player getPlayer() {
        return player;
    }

    public Monster getMonster_1() {
        return monster_1;
    }

    public Monster getMonster_2() {
        return monster_2;
    }

    public Monster getMonster_3() {
        return monster_3;
    }

    public Power getPower() {
        return power;
    }

    public void setMonster_to_be_killed(int monster_to_be_killed) {
        Game.monster_to_be_killed = monster_to_be_killed;
    }

}
