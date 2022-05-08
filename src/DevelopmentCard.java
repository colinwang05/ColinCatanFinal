

import java.awt.image.BufferedImage;

public class DevelopmentCard {

    private String type;
    private BufferedImage image;
    private int playerNum;

    public DevelopmentCard(String t){
        setType(t);
        setPlayerNum(-1);
    }
    public void setType(String t){
        type = t;
    }
    public String getType(){ return type; }
    public void setPlayerNum(int p){
        playerNum = p;
    }
    public int getPlayerNum(){
        return playerNum;
    }
    public BufferedImage getImage(){
        return image;
    }
    public boolean equals(DevelopmentCard r) {
        if (type.equals(r.getType()))
            return true;
        return false;
    }
}
