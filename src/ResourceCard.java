
import java.awt.image.BufferedImage;

public class ResourceCard {
    private String type;
    private BufferedImage image;
    private int playerNum;

    public ResourceCard(String t){
        setType(t);
        setPlayerNum(-1);
        this.image = image;
    }

    public String getType(){
        return type;
    }
    public BufferedImage getImage(){
        return image;
    }
    public void setType(String t){
        type = t;
    }
    public void setPlayerNum(int p){
        playerNum = p;
    }
    public int getPlayerNum(){
        return playerNum;
    }
    public void setImage(BufferedImage br){
        image=br;
    }
    public boolean equals(ResourceCard r){
        if(type.equals(r.getType()))
            return true;
        return false;
    }
}
