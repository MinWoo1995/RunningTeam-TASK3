package Task_LOLChampion;

public class main {
    public static void main(String[] args) {
        Garen garen1 = new Garen("Garen1",1,50,100,1000,500);
        Garen garen2 = new Garen("Garen2",1,50,100,1000,500);
        Ash ash1 = new Ash("Ash1",1,100,50,600,500);
        Ash ash2 = new Ash("Ash2",1,100,50,600,500);

        garen2.attackTo(ash1);
        ash1.attackTo(garen1);

    }
}
