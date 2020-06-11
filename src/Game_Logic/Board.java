package Game_Logic;

public class Board {
    private static int monster_to_be_killed = 3;
    private static int powers_in_possession = 0;
    private static int monster_alive = 3;

    public static int getMonster_to_be_killed() {
        return monster_to_be_killed;
    }

    public static void setMonster_to_be_killed(int monster_to_be_killed) {
        Board.monster_to_be_killed = monster_to_be_killed;
    }

    public static int getPowers_in_possession() {
        return powers_in_possession;
    }

    public static void setPowers_in_possession(int powers_in_possession) {
        Board.powers_in_possession = powers_in_possession;
    }

    public static int getMonster_alive() {
        return monster_alive;
    }

    public static void setMonster_alive(int monster_alive) {
        Board.monster_alive = monster_alive;
    }

    // Killed a monster
    public static void monster_got_killed(){
        monster_to_be_killed--;
        monster_alive--;
    }

    // Display the game purpose when input = m
    public void display_purpose(){
        System.out.println("DIRECTIONS:\n\tKill 3 Monsters!");
        System.out.println("Legend:\n\t#: Wall\n\t@: You (a hero)\n\t"
                + "!: Monster\n\t$: Power\n\t.: Unexplored space");
        System.out.println("Moves:\n\tUse W (up), A (left), S (down) "
                + "and D (right) to move.\n\t (You must press enter after each move).");
    }

    // Display the current state of the game
    public void display_current_state(){
        System.out.println("Total number of monsters to be killed: " + getMonster_to_be_killed());
        System.out.println("Number of powers currently in possession: " + getPowers_in_possession());
        System.out.println("Number of monsters alive: " + getMonster_alive());
        System.out.println("Enter your move [WASD?]: ");
    }

}
