package Task_LOLChampion;

public class main {
    public static void main(String[] args) {
        Garen garen1 = new Garen("Garen1");
        Garen garen2 = new Garen("Garen2");
        Ash ash1 = new Ash("Ash1");
        Ash ash2 = new Ash("Ash2");

        garen2.attackTo(ash1);
        ash1.attackTo(garen1);

    }
}
