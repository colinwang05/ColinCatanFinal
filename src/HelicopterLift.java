import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class HelicopterLift extends TreasureCard
{
    private BufferedImage b;
    private String name;

    public HelicopterLift(String name, BufferedImage b)
    {
        super();
        this.b = b;
        this.name = name;
    }

    public void use(ArrayList<Player1> p, int x1, int y1, int x2, int y2)
    {
        //GameBoard.players.get(GameBoard.currentPlayer).discardTreasureCard((new HelicopterLift()));
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
