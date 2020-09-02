public class Main {
    public static void main(String[] args) {
        second();

    }
    public static void first(){
        Player p1 = new Player();
        p1.setName("Bank");
        p1.setTeam("Gate OR");

        Player p2 = new Player();
        p2.setName("Khim");
        p2.setTeam("Gate OR");

        if (p1.isSameTeam(p2)){
            System.out.println(p1.getName() + " is a same team with " + p2.getName());
        }
        else{
            System.out.println(p1.getName() + " is not a same team with " + p2.getName());
        }
    }
    public static void second(){
        FootballPlayer p1 = new FootballPlayer();
        p1.setName("Harry");
        p1.setTeam("Gryffindor");
        p1.setplayerNumber(1);
        p1.setposition("keeper");

        FootballPlayer p2 = new FootballPlayer();
        p2.setName("Jame");
        p2.setTeam("Gryffindor");
        p2.setplayerNumber(2);
        p2.setposition("Gryffindor");
        System.out.println(p1.isSamePosition(p2));
        System.out.println(p1.isSameTeam(p2));
    }
}
