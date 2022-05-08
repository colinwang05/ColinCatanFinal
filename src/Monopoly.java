


import java.util.Stack;

public class Monopoly extends DevelopmentCard{
    public Monopoly(){
        super("monopoly");
    }

    public void use(int player, ResourceCard r){
        Stack<ResourceCard> tempStorage = new Stack<>();
        for(int i=0; i<4; i++){ //fix hardcoding
            if(GameState.players.get(i).getResourceCards().contains(r)){
                for(ResourceCard temp : GameState.players.get(i).getResourceCards()) {
                    if(temp.equals(r)){
                        tempStorage.add(r);
                        GameState.players.get(i).getResourceCards().remove(r);
                    }
                }
            }
        }
        for(ResourceCard toAdd : tempStorage){
            GameState.players.get(player).addResourceCard(toAdd);
        }
    }
}
