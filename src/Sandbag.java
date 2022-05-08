import java.awt.image.BufferedImage;

public class Sandbag extends TreasureCard
{
    private BufferedImage b;
    private String name;

    public Sandbag(String name, BufferedImage b)
    {
        super();
        this.b = b;
        this.name = name;
    }

    public void use(int x, int y)
    {
        if (GameBoard.islands.isValid(x, y))
        {
            Islands.tile1Location[x][y].shoreUp();
        }
        //GameBoard.players.get(GameBoard.currentPlayer).discardTreasureCard((new Sandbag()));
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
