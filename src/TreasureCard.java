import java.awt.image.BufferedImage;

public class TreasureCard
{
    private String treasureCardName;
    private String treasureCardFunction;
    private BufferedImage b;

    public TreasureCard()
    {
        //treasureCardFunction = Function;
        //treasureCardName = name;
    }

    public String getName()
    {
        return treasureCardName;
    }

    public String getFunction()
    {
        return treasureCardFunction;
    }

    public BufferedImage getBufferedImage()
    {
        return b;
    }

}
