

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class GameState {
    public static ArrayList<Player> players;
    public static ArrayList<ArrayList<Integer>> adjacency;
    public static ArrayList<ArrayList<Tile>> tiles;
    public static BufferedImage[] tileImages;
    public static Tile[] tilesList;
    public static ArrayList<ArrayList<BufferedImage>> infrastructureImages;
    public static Stack<DevelopmentCard> developmentCardDeck;
    public static Stack<ResourceCard> resourceCardDeck;
    public static ArrayList<Port> ports;
    public static int turn;
    public static int num;
    public static int banditLocation;
    public static int currentPlayer;
    public static int dice1, dice2;
    public static ParentPanel p;
    public GameState(int num, ParentPanel p) {
        this.p=p;
        currentPlayer=0;
        players = new ArrayList<Player>();
        adjacency = new ArrayList<ArrayList<Integer>>();
        tiles = new ArrayList<ArrayList<Tile>>();
        for (int i = 0; i < 20; i++) {
            adjacency.add(new ArrayList<Integer>());
            tiles.add(new ArrayList<Tile>());
        }
        developmentCardDeck = new Stack<DevelopmentCard>();
        resourceCardDeck = new Stack<ResourceCard>();
        for (int i = 0; i < 19; i++) {
            resourceCardDeck.add(new Wood());
            resourceCardDeck.add(new Sheep());
            resourceCardDeck.add(new Wheat());
            resourceCardDeck.add(new Clay());
            resourceCardDeck.add(new Ore());
        }
        shuffleResourceCards();

        for (int i = 0; i < 14; i++)
            developmentCardDeck.add(new Knight());
        for (int i = 0; i < 5; i++) {
            developmentCardDeck.add(new VictoryPoint());

        }
        for (int i = 0; i < 3; i++) {
            developmentCardDeck.add(new YearOfPlenty());
            developmentCardDeck.add(new RoadBuilding());
        }
        shuffleDevelopmentCards();
        ports = new ArrayList<Port>();
        tileImages = new BufferedImage[19];
        for (int i = 0; i < 4; i++) {
            ports.add(new Port());
        }
        //add 5 more 2:1 for each resource
        Collections.shuffle(ports);

        tilesList = new Tile[19];
        infrastructureImages = new ArrayList<ArrayList<BufferedImage>>();
        //0 road
        //1 settlement
        //2 city
        infrastructureImages.add(new ArrayList<BufferedImage>());
        infrastructureImages.add(new ArrayList<BufferedImage>());
        infrastructureImages.add(new ArrayList<BufferedImage>());
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(5, 2, 6, 3, 8, 10, 9, 12,
                11, 4, 8, 10, 9, 4, 5, 6, 3, 11));
        ArrayList<ResourceCard> types = new ArrayList<ResourceCard>();

        types.add(new Sheep());
        types.add(new Sheep());
        types.add(new Sheep());
        types.add(new Sheep());
        types.add(new Wood());
        types.add(new Wood());
        types.add(new Wood());
        types.add(new Wood());
        types.add(new Wheat());
        types.add(new Wheat());
        types.add(new Wheat());
        types.add(new Wheat());
        types.add(new Ore());
        types.add(new Ore());
        types.add(new Ore());
        types.add(new Clay());
        types.add(new Clay());
        types.add(new Clay());
        Collections.shuffle(types);
        //Collections.shuffle(numbers);
        Random r = new Random();
        Integer rando = r.nextInt(19);
        types.add(rando, new ResourceCard("None"));
        numbers.add(rando, 0);
        banditLocation = rando;
        for (int i = 0; i < 19; i++) {


            if (!types.get(i).getType().equals("None")) {
                BufferedImage current;
                try {
                    String str = "/tiles/" + types.get(i).getType() + ".png";
                   // System.out.println(types.get(i).getType());
                    current = ImageIO.read(GameState.class.getResource("/resource/tiles/" + types.get(i).getType() + ".png"));
                    tileImages[i]=current;

                } catch (Exception e) {
                   // System.out.println("TILE NO WORK");
                    current = null;
                }

                tilesList[i] = new Tile(0, 0, numbers.get(i), false, types.get(i), i, current);
            } else {
                BufferedImage current;
                try {
                    current = ImageIO.read(GameState.class.getResource("/resource/tiles/desert.png"));
                    tileImages[i]=current;
                } catch (Exception e) {
                //    System.out.println("DESERT NO WORK");
                    current = null;
                }
                //System.out.println("GUHUKSHGDJHGSKJD");
                tilesList[i] = new Tile(0, 0, numbers.get(i), true, types.get(i), i, current);
            }
        }
        for (int i = 0; i < 3; i++) {
            tiles.get(0).add(tilesList[i]);
        }
        for (int i = 3; i < 7; i++) {
            tiles.get(1).add(tilesList[i]);

        }
        for (int i = 7; i < 12; i++) {
            tiles.get(2).add(tilesList[i]);
        }
        for (int i = 12; i < 16; i++) {
            tiles.get(3).add(tilesList[i]);
        }
        for (int i = 16; i < 19; i++) {
            tiles.get(4).add(tilesList[i]);
        }

        this.num = num;
        Player p1 = new Player(0, "red");
        players.add(p1);
        Player p2 = new Player(1, "blue");
        players.add(p2);
        if (num >= 3) {
            Player p3 = new Player(2, "white");
            players.add(p3);
        }
        if (num >= 4) {
            Player p4 = new Player(3, "yellow");
            players.add(p4);
        }


    }

    public ArrayList<Integer> tileNumOrder(int start){
        //counterclockwise
        ArrayList<Integer> order = new ArrayList<Integer>();
        if(start == 1){
            ArrayList<Integer> r = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 7, 12, 16, 19, 18, 17,13,8,4,5,6,11,15,14,9,10));
            order = r;
        }
        if(start == 2){
            ArrayList<Integer> r = new ArrayList<Integer>(Arrays.asList(2, 3, 7, 12, 16, 19, 18, 17, 13, 8, 4, 1,5, 6, 11, 15, 14, 9, 10));
            order = r;
        }
        if(start == 3){
            ArrayList<Integer> r = new ArrayList<Integer>(Arrays.asList(3, 7, 12, 16, 19, 18, 17,13,8,4, 1, 2, 6,11,15,14,9,5, 10));
            order = r;
        }
        if(start == 7){
            ArrayList<Integer> r = new ArrayList<Integer>(Arrays.asList(7, 12, 16, 19, 18, 17,13,8,4, 1, 2, 3, 6,11,15,14,9, 5, 10));
            order = r;
        }
        if(start == 12){
            ArrayList<Integer> r = new ArrayList<Integer>(Arrays.asList(12, 16, 19, 18, 17,13,8,4, 1, 2, 3, 7, 11,15,14,9, 5, 6, 10));
            order = r;
        }
        if(start == 16){
            ArrayList<Integer> r = new ArrayList<Integer>(Arrays.asList(16, 19, 18, 17,13,8,4, 1, 2, 3, 7, 12, 11,15,14,9, 5, 6, 10));
            order = r;
        }
        if(start == 1){
            ArrayList<Integer> r = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 7, 12, 16, 19, 18, 17,13,8,4,5,6,11,15,14,9,10));
            order = r;
        }
        if(start == 1){
            ArrayList<Integer> r = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 7, 12, 16, 19, 18, 17,13,8,4,5,6,11,15,14,9,10));
            order = r;
        }
        if(start == 1){
            ArrayList<Integer> r = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 7, 12, 16, 19, 18, 17,13,8,4,5,6,11,15,14,9,10));
            order = r;
        }
        return order;
    }

    public void moveBandit(int tile, int moverNum, int victimNum, int n) {
        tilesList[banditLocation].removeBandit();
        banditLocation = tile;
        tilesList[banditLocation].placeBandit();
        Player mover = players.get(moverNum);
        Player victim = players.get(victimNum);
        mover.addResourceCard(victim.getResourceCards().remove(n));
    }

    public int checkWin() {
        for (int i = 0; i < num; i++) {
            if (players.get(i).getVictoryPoints() >= 10) {
                return i;
            }
        }
        return -1;
    }

    public void nextTurn() {
        currentPlayer = (currentPlayer + 1) % players.size();
        p.getGUIGameBoard().setPlayedd(false);
        //   System.out.println(currentPlayer);
    }
    public void nextTurn2() {
        if(currentPlayer-1>=0){
            currentPlayer--;
        }
        else
            currentPlayer=3;
    }
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    public void setCurrentPlayer(int x){
        currentPlayer=x;
    }
    public void rollDice() {
        int r1= (int) (Math.random() * 6 + 1);
        int r2= (int) (Math.random() * 6 + 1);
        int sum=r1+r2;


        System.out.println(r1+r2);
        if(sum==7) {
            for(int i=0;i<4;i++){
                if(GameState.players.get(i).getResourceCards().size()>7){

                }
            }
           boolean flag=false;
            for(int i=0;i<4;i++){
                if(i!=GameState.currentPlayer){
                    if(GameState.players.get(i).getResourceCards().size()!=0){
                        flag=true;
                    }
                }
            }
            if(flag) {
                p.getGUIGameBoard().setBandit(true);
                infoBox("Click the center of a tile to steal from", "");
            }
//        if(sum==8){
//            Player p=players.get(0);
//            for(int i=0;i<19;i++) {
//                Tile currentTile = GameState.tilesList[i];
//                if(currentTile.getRollNumber()==8){
//                    p.getHasCity()[i][0]=1;
//                    System.out.println("PLAYER 17");
//                    //if(currentTile.getPlayersOnTile().contains(players.get(0)))
//                    currentTile.getPlayersOnTile().add(players.get(0));
//                }
//            }
//        }
        }
         else{
            for(int i=0;i<19;i++){
            Tile currentTile=GameState.tilesList[i];
            if(GameState.tilesList[i].getRollNumber()==sum&&GameState.tilesList[i].getHasBandit()==false)
            {
              //  System.out.println("PLAYER 3");
                for(Player p: GameState.tilesList[i].getPlayersOnTile()){
                  //  System.out.println(GameState.tilesList[i].getPlayersOnTile().size()+" HEHEHEHA");
                    int arr[][]=p.getHasCity();
                    for(int j=0;j<6;j++){
                        if(arr[currentTile.getNumber()][j]==1){
                            p.addResourceCard(currentTile.getType());
                        }
                        if(arr[currentTile.getNumber()][j]==2){
                            p.addResourceCard(currentTile.getType());
                            p.addResourceCard(currentTile.getType());
                        //    System.out.println("PLAYER 1"+ p.getNumber());
                        }
                    }
                }
            }
        }
         }
        dice1 = r1;
        dice2 = r2;
    }

    public static void shuffleDevelopmentCards() {
        Collections.shuffle(developmentCardDeck);
    }

    public static void shuffleResourceCards() {
        Collections.shuffle(resourceCardDeck);
    }
    public int getCurrentPlayer(){
        return currentPlayer;
    }
}