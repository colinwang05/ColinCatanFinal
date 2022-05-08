


import java.util.Stack;

public class YearOfPlenty extends DevelopmentCard {
    public YearOfPlenty(){
        super("year of plenty");
    }

    //still need to remove r1 and r2 from resource card deck
    public void use(int playerNum, ResourceCard r1, ResourceCard r2){

        GameState.players.get(playerNum).addResourceCard(r2);
        boolean flag = true;
        Stack<ResourceCard> x = new Stack<>();
        if(GameState.resourceCardDeck.contains(r1)){
            GameState.players.get(playerNum).addResourceCard(r1);
            GameState.resourceCardDeck.remove(r1);
        }
        else{
            flag = false;
            x.add(r1);
        }
        if(flag && GameState.resourceCardDeck.contains(r2)){
            GameState.players.get(playerNum).addResourceCard(r2);
            GameState.resourceCardDeck.remove(r2);
        }
        else{
            flag = false;
            x.add(r2);
        }
        if(!flag){
            for(ResourceCard reAdd : x){
                GameState.resourceCardDeck.add(reAdd);
            }
        }
    }
}
