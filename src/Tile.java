


import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Tile {
    private int number;
    private int xpos;
    private int ypos;
    private int rollNumber;
    private int[] xverticies;
    private int[] yverticies;
    private ArrayList<Integer> connected;
    private int rightTile[];
    private int leftTile[];
    private int connectedEdges[];
    private ArrayList<Integer> settlements;
    private ArrayList<Integer> cities;
    private ArrayList<Player> playersOnTile;
    private boolean[] hasEdgeRoad;
    private boolean[] hasVertexRoad;
    private boolean hasBandit;
    private ResourceCard type;
    private BufferedImage image;
    private int hascityorsettlement[];
    private int[]xroad;
    private int[]yroad;
    private int[]pointer;
    private String hascityorsettlementcolor[];
    private String hasVertexRoadColor[];
    //1 settlemnt
    //2 city
    //0 none
    private boolean isCity[];
    public int[] getxroad(){
        return xroad;
    }
    public int[]getyroad(){return yroad;
    }
    public void setxroad(int arr[]){
        xroad=arr;
    }
    public void setyroad(int arr[]){
        yroad=arr;
    }
    public Tile(int x, int y, int roll, boolean hasBandit, ResourceCard t, int number, BufferedImage b) {
        //isCity=new int[6];
        this.hasBandit=hasBandit;
        hascityorsettlementcolor=new String[6];
        hasVertexRoadColor=new String[6];
        xroad=new int[6];
        pointer = new int[6];
        yroad=new int[6];
        hascityorsettlement=new int[6];
        playersOnTile=new ArrayList<>();
        image=b;
        xverticies = new int[6];
        yverticies = new int[6];
        connected = new ArrayList<Integer>();
        rightTile = new int[6];
        leftTile = new int[6];
        connectedEdges = new int[6];
        settlements = new ArrayList<Integer>();
        cities = new ArrayList<Integer>();
        hasEdgeRoad = new boolean[6];
        hasVertexRoad = new boolean[6];
        type = t;
        rollNumber = roll;
        this.number = number;
        if (number == 0) {
            connected.add(1);
            connected.add(3);
            rightTile[0] = -1;
            leftTile[0] = -1;
            rightTile[1] = 1;
            leftTile[1] = -1;
            rightTile[2] = 1;
            leftTile[2] = 4;
            rightTile[3] = 4;
            leftTile[3] = 3;
            rightTile[4] = 3;
            leftTile[4] = -1;
            rightTile[5] = -1;
            leftTile[5] = -1;
        }
        if (number == 1) {
            connected.add(2);
            connected.add(0);
            connected.add(4);
            connected.add(5);
            rightTile[0] = -1;
            leftTile[0] = -1;
            rightTile[1] = 2;
            leftTile[1] = -1;
            rightTile[2] = 2;
            leftTile[2] = 5;

            rightTile[3] = 5;
            leftTile[3] = 4;
            rightTile[4] = 4;
            leftTile[4] = 0;
            rightTile[5] = -1;
            leftTile[5] = 0;
        }
        if (number == 2) {
            connected.add(1);
            connected.add(5);
            connected.add(6);
            rightTile[0] = -1;
            leftTile[0] = -1;
            rightTile[1] = -1;
            leftTile[1] = -1;
            rightTile[2] = 6;
            leftTile[2] = -1;
            rightTile[3] = 6;
            leftTile[3] = 5;
            rightTile[4] = 5;
            leftTile[4] = 1;
            rightTile[5] = -1;
            leftTile[5] = 1;
        }
        if (number == 3) {
            connected.add(0);
            connected.add(4);
            connected.add(8);
            connected.add(7);
            rightTile[0] = 0;
            leftTile[0] = -1;
            rightTile[1] = 4;
            leftTile[1] = 0;
            rightTile[2] = 4;
            leftTile[2] = 8;
            rightTile[3] = 8;
            leftTile[3] = 7;
            rightTile[4] = 7;
            leftTile[4] = -1;
            rightTile[5] = -1;
            leftTile[5] = -1;
        }
        if (number == 4) {
            connected.add(0);
            connected.add(1);
            connected.add(5);
            connected.add(9);
            connected.add(8);
            connected.add(3);


            leftTile[0] = 0;
            rightTile[0] = 1;
            leftTile[1] = 1;
            rightTile[1] = 5;
            leftTile[2] = 9;
            rightTile[2] = 5;
            leftTile[3] = 8;
            rightTile[3] = 9;
            leftTile[4] = 3;
            rightTile[4] = 8;
            leftTile[5] = 3;
            rightTile[5] = 0;
        }
        if (number == 5) {
            connected.add(1);
            connected.add(2);
            connected.add(6);
            connected.add(10);
            connected.add(9);
            connected.add(4);
            leftTile[0] = 1;
            rightTile[0] = 2;
            leftTile[1] = 2;
            rightTile[1] = 6;
            leftTile[2] = 10;
            rightTile[2] = 6;
            leftTile[3] = 9;
            rightTile[3] = 10;
            leftTile[4] = 4;
            rightTile[4] = 9;
            leftTile[5] = 4;
            rightTile[5] = 1;
        }
        if (number == 6) {
            connected.add(2);
            connected.add(11);
            connected.add(10);
            connected.add(5);
            leftTile[0] = 2;
            rightTile[0] = -1;
            leftTile[1] = -1;
            rightTile[1] = -1;
            leftTile[2] = 11;
            rightTile[2] = -1;
            leftTile[3] = 10;
            rightTile[3] = 11;
            leftTile[4] = 5;
            rightTile[4] = 10;
            leftTile[5] = 0;
            rightTile[5] = 0;
        }

        GameState.adjacency.get(number).addAll(connected);
    }
    public String[] getSettlementColor(){
        return hascityorsettlementcolor;
    }
    public String[]getVertexColor(){
        return hasVertexRoadColor;
    }
    public void setXpos(int x){
        xpos=x;
    }
    public void setYpos(int y){
        ypos=y;
    }
    public void setXverticies(int[] x){
        xverticies=x;
    }
    public void setYverticies(int[] x){
        yverticies=x;
    }
    public void givecards() {

    }
    public int[] gethascityorsettlement(){
        return hascityorsettlement;
    }
    public int[] getXverticies() {
        return xverticies;
    }
    public void setBandit(boolean b){
        hasBandit=b;
    }
    public int[] getYverticies() {
        return yverticies;
    }

    public int[] getRightTile() {
        return rightTile;
    }

    public int[] getLeftTile() {
        return leftTile;
    }

    public int[] getConnectedEdges() {return connectedEdges;}

    public int getYpos() {
        return ypos;
    }

    public int getXpos() {
        return xpos;
    }

    public int getNumber() {
        return number;
    }

    public ArrayList<Player> getPlayersOnTile() {
        return playersOnTile;
    }
    public BufferedImage getImage(){
        return image;
    }
    public ArrayList<Integer> getConnections() {
        return connected;
    }

    public boolean canConnect(int t1, int t2, int loc1, int loc2) {
        return true;
    }

    public boolean[] getEdgeRoads() {
        return hasEdgeRoad;
    }

    public boolean[] getVertexRoads() {
        return hasVertexRoad;
    }

    public boolean getHasBandit() {
        return hasBandit;
    }

    public void placeBandit() {
        hasBandit = true;
    }
    public void removeBandit(){
        hasBandit=false;
    }
    public int getRollNumber() {
        return rollNumber;
    }

    public ResourceCard getType() {
        return type;
    }
}
