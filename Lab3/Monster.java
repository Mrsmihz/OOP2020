public class Monster {
    public String name;
    public Double HP, atk;
    public int lv;

    public void showDetail(){
        System.out.println("name : " + name);
        System.out.println("HP : " + HP);
        System.out.println("atk : "+ atk);
        System.out.println("lv : " + lv);
    }
    public void attack(Player m){
        double n = m.HP;
        if (n-atk >= 0){
            m.HP -= atk;
        }
        else{
            m.HP = (double)0;
        }
    }
}
