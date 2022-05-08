
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.imageio.ImageIO;

public class Islands {
    private Random u;
    private ArrayList<Tile1> allTile1s, remainingTile1s, floodedTile1s, sunkenTile1s = new ArrayList<>(), tilesNotSunk;
    private ArrayList<ArrayList<Tile1>> allTiles_2D;
    public static Tile1[][] tile1Location;
    public static String[] islandNames;
    private boolean tilenamevisited[];
    public HashMap<String, Tile1> tileMap;
    private BufferedImage BreakersBridge, BronzeGate, CaveOfEmbers, CaveOfShadows, CliffsOfAbandon, CopperGate, CoralPalace, CrimsonForest, DunesOfDeception, FoolsLanding, GoldGate, HowlingGarden, IronGate, LostLagoon, MistyMarsh, Observatory, PhantomRock, SilverGate, TempleOfTheMoon, TempleOfTheSun, TidalPalace, TwilightHollow, Watchtower, WhisperingGarden,
            BreakersBridge_flood, BronzeGate_flood, CaveOfEmbers_flood, CaveOfShadows_flood, CliffsOfAbandon_flood, CopperGate_flood, CoralPalace_flood, CrimsonForest_flood, DunesOfDeception_flood, FoolsLanding_flood, GoldGate_flood, HowlingGarden_flood, IronGate_flood, LostLagoon_flood, MistyMarsh_flood, Observatory_flood, PhantomRock_flood, SilverGate_flood, TempleOfTheMoon_flood, TempleOfTheSun_flood, TidalPalace_flood, TwilightHollow_flood, Watchtower_flood, WhisperingGarden_flood;
    private BufferedImage[] islands, islands_flood;


    public Islands(Random u)
    {
        setIsland();
        try
        {
            for(int i = 0; i < islandNames.length; i++)
            {
                islands[i] = ImageIO.read(GUIGameBoard.class.getResource("/Islands/" + islandNames[i] + ".png"));
            }
            for(int i = 0; i < islandNames.length; i++)
            {
                islands_flood[i] = ImageIO.read(GUIGameBoard.class.getResource("/Islands/" + islandNames[i] + "_flood.png"));
            }
        }
        catch(Exception E)
        {
            System.out.println("Exception");
            return;
        }
        this.u = u;
        tileMap = new HashMap<String, Tile1>();
        tilenamevisited = new boolean[24];
        tile1Location = new Tile1[6][6];
        allTile1s = new ArrayList<Tile1>();
        allTiles_2D = new ArrayList<ArrayList<Tile1>>();//specifically used for Diver
        tilesNotSunk = new ArrayList<Tile1>();
        for(int i = 0; i < 6; i++)
        {
            allTiles_2D.add(new ArrayList<Tile1>());
            for(int j = 0; j < 6; j++)
            {
                allTiles_2D.get(i).add(new Tile1("", false, 0, 0, 1, false, islands[0], islands_flood[0]));
            }
        }
        remainingTile1s = new ArrayList<Tile1>();
        floodedTile1s = new ArrayList<Tile1>();
        /*
         * creat Tile, assign random x and y positions, add them to tileMap, tileLocation, and remainingTile
         * Tile name=new Tile(name,player,treasure,heli,xpos,ypos,floodstate);
         */
        while (!checkFilled())
        {
            int x = (int) (u.nextInt(6));
            int y = (int) (u.nextInt(6));
            if (isValid(x, y))
            {
                if (tile1Location[x][y] == null)
                {
                    int name = (int) (u.nextInt(24));
                    while (tilenamevisited[name])
                    {
                        name = (int) (u.nextInt(24));
                    }
                    tilenamevisited[name] = true;
                    String str = islandNames[name];
                    int index = getTileIndex(str);
                    Tile1 n = new Tile1(str, false, x, y, 1, false, islands[index], islands_flood[index]);
                    tile1Location[x][y] = n;
                    tileMap.put(islandNames[name], n);
                    remainingTile1s.add(n);
                    allTile1s.add(n);
                    allTiles_2D.get(x).add(y, n);
                }
            }
        }
    }

    private void setIsland()
    {
        islandNames = new String[] {"BreakersBridge", "BronzeGate", "CaveOfEmbers", "CaveOfShadows", "CliffsOfAbandon", "CopperGate", "CoralPalace", "CrimsonForest","DunesOfDeception", "FoolsLanding", "GoldGate", "HowlingGarden", "IronGate", "LostLagoon", "MistyMarsh", "Observatory", "PhantomRock", "SilverGate", "TempleOfTheMoon", "TempleOfTheSun", "TidalPalace", "TwilightHollow", "Watchtower", "WhisperingGarden"};
        islands = new BufferedImage[] {BreakersBridge, BronzeGate, CaveOfEmbers, CaveOfShadows, CliffsOfAbandon, CopperGate, CoralPalace, CrimsonForest, DunesOfDeception, FoolsLanding, GoldGate, HowlingGarden, IronGate, LostLagoon, MistyMarsh, Observatory, PhantomRock, SilverGate, TempleOfTheMoon, TempleOfTheSun, TidalPalace, TwilightHollow, Watchtower, WhisperingGarden};
        islands_flood = new BufferedImage[] {BreakersBridge_flood, BronzeGate_flood, CaveOfEmbers_flood, CaveOfShadows_flood, CliffsOfAbandon_flood, CopperGate_flood, CoralPalace_flood, CrimsonForest_flood, DunesOfDeception_flood, FoolsLanding_flood, GoldGate_flood, HowlingGarden_flood, IronGate_flood, LostLagoon_flood, MistyMarsh_flood, Observatory_flood, PhantomRock_flood, SilverGate_flood, TempleOfTheMoon_flood, TempleOfTheSun_flood, TidalPalace_flood, TwilightHollow_flood, Watchtower_flood, WhisperingGarden_flood};
    }

    public ArrayList<ArrayList<Tile1>> getAllTiles_2D()
    {
        return allTiles_2D;
    }

    private int getTileIndex(String n)
    {
        int index = 0;
        for(int i = 0; i < 24; i++)
        {
            if(islandNames[i].compareTo(n) == 0)
            {
                index = i;
            }
        }
        return index;
    }

    public Tile1[][] getTileLocation() {
        return tile1Location;
    }

    public ArrayList<Tile1> getAllTiles() {
        return allTile1s;
    }

    public ArrayList<Tile1> getRemainingTiles() {
        return remainingTile1s;
    }

    public ArrayList<Tile1> getFloodedTiles() {
        floodedTile1s = new ArrayList<Tile1>();
        for(Tile1 t : allTile1s)
        {
            if(t.getFloodState() == 0)
            {
                floodedTile1s.add(t);
            }
        }
        return floodedTile1s;
    }

    public ArrayList<Tile1> getSunkenTiles() {
        return sunkenTile1s;
    }

    public ArrayList<Tile1> getTilesNotSunk()//flood and not flooded
    {
        allTile1s = getAllTiles();
        for(Tile1 t : allTile1s)
        {
            if(t.getFloodState() != -1)
            {
                tilesNotSunk.add(t);
            }
        }
        return tilesNotSunk;
    }


    public boolean canMove(int x, int y) {
        return tile1Location[x][y].getFloodState() != -1;
    }

    public boolean checkFilled() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (isValid(i, j)) {
                    if (tile1Location[i][j] == null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValid(int x, int y) {
        if (x < 0 || x > 5 || y < 0 || y > 5) {
            return false;
        }
        if (x == 0 || x == 5) {
            return y == 2 || y == 3;
        }
        if (x == 1 || x == 4) {
            return y != 0 && y != 5;
        }
        if (x == 2 || x == 3) {
            return true;
        }
        return false;
    }
}
