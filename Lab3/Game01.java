public class Game01 {
    public static void main(String[] args) {
        Player p1 = createPlayer("Alex", 1000, 10, 5);
        Monster m1 = createMonster("poo1", 100, 10, 3);
        Monster m2 = createMonster("poo2", 120, 12, 5);
        p1.attack(m1);
        p1.attack(m2);
        m1.attack(p1);
        m2.attack(p1);

        p1.showDetail();
        m1.showDetail();
        m2.showDetail();
    }
    public static Player createPlayer(String name, double hp, double atk, int lv){
        Player p = new Player();
        p.name = new String(name);
        p.HP = hp;
        p.atk = atk;
        p.lv = lv;
        return p;
    }
    public static Monster createMonster(String name, double hp, double atk, int lv){
        Monster m = new Monster();
        m.name = new String(name);
        m.HP = hp;
        m.atk = atk;
        m.lv = lv;
        return m;
    }
}
