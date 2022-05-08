
public class Infrastructure {
    private int xloc;
    private int yloc;
    private int side;
    private int corner;
    private String color;
    private int playerNumber;

    public Infrastructure() {
    }

    public Infrastructure(int x, int y, int s, int c, String col, int p) {
        setXLoc(x);
        setYLoc(y);
        setSide(s);
        setCorner(c);
        setColor(col);
        setPlayerNumber(p);
    }

    public int getXLoc() {
        return xloc;
    }

    public int getYLoc() {
        return yloc;
    }

    public int getSide() {
        return side;
    }

    public int corner() {
        return corner;
    }

    public String getColor() {
        return color;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setXLoc(int x) {
        xloc = x;
    }

    public void setYLoc(int y) {
        yloc = y;
    }

    public void setSide(int s) {
        side = s;
    }

    public void setCorner(int c) {
        corner = c;
    }

    public void setColor(String c) {
        color = c;
    }

    public void setPlayerNumber(int p) {
        playerNumber = p;
    }
}
