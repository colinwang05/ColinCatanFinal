

public class Settlement extends Infrastructure{
    private boolean city, port;
    private int topRight, topLeft, bottom;

    public Settlement(){
    }

    public boolean isCity(){
        return city;
    }
    public void portTrade(){

    }
    public int getTopLeft(){
        return topLeft;
    }
    public int getTopRight(){
        return topRight;
    }
    public int getBottom(){
        return bottom;
    }
    public void setCity(boolean c){
        city = c;
    }
}
