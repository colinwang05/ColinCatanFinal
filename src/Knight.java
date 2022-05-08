
public class Knight extends DevelopmentCard {

    private boolean shown;

    public Knight(){
        super("knight");
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
}
