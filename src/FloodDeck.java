/*
 * 	FloodCard_BreakersBridge, FloodCard_BronzeGate, FloodCard_CaveOfEmbers, FloodCard_CaveOfShadows, FloodCard_CliffsOfAbandon, FloodCard_CopperGate, FloodCard_CoralPalace, FloodCard_CrimsonForest, FloodCard_DunesOfDeception, FloodCard_FoolsLanding, FloodCard_GoldGate, FloodCard_HowlingGarden, FloodCard_IronGate, FloodCard_LostLagoon, FloodCard_MistyMarsh, FloodCard_Observatory, FloodCard_PhantomRock, FloodCard_SilverGate, FloodCard_TempleOfTheMoon, FloodCard_TempleOfTheSun, FloodCard_TidalPalace, FloodCard_TwilightHollow, FloodCard_Watchtower, FloodCard_WhisperingGarden,
 */

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

import javax.imageio.ImageIO;

public class FloodDeck {
    private Random u;
    private ArrayList<FloodCard> fdiscard;
    public static Stack<FloodCard> fdeck;
    public static HashMap<String, FloodCard>  FloodMap;
    private BufferedImage FloodCard_BreakersBridge, FloodCard_BronzeGate, FloodCard_CaveOfEmbers, FloodCard_CaveOfShadows, FloodCard_CliffsOfAbandon, FloodCard_CopperGate, FloodCard_CoralPalace, FloodCard_CrimsonForest, FloodCard_DunesOfDeception, FloodCard_FoolsLanding, FloodCard_GoldGate, FloodCard_HowlingGarden, FloodCard_IronGate, FloodCard_LostLagoon, FloodCard_MistyMarsh, FloodCard_Observatory, FloodCard_PhantomRock, FloodCard_SilverGate, FloodCard_TempleOfTheMoon, FloodCard_TempleOfTheSun, FloodCard_TidalPalace, FloodCard_TwilightHollow, FloodCard_Watchtower, FloodCard_WhisperingGarden;
    private BufferedImage[] floodCardBufferedImages;
    private String[] islandNames;
    public static ArrayList<Tile1> remainingTile1s, floodedTile1s, sunkenTile1s;
    private Islands islandsClass;
    private GameBoard gameBoard;

    public FloodDeck(GameBoard gameBoard, Random seed) throws IOException
    {

        /*
         * set up islandNames
         */
        setIslandNames();
        floodCardBufferedImages = new BufferedImage[24];
        setFloodCardBufferedImages();
        try
        {
            for(int i = 0; i < 24; i++)
            {
                floodCardBufferedImages[i] = ImageIO.read(GUIGameBoard.class.getResource("/FloodDeck/FloodCard_" + islandNames[i] + ".png"));
            }
        }
        catch(IndexOutOfBoundsException E)
        {
            System.out.println("FloodDeck Exception");
            return;
        }
        this.gameBoard = gameBoard;
        u = seed;
        /*
         * set up floodCardNames
         */
        fdiscard = new ArrayList<FloodCard>();
        fdeck = new Stack<FloodCard>();
        //map a string to the actual floodcard so u can easily use the floodmap


        /*
         * get flooded tiles Island
         */
        islandsClass = gameBoard.getIslandsClass();
        remainingTile1s = islandsClass.getRemainingTiles();
        floodedTile1s = islandsClass.getFloodedTiles();
        sunkenTile1s = islandsClass.getSunkenTiles();

        /*
         * set up activeFloodCards;
         */
        setActiveFloodCards();
        shuffleFloodDeck();
        /*
         * draw 6 initial flood cards
         */
        for(int i = 0; i < 6; i++)
        {
            draw();
        }

    }

    public void setActiveFloodCards()
    {
        for(int i = 0; i < 24; i++)
        {
            fdeck.push(new FloodCard(floodCardBufferedImages[i], islandNames[i]));
        }
    }

    public void setFloodCardBufferedImages()
    {
        floodCardBufferedImages = new BufferedImage[] {FloodCard_BreakersBridge, FloodCard_BronzeGate, FloodCard_CaveOfEmbers, FloodCard_CaveOfShadows, FloodCard_CliffsOfAbandon, FloodCard_CopperGate, FloodCard_CoralPalace, FloodCard_CrimsonForest, FloodCard_DunesOfDeception, FloodCard_FoolsLanding, FloodCard_GoldGate, FloodCard_HowlingGarden, FloodCard_IronGate, FloodCard_LostLagoon, FloodCard_MistyMarsh, FloodCard_Observatory, FloodCard_PhantomRock, FloodCard_SilverGate, FloodCard_TempleOfTheMoon, FloodCard_TempleOfTheSun, FloodCard_TidalPalace, FloodCard_TwilightHollow, FloodCard_Watchtower, FloodCard_WhisperingGarden};


    }

    public void shuffleFloodDeck()
    {
        Collections.shuffle(fdeck, u);
    }
    public Stack getActiveFloodCards()
    {
        return fdeck;
    }
    /*
        public void draw()
        {
            FloodCard next = fdeck.pop();
            String s = next.getName();
            fdiscard.add(next);
            for(int i = 0; i < remainingTiles.size(); i++)
            {
                if(remainingTiles.get(i).getName().equals(s))
                {
                    remainingTiles.get(i).flood();
                    floodedTiles.add(remainingTiles.get(i));
                    remainingTiles.remove(i);
                }
            }

        }*/
    //new
    public Tile1 draw()
    {
        FloodCard next = fdeck.pop();
        String s = next.getName();
        fdiscard.add(next);
        //added this loop to sink tiles
        Tile1 ret=null;
        for(int i = 0; i< floodedTile1s.size(); i++)
        {
            if(floodedTile1s.get(i).getName().equals(s)) {
                floodedTile1s.get(i).flood();
                sunkenTile1s.add(floodedTile1s.get(i));
                ret = floodedTile1s.remove(i);
                fdiscard.remove(fdiscard.size() - 1);
                if(fdeck.isEmpty())
                    resetFloodCards();
                return ret;
            }
        }
        for(int i = 0; i< remainingTile1s.size(); i++){
            if(remainingTile1s.get(i).getName().equals(s)){
                remainingTile1s.get(i).flood();
                floodedTile1s.add(remainingTile1s.get(i));
                ret= remainingTile1s.remove(i);
                //System.out.println(ret.getName());
                if(fdeck.isEmpty())
                    resetFloodCards();
                return ret;
            }
        }
        return ret;
        // return null;
    }
    /*
    public void resetFloodCards() 
    {
        Collections.shuffle(fdiscard);
        fdeck.addAll(fdiscard);
        fdiscard =  new ArrayList<FloodCard>(); 
    }*/

    //new
    public void resetFloodCards()
    {
        Collections.shuffle(fdiscard);
        for(FloodCard a: fdiscard){
            fdeck.push(a);
        }
        fdiscard =  new ArrayList<FloodCard>();
    }

    public ArrayList<FloodCard> getUsedFloodCards()
    {
        return fdiscard;
    }

    public void setIslandNames()
    {
        islandNames = new String[] {"BreakersBridge", "BronzeGate", "CaveOfEmbers", "CaveOfShadows", "CliffsOfAbandon", "CopperGate", "CoralPalace", "CrimsonForest","DunesOfDeception", "FoolsLanding", "GoldGate", "HowlingGarden", "IronGate", "LostLagoon", "MistyMarsh", "Observatory", "PhantomRock", "SilverGate", "TempleOfTheMoon", "TempleOfTheSun", "TidalPalace", "TwilightHollow", "Watchtower", "WhisperingGarden"};
    }
}
