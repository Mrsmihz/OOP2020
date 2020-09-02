public class FootballPlayer extends Player{
    private int playerNumber;
    private String position;

    public void setplayerNumber(int n){
        this.playerNumber = n;
    }
    public int getplayerNumber(){
        return this.playerNumber;
    }
    public void setposition(String p){
        this.position = p;
    }
    public String getposition(){
        return this.position;
    }
    public boolean isSamePosition(FootballPlayer p){
        if (p.getposition().equals(this.getposition()) && p.getTeam().equals(this.getTeam())){
            return true;
        }
        else{
            return false;
        }
    }
}
