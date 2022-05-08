import java.awt.image.BufferedImage;
import java.util.Collections;

public class WaterRise extends TreasureCard
{

    //private boolean waterRise;
    private BufferedImage b;
    private String name;

    public WaterRise(String name, BufferedImage b)
    {
        super();
        this.b = b;
        this.name = name;
    }

    public void rise()
    {
        //GameBoard.meter.waterRises();
        Collections.shuffle(GameBoard.floodDeck.getUsedFloodCards());
        for (FloodCard f : GameBoard.floodDeck.getUsedFloodCards())
        {
            //GameBoard.floodDeck.FDeck().add(f);

        }
        GameBoard.floodDeck.getUsedFloodCards().clear();
    }

    public BufferedImage getBufferedImage()
    {
        return b;
    }

    public String getName()
    {
        return name;
    }
}
