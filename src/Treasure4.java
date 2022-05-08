import java.awt.image.BufferedImage;

public class Treasure4 extends TreasureCard
{

    private String relatedTreasure;
    private BufferedImage b;
    private int id;
    public Treasure4(String str, BufferedImage b)
    {
        super();
        this.b = b;
        relatedTreasure = str;
        switch(str)
        {
            case "Card_CrystalOfFire":
                id = 0;
                break;
            case "Card_EarthStone":
                id = 1;
                break;
            case "Card_OceansChalice":
                id = 2;
                break;
            case "Card_StatueOfTheWind":
                id = 3;
                break;
        }
    }

    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return relatedTreasure;
    }

    public BufferedImage getBufferedImage()
    {
        return b;
    }
}
