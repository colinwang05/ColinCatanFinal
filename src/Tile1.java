import java.awt.image.BufferedImage;

public class Tile1 {
    private String tileName, relatedPlayer, relatedTreasure;
    private boolean helicopter, selected;
    private int xpos, ypos, floodState;
    private BufferedImage tile, tile_flood;

    public Tile1(String name, boolean heli, int xpos, int ypos, int floodstate,
                 boolean selected, BufferedImage tile, BufferedImage tile_flood)
    {
        tileName = name;
        relatedPlayer = setRelatedPlayer(tileName);
        relatedTreasure = "will add setRelatedTreasure later";
        helicopter = heli;
        this.xpos = xpos;
        this.ypos = ypos;
        floodState = floodstate;
        /*
         * 1: not flooded
         * 0: flooded
         * -1: sunk
         */
        this.selected = selected;
        this.tile = tile;
        this.tile_flood = tile_flood;

    }

    public String setRelatedPlayer(String name)
    {
        if (name.equals("IronGate") || name.equals("IronGate_flood"))//Pown_Diver
        {
            return "Diver";
        }
        else if (name.equals("BronzeGate") || name.equals("BronzeGate_flood"))//Pown_Engineer
        {
            return "Engineer";
        }
        else if (name.equals("CopperGate") || name.equals("CopperGate_flood"))//Pown_Explorer
        {
            return "Explorer";
        }
        else if (name.equals("SilverGate") || name.equals("SilverGate_flood"))//Pown_Messenger
        {
            return "Messenger";
        }
        else if (name.equals("GoldGate") || name.equals("GoldGate_flood"))//Pown_Navigator
        {
            return "Navigator";
        }
        else if (name.equals("FoolsLanding") || name.equals("FoolsLanding_flood"))//Pown_Pilot
        {
            return "Pilot";
        }
        return "";
    }

    public void setFloodState(int i)
    {
        floodState = i;
    }

    public String getRelatedPlayer()
    {
        return relatedPlayer;
    }

    public BufferedImage getTileBufferedImage()
    {
        return tile;
    }

    public BufferedImage getTileBufferedImage_flood()
    {
        return tile_flood;
    }

    public String getName()
    {
        return tileName;
    }

    public String getRelatedTreasure()
    {
        return relatedTreasure;
    }

    public boolean getHelicopter()
    {
        return helicopter;
    }

    public int getXPos()
    {
        return xpos;
    }

    public int getYPos()
    {
        return ypos;
    }

    public void flood()
    {
        if (floodState != -1)
        {
            floodState--;
        }
        else
            sunk();
    }

    public void sunk()
    {
        floodState = -1;
    }

    public int getFloodState()
    {
        return floodState;
    }

    public void shoreUp()
    {
        if (floodState==0) {
            floodState++;
        }
    }
}
