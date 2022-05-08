


public class VictoryPoint extends DevelopmentCard{

    private boolean shown;

    public VictoryPoint(){
        super("victory point");
        hide();

    }
    public void show(){
        shown = true;
    }
    public void hide(){
        shown = false;
    }
    public boolean isShown(){
        return shown;
    }
    public void use(int playerNum){
        GameState.players.get(playerNum).addVictoryPoints(1);
    }
}
