import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player1 {
    private String color, role, relatedTreasure;
    private int xpos, ypos, order, actionsLeft;
    private TreasureDeck treasureDeck;
    private ArrayList<TreasureCard> hand;
    private ArrayList<Tile1> movableTile1s, movableTiles_helicopter, tilesNotSunk;
    private BufferedImage pown, pown_move;
    private GameBoard gameBoard;
    private WaterMeter waterMeter;
    private Boolean hasGotTreasureCards, hasSandBag, hasHelicopterLift;
    private FloodDeck floodDeck;


    public Player1(GameBoard gameBoard, int order, String Color, String Role,
                   TreasureDeck treasureDeck, BufferedImage pown, BufferedImage pown_move, int xPos, int yPos) {
        this.gameBoard = gameBoard;
        waterMeter = gameBoard.getWaterMeter();
        floodDeck = gameBoard.getFloodDeck();
        this.order = order;
        color = Color;
        role = Role;
        this.treasureDeck = treasureDeck;
        actionsLeft = 3;
        hand = new ArrayList<TreasureCard>();
        this.pown = pown;
        this.pown_move = pown_move;
        xpos = xPos;//row
        ypos = yPos;//column
        hasGotTreasureCards = false;
        hasSandBag = false;
        hasHelicopterLift = false;
        relatedTreasure = " ";
    }

    public void setRelatedTreasure(String str) {
        relatedTreasure = relatedTreasure + str;
    }

    public String getRelatedTreasure() {
        return relatedTreasure;
    }

    public void hasGotTreasureCards() {
        hasGotTreasureCards = true;
    }

    public Boolean checkHasSandBag() {
        for (TreasureCard t : hand) {
            if (t.getName().equals("Sandbag")) {
                return hasSandBag = true;
            }
        }
        return hasSandBag = false;
    }

    public Boolean checkHasHelicopterLift() {
        for (TreasureCard t : hand) {
            //System.out.println(t.getName());
            if (t.getName().equals("Helicopter")) {
                return hasHelicopterLift = true;
            }
        }
        return hasHelicopterLift = false;
    }

    public Boolean getHasGotTreasureCards() {
        return hasGotTreasureCards;
    }

    public void minusOneAction() {
        actionsLeft--;
    }

    public TreasureCard discard(int n) {
        return null;
    }

    public void usedSpecialAction() {
    }

    public ArrayList<Tile1> getMovableTiles() {
        tilesNotSunk = gameBoard.getIslandsClass().getTilesNotSunk();
        movableTile1s = new ArrayList<Tile1>();
        int x = getX();
        int y = getY();
        for (Tile1 t : tilesNotSunk) {
            int tileX = t.getXPos();
            int tileY = t.getYPos();

            if (t.getFloodState() != -1 && tileX == (x - 1) && tileY == y)//the upper tile (North)
            {
                movableTile1s.add(t);
            }
            if (t.getFloodState() != -1 && tileX == x && tileY == y - 1)//the left tile (West)
            {
                movableTile1s.add(t);
            }
            if (t.getFloodState() != -1 && tileX == (x + 1) && tileY == y)//the bottom tile (South)
            {
                movableTile1s.add(t);
            }
            if (t.getFloodState() != -1 && tileX == x && tileY == y + 1)//the right tile (East)
            {
                movableTile1s.add(t);
            }
            if (role == "Explorer") {
                if (t.getFloodState() != -1 && tileX == x + 1 && tileY == y + 1) {
                    movableTile1s.add(t);
                }
                if (t.getFloodState() != -1 && tileX == x - 1 && tileY == y - 1) {
                    movableTile1s.add(t);
                }
                if (t.getFloodState() != -1 && tileX == x + 1 && tileY == y - 1) {
                    movableTile1s.add(t);
                }
                if (t.getFloodState() != -1 && tileX == x - 1 && tileY == y + 1) {
                    movableTile1s.add(t);
                }
            }

        }
        return movableTile1s;
    }

    public ArrayList<Tile1> getShorableTiles() {
        ArrayList<Tile1> allTile1s = gameBoard.getAllTiles();
        movableTile1s = new ArrayList<Tile1>();
        int x = getX();
        int y = getY();
        for (Tile1 t : allTile1s) {
            int tileX = t.getXPos();
            int tileY = t.getYPos();
            if (t.getFloodState() == 0 &&tileX == x && tileY == y)
                movableTile1s.add(t);
            if (t.getFloodState() == 0 && tileX == (x - 1) && tileY == y)//the upper tile (North)
            {
                movableTile1s.add(t);
            }
            if (t.getFloodState() == 0 && tileX == x && tileY == y - 1)//the left tile (West)
            {
                movableTile1s.add(t);
            }
            if (t.getFloodState() == 0 && tileX == (x + 1) && tileY == y)//the bottom tile (South)
            {
                movableTile1s.add(t);
            }
            if (t.getFloodState() == 0 && tileX == x && tileY == y + 1)//the right tile (East)
            {
                movableTile1s.add(t);
            }
            if (role == "Explorer") {
                if (t.getFloodState() == 0 && tileX == x + 1 && tileY == y + 1) {
                    movableTile1s.add(t);
                }
                if (t.getFloodState() == 0 && tileX == x - 1 && tileY == y - 1) {
                    movableTile1s.add(t);
                }
                if (t.getFloodState() == 0 && tileX == x + 1 && tileY == y - 1) {
                    movableTile1s.add(t);
                }
                if (t.getFloodState() == 0 && tileX == x - 1 && tileY == y + 1) {
                    movableTile1s.add(t);
                }
            }

        }

        return movableTile1s;
    }

    public void setBackToOriginal() {
        actionsLeft = 3;
        hasGotTreasureCards = false;
    }

    public BufferedImage getPownBufferedImage() {
        return pown;
    }

    public BufferedImage getPownBufferedImage_move() {
        return pown_move;
    }

    public int getActionsLeft() {
        return actionsLeft;
    }

    public void setActionsLeftToZero() {
        actionsLeft = 0;
    }

    public boolean canGo() {
        return actionsLeft > 0;
    }

    public boolean canMove(int y, int x) {
        //System.out.println(x+" "+y);
        //System.out.println("XPOS "+ xpos+" YPOS "+ypos);

        for (int i = 0; i < 4; i++) {
            //System.out.println(xpos + GameBoard.dx[i]+" "+(Integer)(ypos + GameBoard.dy[i]));
            if (xpos + GameBoard.dx[i] == x && ypos + GameBoard.dy[i] == y) {
                return true;
            }
        }
        return false;
    }

    public int getOrder() {
        return order;
    }

    public String toString() {
        return role;
    }

    public String getRole() {
        return role;
    }

    public void setX(int x) {
        xpos = x;
        //System.out.println("set"+xpos);
    }

    public void setY(int y) {
        ypos = y;
    }

    public int getX() {
        //System.out.println(xpos);
        return xpos;
    }

    public int getY() {
        return ypos;
    }

    public void drawTwoCards() {
        TreasureCard t = treasureDeck.draw();
        hand.add(t);
        if (t.getName().equals("WaterRise")) {
            hand.remove(t);
            gameBoard.getTreasureDeck().getDiscardTreasureCards().add(t);
            waterMeter.waterRises();
            floodDeck.resetFloodCards();
            gameBoard.getDiscardTreasureCards().add(t);
            //gameBoard.getTreasureDeck().getDiscardTreasureCards().add(t);
        }
        t = treasureDeck.draw();
        hand.add(t);
        if (t.getName().equals("WaterRise")) {
            hand.remove(t);
            gameBoard.getTreasureDeck().getDiscardTreasureCards().add(t);
            waterMeter.waterRises();
            floodDeck.resetFloodCards();
        }
        check();
    }

    public void drawTwoInitialCards() {
        TreasureCard c = treasureDeck.draw();
        while (c.getName().equals("WaterRise")) {
            c = treasureDeck.draw();
        }
        hand.add(c);
        c = treasureDeck.draw();
        while (c.getName().equals("WaterRise")) {
            c = treasureDeck.draw();
        }
        hand.add(c);
        check();
    }
    
    /*
    public void generalMove(String str) 
    {
        Pair p = GameBoard.move.get(str);
        if (GameBoard.islands.canMove(xpos + p.first(), ypos + p.second())) {
            xpos = xpos + p.first();
            ypos = ypos + p.second();
        }
        //check if u can move and if u have enough mvoes
    }
	*/
    //BUG not working

    public void check() {
//        if (hand.size() > 5) {
//            TreasureCard choice = hand.get(6);
//            System.out.println("remove works");
//            hand.remove(5);
//            if (hand.size() > 6) {
//                TreasureCard choice2 = hand.get(7);
//                hand.remove(6);
//            }
//        }
    }

    public ArrayList<TreasureCard> getHand() {
        return hand;
    }

	
    
    /*
    public void discardTreasureCard(TreasureCard t) 
    {
        hand.remove(t);

    }
	
    public void give() 
    {

    }

    public void collect() 
    {
        int blue = 0;
        int red = 0;
        int yellow = 0;
        int black = 0;
        for (TreasureCard t : hand) {
            if (t.getFunction().equals("Treasure4")) {
                if (t.getName() == "black") {
                    black++;
                }
                if (t.getName() == "red") {
                    red++;
                }
                if (t.getName() == "blue") {
                    blue++;
                }
                if (t.getName() == "yellow") {
                    yellow++;
                }
            }
        }
        Boolean b = false;
        if (Islands.tileLocation[xpos][ypos].getRelatedTreasure() != null) {
            if (blue >= 4) {
                if (Islands.tileLocation[xpos][ypos].getRelatedTreasure() == "blue") {
                    b = GameBoard.Treasure.get("blue");
                    b = true;
                    int i = 0;
                    int current = hand.size();
                    while (i != 4) {
                        if (hand.get(current).getName() == "blue") {
                            hand.remove(current);
                            i++;
                        }

                    }


                }


            }
            if (red >= 4) {
                if (Islands.tileLocation[xpos][ypos].getRelatedTreasure() == "red") {
                    b = GameBoard.Treasure.get("red");
                    b = true;
                    int i = 0;
                    int current = hand.size();
                    while (i != 4) {
                        if (hand.get(current).getName() == "red") {
                            hand.remove(current);
                            i++;
                        }

                    }
                }
            } else if (yellow >= 4) {
                if (Islands.tileLocation[xpos][ypos].getRelatedTreasure() == "yellow") {
                    b = GameBoard.Treasure.get("yellow");
                    b = true;
                    int i = 0;
                    int current = hand.size();
                    while (i != 4) {
                        if (hand.get(current).getName() == "yellow") {
                            hand.remove(current);
                            i++;
                        }

                    }
                }
            } else if (black >= 4) {
                if (Islands.tileLocation[xpos][ypos].getRelatedTreasure() == "black") {
                    b = GameBoard.Treasure.get("black");
                    b = true;
                    int i = 0;
                    int current = hand.size();
                    while (i != 4) {
                        if (hand.get(current).getName() == "black") {
                            hand.remove(current);
                            i++;
                        }

                    }
                }
            }

        }
    }

    public void shoreUp() {

    }
    */
}
