
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import static java.lang.System.*;
public class TreasureDeck
{
    private Random u;
    public static Stack<TreasureCard> tdeck, tdiscard;
    private ArrayList<TreasureCard> activeCards;
    private ArrayList<TreasureCard> usedCards;
    private String[] treasureNames, treasureCardNames;
    private GameBoard gameBoard;
    private WaterMeter waterMeter;
    private BufferedImage Card_CrystalOfFire, Card_EarthStone, Card_OceansChalice, Card_StatueOfTheWind, Card_WatersRise, Card_Helicopter, Card_SandBag;
    private BufferedImage[] treasureCards = new BufferedImage[] {Card_CrystalOfFire, Card_EarthStone, Card_OceansChalice, Card_StatueOfTheWind, Card_WatersRise, Card_Helicopter, Card_SandBag};


    public TreasureDeck(GameBoard gameBoard, Random seed)
    {
        this.gameBoard = gameBoard;
        u = seed;
        tdiscard = new Stack<TreasureCard>();
        tdeck = new Stack<TreasureCard>();
        treasureNames = gameBoard.getTreasureNames();
        treasureCardNames = gameBoard.getTreasureCardNames();
        waterMeter = gameBoard.getWaterMeter();
        usedCards = new ArrayList<TreasureCard>();
        try
        {
            for(int i = 0; i < treasureCards.length; i++)
            {
                treasureCards[i] = ImageIO.read(GUIGameBoard.class.getResource("/TreasureDeck/" + treasureCardNames[i] + ".png"));
            }
        }
        catch(Exception E)
        {
            System.out.println("Exception");
            return;
        }
        /*
         * add 28 cards to tdeck:
         * 3 helicopter
         * 2 sandbags
         * 5 of each treasure cards
         * 3 water rises
         */
        addAllTreasureCards();
        shuffleTreasureCards();
    }

    public void addAllTreasureCards()
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                tdeck.add(new Treasure4(treasureCardNames[i], treasureCards[i]));
            }
        }
        for(int i = 0; i < 3; i++)
        {
            tdeck.add(new HelicopterLift("Helicopter", treasureCards[5]));
            tdeck.add(new WaterRise("WaterRise", treasureCards[4]));
        }
        for(int i = 0; i < 2; i++)
        {
            tdeck.add(new Sandbag("Sandbag", treasureCards[6]));
        }
    }

    public Stack<TreasureCard> getActiveTreasureCards()
    {

        return tdeck;
    }

    public Stack<TreasureCard> getDiscardTreasureCards()
    {
        return tdiscard;
    }

    public ArrayList<TreasureCard> getUsedCards()
    {
        return usedCards;
    }

    public void shuffleTreasureCards()
    {
        Collections.shuffle(tdeck, u);

    }

    public void resetTreasureCards()
    {
        Collections.shuffle(tdiscard);
        tdeck.addAll(tdiscard);
        usedCards.removeAll(tdiscard);
        tdiscard =  new Stack<TreasureCard>();

    }

    public TreasureCard draw()
    {
        TreasureCard next = tdeck.pop();
        usedCards.add(next);

        return next;

    }



}
