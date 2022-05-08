



import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Port {
    private int xloc, yloc;
    private ResourceCard typeIn, typeOut;
    private int ratio;
    private BufferedImage image;
    private int index;

    public Port(){

    }
    public Port(int x, int y, ResourceCard in, ResourceCard out, int r, int i){
        xloc = x;
        yloc = y;
        typeIn = in;
        typeOut = out;
        ratio = r;
        index = i;
    }

    public boolean use(int playerNum){ //continue this method (not complete yet), still need player to receive cards
        Player player = GameState.players.get(playerNum);
        ArrayList<ResourceCard> x=new ArrayList<ResourceCard>();
        boolean flag=true;
        for(int i=0; i<index; i++){
            if(player.getResourceCards().contains(typeIn)){
                player.getResourceCards().remove(typeIn);
                x.add(typeIn);
            }
            else{
                flag = false;
            }
        }
        if(flag){
            for(ResourceCard reAdd : x){
                GameState.resourceCardDeck.add(reAdd);
                GameState.shuffleResourceCards();
            }
            GameState.resourceCardDeck.remove(typeOut);
            player.addResourceCard(typeOut);
        }
        else{
            for(ResourceCard reAdd : x){
                player.addResourceCard(reAdd);
            }
        }
        return flag;
    }

    public int getXloc(){
        return xloc;
    }
    public int getYloc(){
        return yloc;
    }
    public ResourceCard getTypeIn(){
        return typeIn;
    }
    public ResourceCard getTypeOut(){
        return typeOut;
    }
    public BufferedImage getImage(){
        return image;
    }
    public int getIndex(){
        return index;
    }

}
